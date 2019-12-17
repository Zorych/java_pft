package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

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
    Set<ContactData> before = app.contact().all();
    app.contact().create(true, contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(before.size() + 1, after.size());

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}