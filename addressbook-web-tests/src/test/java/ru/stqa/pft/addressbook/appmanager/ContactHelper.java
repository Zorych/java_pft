package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

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
    click(By.name("selected[]"));
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }
}
