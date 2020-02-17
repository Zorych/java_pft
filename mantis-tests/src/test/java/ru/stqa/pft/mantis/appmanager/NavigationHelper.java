package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void homePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void controlPage() {
    if (wd.getCurrentUrl().contains("/manage_overview_page.php")){
      return;
    }
    click(By.linkText("Управление"));
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