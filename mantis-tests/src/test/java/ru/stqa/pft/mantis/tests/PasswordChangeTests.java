package ru.stqa.pft.mantis.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

public class PasswordChangeTests extends TestBase {

  @BeforeMethod(enabled = false)
  public void ensurePreconditions() {
    app.mail().start();
    if (app.db().users().size() == 0) {
      long now = System.currentTimeMillis();
      String email = String.format("user%s@localhost.localdomain", now);
      String user = String.format("user%s", now);
      String password = "password";
      UserData newUser = new UserData()
                                 .withEmail(email)
                                 .withUsername(user)
                                 .withPassword(password);
    }
    app.mail().stop();
  }

  @Test
  public void passwordChangeTest() {
    Users before = app.db().users();
    int a = app.db().users().size();
    System.out.println(before);
    System.out.println(a);
  }
}
