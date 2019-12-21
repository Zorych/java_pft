package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstName;
  @Expose
  private String middleName;
  @Expose
  private String lastName;
  @Expose
  private String group;
  @Expose
  private String nickName;
  @Expose
  private String title;
  @Expose
  private String company;
  @Expose
  private String address;
  @Expose
  private String homePhone;
  @Expose
  private String mobilePhone;
  @Expose
  private String workPhone;
  @Expose
  private String faxPhone;
  @Expose
  private String home2Phone;
  @Expose
  private String email;
  @Expose
  private String email2;
  @Expose
  private String email3;
  @Expose
  private String homepage;
  @Expose
  private String bMonth;
  @Expose
  private String bDay;
  @Expose
  private String bYear;
  @Expose
  private String aMonth;
  @Expose
  private String aDay;
  @Expose
  private String aYear;
  @Expose
  private String secAddress;
  @Expose
  private String secPhone;
  @Expose
  private String secNotes;
  @Expose
  private String allPhones;
  @Expose
  private String allMails;
  @Expose
  private String allRefMails;
  @Expose
  private String photo;

  public String getPhoto() {
    return photo;
  }

  public ContactData withPhoto(String photo) {
    this.photo = photo;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAllMails() {
    return allMails;
  }

  public String getAllRefMails() {
    return allRefMails;
  }

  public String getHome2Phone() {
    return home2Phone;
  }

  public ContactData withHome2Phone(String home2Phone) {
    this.home2Phone = home2Phone;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllMails(String allMails) {
    this.allMails = allMails;
    return this;
  }

  public ContactData withAllRefMails(String allRefMails) {
    this.allRefMails = allRefMails;
    return this;
  }

  public ContactData withNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withFaxPhone(String faxPhone) {
    this.faxPhone = faxPhone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withBirthday(String bDay, String bMonth, String bYear) {
    this.bMonth = bMonth;
    this.bDay = bDay;
    this.bYear = bYear;
    return this;
  }

  public ContactData withAnniversary(String aDay, String aMonth, String aYear) {
    this.aMonth = aMonth;
    this.aDay = aDay;
    this.aYear = aYear;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withbMonth(String bMonth) {
    this.bMonth = bMonth;
    return this;
  }

  public ContactData withbDay(String bDay) {
    this.bDay = bDay;
    return this;
  }

  public ContactData withbYear(String bYear) {
    this.bYear = bYear;
    return this;
  }

  public ContactData withaMonth(String aMonth) {
    this.aMonth = aMonth;
    return this;
  }

  public ContactData withaDay(String aDay) {
    this.aDay = aDay;
    return this;
  }

  public ContactData withaYear(String aYear) {
    this.aYear = aYear;
    return this;
  }
  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withSecAddress(String secAddress) {
    this.secAddress = secAddress;
    return this;
  }

  public ContactData withSecPhone(String secPhone) {
    this.secPhone = secPhone;
    return this;
  }

  public ContactData withSecNotes(String secNotes) {
    this.secNotes = secNotes;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFaxPhone() {
    return faxPhone;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getbMonth() {
    return bMonth;
  }

  public String getbDay() {
    return bDay;
  }

  public String getbYear() {
    return bYear;
  }

  public String getAMonth() {
    return aMonth;
  }

  public String getADay() {
    return aDay;
  }

  public String getAYear() {
    return aYear;
  }

  public String getSecAddress() {
    return secAddress;
  }

  public String getSecPhone() {
    return secPhone;
  }

  public String getSecNotes() {
    return secNotes;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
                   "id='" + id + '\'' +
                   ", firstName='" + firstName + '\'' +
                   ", lastName='" + lastName + '\'' +
                   '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
                   Objects.equals(firstName, that.firstName) &&
                   Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }
}