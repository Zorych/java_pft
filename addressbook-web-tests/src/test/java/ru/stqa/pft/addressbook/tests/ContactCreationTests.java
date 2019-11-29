package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    ContactData testContact = new ContactData("Игорь", "Сергеевич", "Григорьев");
    testContact.setNickName("Zorych");
    testContact.setTitle("test_title");
    testContact.setCompany("test_company");
    testContact.setAddress("test_address");
    testContact.setHomePhone("111111");
    testContact.setMobilePhone("222222");
    testContact.setWorkPhone("333333");
    testContact.setFaxPhone("444444");
    testContact.setEmail("test_e-mail");
    testContact.setEmail2("test_e-mail2");
    testContact.setEmail3("test_e-mail3");
    testContact.setHomepage("https://www.linkedin.com/in/igor-grigorev-3a657a18b/");
    testContact.setBirthday("14", "May", "1991");
    testContact.setAnniversary("15", "April", "1992");
    testContact.setSecAddress("test_secondary-address");
    testContact.setSecPhone("555555");
    testContact.setSecNotes("test_secondary-notes");
    app.getNavigationHelper().goToContactCreationPage();
    app.getContactHelper().fillContactForm(testContact);
    app.getContactHelper().pushSaveContactButton();
    app.getNavigationHelper().goToHomePage();
  }
}
