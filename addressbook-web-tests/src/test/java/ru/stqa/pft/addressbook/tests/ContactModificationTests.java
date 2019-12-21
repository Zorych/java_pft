package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      ContactData newContact = new ContactData()
                                       .withFirstName("Игорь")
                                       .withMiddleName("Сергеевич")
                                       .withLastName("Григорьев")
                                       .withAddress("test_address")
                                       .withPhoto("src/test/resources/ava.jpg");
      app.contact().create(true, newContact);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
                                  .withId(modifiedContact.getId())
                                  .withFirstName("Игорь_mod")
                                  .withMiddleName("Сергеевич_mod")
                                  .withLastName("Григорьев_mod")
                                  .withAddress("test_address_mod")
                                  .withPhoto("src/test/resources/ava.jpg");
    app.contact().modify(contact);

    assertThat(app.contact().getContactCount(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}