package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
public class ContactData {

  @Id
  @Column(name = "Id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstName;

  @Expose
  @Column(name = "middlename")
  private String middleName;

  @Expose
  @Column(name = "lastname")
  private String lastName;

  @Expose
  @Transient
  private String group;

  @Expose
  @Column(name = "nickname")
  private String nickName;

  @Expose
  @Column(name = "title")
  private String title;

  @Expose
  @Column(name = "company")
  private String company;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;

  @Expose
  @Column(name = "fax")
  @Type(type = "text")
  private String faxPhone;

  @Expose
  @Transient
  private String home2Phone;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;

  @Expose
  @Column(name = "homepage")
  @Type(type = "text")
  private String homepage;

  @Expose
  @Column(name = "bmonth")
  private String bMonth;

  @Expose
  @Column(name = "bday", columnDefinition = "TINYINT")
  //@Type(type = "TINYINT(2)")
  //@Transient
  private String bDay;

  @Expose
  @Column(name = "byear")
  private String bYear;

  @Expose
  @Column(name = "amonth")
  @ColumnTransformer(read = "CONCAT(UPPER(SUBSTRING(amonth,1,1)),LOWER(SUBSTRING(amonth,2)))")
  private String aMonth;

  @Expose
  @Column(name = "aday", columnDefinition = "TINYINT")
  //@Type(type = "TINYINT(2)")
  //@Transient
  private String aDay;

  @Expose
  @Column(name = "ayear")
  private String aYear;

  @Expose
  @Column(name = "address2")
  @Type(type = "text")
  private String secAddress;

  @Expose
  @Column(name = "phone2")
  @Type(type = "text")
  private String secPhone;

  @Expose
  @Column(name = "notes")
  @Type(type = "text")
  private String notes;

  @Expose
  @Transient
  private String allPhones;

  @Expose
  @Transient
  private String allMails;

  @Expose
  @Transient
  private String allRefMails;

  @Expose
  @Column(name = "photo")
  @Type(type = "text")
  @Transient
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
    this.notes = secNotes;
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

  public String getNotes() {
    return notes;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
                   Objects.equals(firstName, that.firstName) &&
                   Objects.equals(middleName, that.middleName) &&
                   Objects.equals(lastName, that.lastName) &&
                   Objects.equals(group, that.group) &&
                   Objects.equals(nickName, that.nickName) &&
                   Objects.equals(title, that.title) &&
                   Objects.equals(company, that.company) &&
                   Objects.equals(address, that.address) &&
                   Objects.equals(homePhone, that.homePhone) &&
                   Objects.equals(mobilePhone, that.mobilePhone) &&
                   Objects.equals(workPhone, that.workPhone) &&
                   Objects.equals(faxPhone, that.faxPhone) &&
                   Objects.equals(home2Phone, that.home2Phone) &&
                   Objects.equals(email, that.email) &&
                   Objects.equals(email2, that.email2) &&
                   Objects.equals(email3, that.email3) &&
                   Objects.equals(homepage, that.homepage) &&
                   Objects.equals(bMonth, that.bMonth) &&
                   Objects.equals(bDay, that.bDay) &&
                   Objects.equals(bYear, that.bYear) &&
                   Objects.equals(aMonth, that.aMonth) &&
                   Objects.equals(aDay, that.aDay) &&
                   Objects.equals(aYear, that.aYear) &&
                   Objects.equals(secAddress, that.secAddress) &&
                   Objects.equals(secPhone, that.secPhone) &&
                   Objects.equals(notes, that.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, middleName, lastName, group, nickName, title, company, address, homePhone, mobilePhone, workPhone, faxPhone, home2Phone, email, email2, email3, homepage, bMonth, bDay, bYear, aMonth, aDay, aYear, secAddress, secPhone, notes);
  }

  @Override
  public String toString() {
    return "ContactData{" +
                   "id=" + id +
                   ", firstName='" + firstName + '\'' +
                   ", middleName='" + middleName + '\'' +
                   ", lastName='" + lastName + '\'' +
                   ", group='" + group + '\'' +
                   ", nickName='" + nickName + '\'' +
                   ", title='" + title + '\'' +
                   ", company='" + company + '\'' +
                   ", address='" + address + '\'' +
                   ", homePhone='" + homePhone + '\'' +
                   ", mobilePhone='" + mobilePhone + '\'' +
                   ", workPhone='" + workPhone + '\'' +
                   ", faxPhone='" + faxPhone + '\'' +
                   ", home2Phone='" + home2Phone + '\'' +
                   ", email='" + email + '\'' +
                   ", email2='" + email2 + '\'' +
                   ", email3='" + email3 + '\'' +
                   ", homepage='" + homepage + '\'' +
                   ", bMonth='" + bMonth + '\'' +
                   ", bDay='" + bDay + '\'' +
                   ", bYear='" + bYear + '\'' +
                   ", aMonth='" + aMonth + '\'' +
                   ", aDay='" + aDay + '\'' +
                   ", aYear='" + aYear + '\'' +
                   ", secAddress='" + secAddress + '\'' +
                   ", secPhone='" + secPhone + '\'' +
                   ", notes='" + notes + '\'' +
                   '}';
  }

}