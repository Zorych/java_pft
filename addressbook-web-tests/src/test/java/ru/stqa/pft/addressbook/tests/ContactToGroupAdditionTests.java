package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactToGroupAdditionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }

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
  public void addContactToGroupTest() {
    Groups groups = app.db().groups();
    app.goTo().homePage();

    // выбираем случайный контакт и сохраняем список его групп
    ContactData contactToAddInGroup = app.db().contacts().iterator().next();
    Groups contactGroupsBefore = contactToAddInGroup.getGroups();

    // условие, в котором проверяются группы контакта со всеми группами.
    // Если списки совпадают, то создаём новую группу, иначе выбираем группу не из списка групп контакта
    GroupData groupToAddTo;
    if (contactToAddInGroup.getGroups().equals(groups)) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName(String.format("test%s", Collections.max(app.db().groups(), Comparator.comparing(GroupData::getId)).getId()+1)));
      app.goTo().homePage();
      groupToAddTo = Collections.max(app.db().groups(), Comparator.comparing(GroupData::getId));
      app.contact().addToGroup(contactToAddInGroup, groupToAddTo.getId());
    } else {
      groupToAddTo = groups.stream()
                             .filter(g -> !contactToAddInGroup.getGroups().contains(g)).collect(Collectors.toSet()).iterator().next(); //выбираем группу, которой нет в списке групп контакта
      app.contact().addToGroup(contactToAddInGroup, groupToAddTo.getId());
    }

    Set<Integer> groupContactsDbIds = app.db().groups().stream()
                                              .filter(g -> g.getId() == groupToAddTo.getId())
                                              .findFirst().get()
                                              .getContacts().stream()
                                              .map(ContactData::getId).collect(Collectors.toSet());
    Set<Integer> groupContactsUIIds = app.contact().all().stream()
                                              .map(ContactData::getId).collect(Collectors.toSet());
    //проверяем, что список айдишников контактов групп в UI совпадает со списком айдишников в БД
    assertThat(groupContactsUIIds, equalTo(groupContactsDbIds));


    Groups contactGroupsAfter = app.db().contacts().stream()
                                        .filter(c -> c.getId() == contactToAddInGroup.getId())
                                        .findFirst().get()
                                        .getGroups();
    // проверяем что:
    // 1. кол-во контактов в интерфейсе совпадает со значением счётчика "Number of results" страницы списка контактов группы
    // 2. кол-во групп после = кол-во групп до + 1
    // 3. группа записалась верно
    assertThat(app.contact().all().size(), equalTo(app.contact().countInGroup(groupToAddTo)));
    assertThat(contactGroupsAfter.size(), equalTo(contactGroupsBefore.size() + 1));
    assertThat(contactGroupsAfter, equalTo(contactGroupsBefore.withAdded(groupToAddTo)));
  }
}