package ru.stqa.pft.mantis.model;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "mantis_user_mantis")
public class UserData {

  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "username")
  private String username;

  @Expose
  @Column(name = "email")
  private String email;

  @Expose
  @Column(name = "password")
  private String password;

  @Expose
  @Column(name = "access_level", columnDefinition = "SMALLINT")
  private String accessLevel;

  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public UserData withUsername(String username) {
    this.username = username;
    return this;
  }

  public UserData withEmail(String email) {
    this.email = email;
    return this;
  }

  public UserData withPassword(String password) {
    this.password = password;
    return this;
  }

  public UserData withAccessLevel(String accessLevel) {
    this.accessLevel = accessLevel;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getAccessLevel() {
    return accessLevel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserData userData = (UserData) o;
    return id == userData.id &&
                   Objects.equals(username, userData.username) &&
                   Objects.equals(email, userData.email) &&
                   Objects.equals(password, userData.password) &&
                   Objects.equals(accessLevel, userData.accessLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, email, password, accessLevel);
  }

  @Override
  public String toString() {
    return "UserData{" +
                   "id=" + id +
                   ", username='" + username + '\'' +
                   ", email='" + email + '\'' +
                   ", password='" + password + '\'' +
                   ", accessLevel='" + accessLevel + '\'' +
                   '}';
  }
}
