package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Игорь_mod", "Сергеевич_mod", "Григорьев_mod", "Zorych_mod", "test_title_mod", "test_company_mod", "test_address_mod", "666666", "777777", "888888", "999999", "test_e-mail_mod", "test_e-mail2_mod", "test_e-mail3_mod", "https://www.linkedin.com/in/igor-grigorev-3a657a18b/", "May", "14", "1991", "June", "20", "2019", "test_secondary-address_mod", "10101010", "test_secondary-notes_mod"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();
  }
}
