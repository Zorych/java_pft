package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    saveAsJson(contacts, new File(file));
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> groups = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      groups.add(new ContactData()
                         .withFirstName(String.format("Игорь%s", i))
                         .withMiddleName(String.format("Сергеевич%s", i))
                         .withLastName(String.format("Григорьев%s", i))
                         .withAddress(String.format("ул. Каретный ряд 10/2, %s этаж", i))
                         .withNickName(String.format("Zorych%s", i))
                         .withPhoto("src/test/resources/ava.jpg")
                         .withTitle(String.format("test_title%s", i))
                         .withCompany(String.format("test_company%s", i))
                         .withHomePhone(String.format("+7 (111)11-%s", i))
                         .withMobilePhone(String.format("2-2 2-2 %s", i))
                         .withWorkPhone(String.format("33333%s", i))
                         .withEmail(String.format("kaze25%st@gmail.com", i))
                         .withEmail3(String.format("zorych25%st@yandex.ru", i))
                         .withHomepage("https://www.linkedin.com/in/igor-grigorev-3a657a18b/")
                         .withBirthday("11", "May", "1991")
                         .withAnniversary("15", "April", "1992")
                         .withSecAddress(String.format("test_secondary-address%s", i))
                         .withSecPhone(String.format("55555%s", i))
                         .withSecNotes(String.format("test_secondary-notes%s", i)));
    }
    return groups;
  }
}
