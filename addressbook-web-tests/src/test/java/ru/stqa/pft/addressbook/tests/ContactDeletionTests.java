package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (app.getContactHelper().isThereAContact()) {
      ContactData newContact = new ContactData("Игорь", "Сергеевич", "Григорьев", "test_address",null);
      app.getContactHelper().createContact(true, newContact);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);

//    for (ContactData con : before) {
//      System.out.println("before " + con);
//    }
//    for (ContactData con2 : after) {
//      System.out.println("after " + con2);
//    }

    Assert.assertEquals(before, after);
  }
}