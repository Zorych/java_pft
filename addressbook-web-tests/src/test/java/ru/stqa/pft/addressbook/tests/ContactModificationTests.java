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
    if (app.db().contacts().size() == 0) {
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
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
                                  .withId(modifiedContact.getId())
                                  .withFirstName("Игорь_mod")
                                  .withMiddleName("Сергеевич_mod")
                                  .withLastName("Григорьев_mod")
                                  .withAddress("ул. Каретный ряд 10/2, 2 mod")
                                  .withPhoto("src/test/resources/ava.jpg")
                                  .withNickName("Zorych_mod")
                                  .withTitle("test_title_mod")
                                  .withCompany("test_company_mod")
                                  .withHomePhone("+7 (111)11-11")
                                  .withMobilePhone("2-2 2-2 22")
                                  .withWorkPhone("333333")
                                  .withFaxPhone("444444")
                                  .withEmail("kaze250t@gmail.comod")
                                  .withEmail2("lolmod@mod.mod")
                                  .withEmail3("zorych250t@yandex.rumod")
                                  .withHomepage("https://www.linkedin.com/in/igor-grigorev-3a657a18b/")
                                  .withBirthday("11", "May", "1991")
                                  .withAnniversary("15", "April", "1992")
                                  .withSecAddress("test_secondary-address_mod")
                                  .withSecPhone("555555")
                                  .withSecNotes("test_secondary-notes_mod");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}