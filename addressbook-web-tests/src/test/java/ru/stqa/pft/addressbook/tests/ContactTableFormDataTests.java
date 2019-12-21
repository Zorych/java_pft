package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactTableFormDataTests extends TestBase {
  private ContactData contact = new ContactData();
  private ContactData contactInfoFromEditForm = new ContactData();

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      ContactData contact = new ContactData()
                                    .withFirstName("Игорь")
                                    .withMiddleName("Сергеевич")
                                    .withLastName("Григорьев")
                                    .withAddress("ул. Каретный ряд 10/2, 2 этаж")
                                    .withPhoto("src/test/resources/ava.jpg")
                                    .withNickName("Zorych")
                                    .withTitle("test_title")
                                    .withCompany("test_company")
                                    .withHomePhone("+7 (111)11-11")
                                    .withMobilePhone("2-2 2-2 22")
                                    .withWorkPhone("333333")
                                    .withEmail("kaze250t@gmail.com")
                                    .withEmail3("zorych250t@yandex.ru")
                                    .withHomepage("https://www.linkedin.com/in/igor-grigorev-3a657a18b/")
                                    .withBirthday("11", "May", "1991")
                                    .withAnniversary("15", "April", "1992")
                                    .withSecAddress("test_secondary-address")
                                    .withSecPhone("555555")
                                    .withSecNotes("test_secondary-notes");
      app.contact().create(true, contact);
    }
    app.goTo().homePage();
    contact = app.contact().all().iterator().next();
    contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }

  @Test
  public void testContactPhones() {
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  @Test
  public void testContactEmails() {
    assertThat(contact.getAllMails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  @Test
  public void testContactAddress() {
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
  }

  // склейка телефонов
  private String mergePhones(ContactData contact) {
    return Stream.of(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getHome2Phone())
                   .filter((s) -> !s.equals(""))
                   .map(ContactTableFormDataTests::cleaned)
                   .collect(Collectors.joining("\n"));
  }

  // удаление лишних символов в номере телефона
  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  // склейка Email'ов
  private String mergeEmails(ContactData contact) {
    return Stream.of(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                   .filter((m) -> !m.equals(""))
                   .collect(Collectors.joining("\n"));
  }
}