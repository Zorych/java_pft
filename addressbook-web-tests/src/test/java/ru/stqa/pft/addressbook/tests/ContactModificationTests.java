package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    ContactData testContact = new ContactData("Игорь_mod","Сергеевич_mod","Григорьев_mod");
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(testContact);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();
  }
}
