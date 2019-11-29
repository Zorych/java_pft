package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    ContactData newContact = new ContactData("Игорь", "Сергеевич", "Григорьев", "test_address",null);
    newContact.setNickName("Zorych");
    newContact.setTitle("test_title");
    newContact.setCompany("test_company");
    newContact.setHomePhone("111111");
    newContact.setMobilePhone("222222");
    newContact.setWorkPhone("333333");
    newContact.setFaxPhone("444444");
    newContact.setEmail("test_e-mail");
    newContact.setEmail2("test_e-mail2");
    newContact.setEmail3("test_e-mail3");
    newContact.setHomepage("https://www.linkedin.com/in/igor-grigorev-3a657a18b/");
    newContact.setBirthday(null, "May", "1991");
    newContact.setAnniversary(null, "April", "1992");
    newContact.setSecAddress("test_secondary-address");
    newContact.setSecPhone("555555");
    newContact.setSecNotes("test_secondary-notes");
    app.getContactHelper().createContact(true, newContact);
  }
}