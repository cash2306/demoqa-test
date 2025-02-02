package utils;

import com.github.javafaker.Faker;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Locale;
import utils.RandomUtils;

public class RandomUtils {
    Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String MobileNumber = faker.phoneNumber().subscriberNumber(10);
    public String BirthDay = String.format("%s", faker.number().numberBetween(1, 28));
    public String BirthMonth = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December");
    public String BirthYear = String.format("%s", faker.number().numberBetween(1924, 2010));
    public String subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry", "Biology",
                    "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History",
                    "Civics");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String picture = faker.options().option("304156.svg", "cat.jpg", "catty.png");
    public String address = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = selectCity(state);

    public String selectCity(String state) {
        switch (state) {

            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");

            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");

            case "Haryana":
                return faker.options().option("Karnal", "Panipat");

            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");

            default:
                return null;
        }


    }
}

