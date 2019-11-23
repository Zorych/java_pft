package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().goToContactCreationPage();
    app.getContactHelper().fillContactForm(new ContactData("Игорь", "Сергеевич", "Григорьев", "Zorych", "test_title", "test_company", "test_address", "111111", "222222", "333333", "444444", "test_e-mail", "test_e-mail2", "test_e-mail3", "https://www.linkedin.com/in/igor-grigorev-3a657a18b/", "May", "14", "1991", "April", "15", "2000", "test_secondary-address", "555555", "test_secondary-notes"));
    app.getContactHelper().pushSaveContactButton();
    app.getNavigationHelper().goToHomePage();
  }
}
