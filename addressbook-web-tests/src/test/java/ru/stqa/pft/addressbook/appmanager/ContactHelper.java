package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

  public void deleteAllContacts() {
    click(By.id("MassCB"));
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactCreation() {
    click(By.xpath("//a[contains(text(),'add new')]"));
  }

  public void initContactModification(int id) {
    //click(By.xpath("//img[@alt='Edit']"));
    click(By.xpath("//a[@href='edit.php?id=" + id + "']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void createContact(boolean isCreation, ContactData contact) {
    initContactCreation();
    fillContactForm(isCreation, contact);
    pushSaveContactButton();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return !isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for(WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String lastName = element.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
      String firstName = element.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
      String address = element.findElement(By.cssSelector("td:nth-of-type(4)")).getText();
      ContactData contact = new ContactData(id, firstName, lastName, address);
      contacts.add(contact);
    }
    return contacts;
  }
}