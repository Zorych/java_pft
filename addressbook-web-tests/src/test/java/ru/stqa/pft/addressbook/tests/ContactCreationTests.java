package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    ContactData contact = new ContactData()
                                     .withFirstName("Игорь")
                                     .withMiddleName("Сергеевич")
                                     .withLastName("Григорьев")
                                     .withAddress("test_address")
                                     .withNickName("Zorych")
                                     .withTitle("test_title")
                                     .withCompany("test_company")
                                     .withHomePhone("111111")
                                     .withMobilePhone("222222")
                                     .withWorkPhone("333333")
                                     .withEmail("test_e-mail")
                                     .withEmail2("test_e-mail2")
                                     .withEmail3("test_e-mail3")
                                     .withHomepage("https://www.linkedin.com/in/igor-grigorev-3a657a18b/")
                                     .withBirthday("11", "May", "1991")
                                     .withAnniversary("15", "April", "1992")
                                     .withSecAddress("test_secondary-address")
                                     .withSecPhone("555555")
                                     .withSecNotes("test_secondary-notes");
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().create(true, contact);

    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}