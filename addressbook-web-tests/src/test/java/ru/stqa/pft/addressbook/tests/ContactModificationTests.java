package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      ContactData newContact = new ContactData("test_name", "test_middlename", "test_lastname", "test_address",null);
      app.getContactHelper().createContact(true, newContact);
    }
    ContactData modContact = new ContactData("name_mod", "middlename_mod", "lastname_mod", "address_mod",null);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(false, modContact);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}