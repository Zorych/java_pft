package ru.stqa.pft.addressbook.model;

public class ContactData {
  private String firstName;
  private String middleName;
  private String lastName;
  private String nickName;
  private String title;
  private String company;
  private String address;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String faxPhone;
  private String email;
  private String email2;
  private String email3;
  private String homepage;
  private String bMonth;
  private String bDay;
  private String bYear;
  private String aMonth;
  private String aDay;
  private String aYear;
  private String secAddress;
  private String secPhone;
  private String secNotes;

  public ContactData(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }

  public void setFaxPhone(String faxPhone) {
    this.faxPhone = faxPhone;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setEmail2(String email2) {
    this.email2 = email2;
  }

  public void setEmail3(String email3) {
    this.email3 = email3;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public void setBirthday(String bDay, String bMonth, String bYear) {
    this.bMonth = bMonth;
    this.bDay = bDay;
    this.bYear = bYear;
  }

  public void setAnniversary(String aDay, String aMonth, String aYear) {
    this.aMonth = aMonth;
    this.aDay = aDay;
    this.aYear = aYear;
  }

  public void setSecAddress(String secAddress) {
    this.secAddress = secAddress;
  }

  public void setSecPhone(String secPhone) {
    this.secPhone = secPhone;
  }

  public void setSecNotes(String secNotes) {
    this.secNotes = secNotes;
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
}
