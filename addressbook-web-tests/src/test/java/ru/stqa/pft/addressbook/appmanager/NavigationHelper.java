package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.pft.addressbook.model.GroupData;

public class NavigationHelper extends BaseHelper {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void homePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void contactsInGroup(GroupData group) {
    if (isElementPresent(By.name("remove"))
                && wd.getCurrentUrl().contains("addressbook/?group=" + group.getId())) {
      return;
    }
    wd.get("http://localhost/addressbook/?group=" + group.getId());
    WebDriverWait wait = new WebDriverWait(wd, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maintable")));
  }

  public void goToContactCreationPage() {
    if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
                && isElementPresent(By.name("new_group"))
                && isElementPresent(By.name("submit"))) {
      return;
    }
    click(By.linkText("add new"));
  }
}