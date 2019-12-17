package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      ContactData newContact = new ContactData()
                                       .withFirstName("Игорь")
                                       .withMiddleName("Сергеевич")
                                       .withLastName("Григорьев")
                                       .withAddress("test_address");
      app.contact().create(true, newContact);
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
                                     .withId(modifiedContact.getId())
                                     .withFirstName("Игорь_mod")
                                     .withMiddleName("Сергеевич_mod")
                                     .withLastName("Григорьев_mod")
                                     .withAddress("test_address_mod");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}