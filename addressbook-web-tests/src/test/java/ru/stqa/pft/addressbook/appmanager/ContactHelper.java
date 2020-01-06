package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.List;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void pushSaveContactButton() {
    click(By.name("submit"));
  }

  public void fillContactForm(boolean isCreation, ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    attach(By.name("photo"), new File(contactData.getPhoto()));
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFaxPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getHomepage());
    fillDropList(By.name("bday"), contactData.getbDay());
    fillDropList(By.name("bmonth"), contactData.getbMonth());
    type(By.name("byear"), contactData.getbYear());
    fillDropList(By.name("aday"), contactData.getADay());
    fillDropList(By.name("amonth"), contactData.getAMonth());

    if (isCreation) {
      fillDropList(By.name("new_group"), contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    type(By.name("ayear"), contactData.getAYear());
    type(By.name("address2"), contactData.getSecAddress());
    type(By.name("phone2"), contactData.getSecPhone());
    type(By.name("notes"), contactData.getNotes());
  }

  public void deleteAll() {
    click(By.id("MassCB"));
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    contactCache = null;
  }

  public void deleteSelected() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void initContactCreation() {
    click(By.xpath("//a[contains(text(),'add new')]"));
  }

  public void initContactModificationById(int id) {
    click(By.cssSelector("a[href='edit.php?id=" + id + "']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void create(boolean isCreation, ContactData contact) {
    initContactCreation();
    fillContactForm(isCreation, contact);
    pushSaveContactButton();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData modContact) {
    initContactModificationById(modContact.getId());
    fillContactForm(false, modContact);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelected();
    contactCache = null;
    WebDriverWait wait = new WebDriverWait(wd,5);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.msgbox")));
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String home2 = wd.findElement(By.name("phone2")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");

    wd.navigate().back();
    return new ContactData()
                   .withId(contact.getId())
                   .withFirstName(firstname)
                   .withLastName(lastname)
                   .withAddress(address)
                   .withHomePhone(home)
                   .withMobilePhone(mobile)
                   .withWorkPhone(work)
                   .withHome2Phone(home2)
                   .withEmail(email)
                   .withEmail2(email2)
                   .withEmail3(email3);
  }

  private void selectContactById(int id) {
    click(By.cssSelector("input[id='" + id + "']"));
  }

  public boolean isThereAContact() {
    return !isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allTextMails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      contactCache.add(new ContactData()
                               .withId(id)
                               .withFirstName(firstName)
                               .withLastName(lastName)
                               .withAddress(address)
                               .withAllMails(allTextMails)
                               .withAllPhones(allPhones));
    }
    return new Contacts(contactCache);
  }
}