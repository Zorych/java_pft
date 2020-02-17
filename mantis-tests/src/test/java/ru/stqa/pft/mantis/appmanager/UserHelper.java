package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

public class UserHelper extends BaseHelper {

  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void changePassword(UserData user, String newPassword) {

  }

  public void initUserModificationById(int id) {
    click(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + id + "']"));
  }


}
