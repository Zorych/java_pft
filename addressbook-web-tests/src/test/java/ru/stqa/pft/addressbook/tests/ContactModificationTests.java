package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test(enabled = false)
  public void testContactModification() {
    if (app.getContactHelper().isThereAContact()) {
      ContactData newContact = new ContactData("test_name", "test_middlename", "test_lastname", "test_address",null);
      app.getContactHelper().createContact(true, newContact);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData modContact = new ContactData(before.get(before.size() - 1).getId(), "name_mod", "lastname_mod", "address_mod");
    app.getContactHelper().initContactModification(before.get(before.size() - 1).getId());
    app.getContactHelper().fillContactForm(false, modContact);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(modContact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}