package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void pushSaveContactButton() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(boolean isCreation, ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
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
    type(By.name("notes"), contactData.getSecNotes());
  }

  public void deleteAll() {
    click(By.id("MassCB"));
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
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
    returnToHomePage();
  }

  public void modify(ContactData modContact) {
    initContactModificationById(modContact.getId());
    fillContactForm(false, modContact);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    System.out.println(contact.getId());
    deleteSelected();
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

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for(WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String lastName = element.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
      String firstName = element.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
      String address = element.findElement(By.cssSelector("td:nth-of-type(4)")).getText();
      contacts.add(new ContactData()
                           .withId(id)
                           .withFirstName(firstName)
                           .withLastName(lastName)
                           .withAddress(address));
    }
    return contacts;
  }

}