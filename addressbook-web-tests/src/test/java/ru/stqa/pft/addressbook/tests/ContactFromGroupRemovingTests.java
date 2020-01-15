package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactFromGroupRemovingTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    Groups groups = app.db().groups();
    if (groups.size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }

    if (app.db().contacts().size() == 0) {
      ContactData newContact = new ContactData()
                                       .withFirstName("Игорь")
                                       .withMiddleName("Сергеевич")
                                       .withLastName("Григорьев")
                                       .withAddress("test_address")
                                       .inGroup(groups.iterator().next())
                                       .withPhoto("src/test/resources/ava.jpg");
      app.contact().create(true, newContact);
    }
  }

  @Test
  public void removeContactFromGroupTest() {
    Groups groups = app.db().groups();
    app.goTo().homePage();

    // условие, в котором проверяется наличие групп с закреплёнными контактами
    // если такая группа есть, используем её
    // иначе добавляем контакт в группу и используем эту группу
    GroupData groupToDeleteFrom;
    if (groups.stream().anyMatch(g -> g.getContacts().size() != 0)) {
      groupToDeleteFrom = groups.stream()
                                  .filter(g -> g.getContacts().size() != 0)
                                  .findFirst()
                                  .get();
    } else {
      groupToDeleteFrom = groups.iterator().next();
      app.contact().addToGroup(app.db().contacts().iterator().next(), groupToDeleteFrom.getId());
    }
    app.goTo().contactsInGroup(groupToDeleteFrom);
    Contacts groupContactsBefore = app.db().groups().stream()
                                           .filter(g -> g.getId() == groupToDeleteFrom.getId())
                                           .findFirst()
                                           .get()
                                           .getContacts();
    ContactData contactToRemove = groupContactsBefore.iterator().next();
    // удаляем выбранный контакт из группы
    app.contact().removeFromCurrentGroup(contactToRemove);

    // контакты группы после удаления контакта из группы
    Contacts groupContactsAfter = app.db().groups().stream()
                                          .filter(g -> g.getId() == groupToDeleteFrom.getId())
                                          .findFirst()
                                          .get()
                                          .getContacts();

    // проверяем что:
    // 1. кол-во контактов совпадает со значением счётчика "Number of results" страницы списка контактов группы
    // 2. кол-во контактов после = кол-во контактов до - 1
    // 3. удалился правильный контакт
    assertThat(groupContactsAfter.size(), equalTo(app.contact().countInGroup(groupToDeleteFrom)));
    assertThat(groupContactsAfter.size(), equalTo(groupContactsBefore.size() - 1));
    assertThat(groupContactsAfter, equalTo(groupContactsBefore.without(contactToRemove)));
  }
}
