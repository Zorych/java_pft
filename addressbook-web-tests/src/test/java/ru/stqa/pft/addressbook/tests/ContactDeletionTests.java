package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (! app.getContactHelper().isThereAContact()) {
      ContactData newContact = new ContactData("Игорь", "Сергеевич", "Григорьев", "test_address",null);
      app.getContactHelper().createContact(true, newContact);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
  }
}