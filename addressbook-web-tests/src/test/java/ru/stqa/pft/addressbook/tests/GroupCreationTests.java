package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    // открываем страницу со списком групп
    app.getNavigationHelper().goToGroupPage();

    // сохраняем список имеющихся групп (до создания новой группы)
    List<GroupData> before = app.getGroupHelper().getGroupList();

    // создаём объект типа GroupData и указываем данные для новой группы
    GroupData group = new GroupData("test1", "test2", "test3");

    // вызываем метод создания группы
    app.getGroupHelper().createGroup(group);

    // сохраняем список групп после создания новой группы
    List<GroupData> after = app.getGroupHelper().getGroupList();

    // проверяем, что после создания кол-во групп стало +1
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}