package utils;

import com.github.javafaker.Faker;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomAddress());
        System.out.println(getRandomInt(111, 999999999));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
    }

    public static String getRandomString(int len) {
        String AB = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRST";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@qa.guru";
    }

    public static String getRandomAddress() {
        return new Faker().address().streetAddress();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone() {
        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];

    }

    public static String getRandomMonth() {
        String[] Month = {"January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December"};
        return getRandomItemFromArray(Month);
    }

    public static String getRandomSubject() {
        String[] Subject = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology",
                "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History",
                "Civics"};
        return getRandomItemFromArray(Subject);
    }

    public static String getRandomHobbies() {
        String[] Hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(Hobbies);
    }

    public static String getRandomPicture() {
        String[] Picture = {"304156.svg", "cat.jpg", "catty.png"};
        return getRandomItemFromArray(Picture);
    }

    public static String getRandomState() {
        String[] State = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItemFromArray(State);

    }

    public static String getRandomCity() {
        switch (getRandomCity()) {
            case ("NCR"):
                String[] cityNCR = {"Delhi", "Gurgaon", "Noida"};
                return getRandomItemFromArray(cityNCR);
            case ("Uttar Pradesh"):
                String[] cityUP = {"Agra", "Lucknow", "Merrut"};
                return getRandomItemFromArray(cityUP);
            case ("Haryana"):
                String[] cityHaryana = {"Karnal", "Panipat"};
                return getRandomItemFromArray(cityHaryana);
            case ("Rajasthan"):
                String[] cityRajasthan = {"Jaipur", "Jaiselmer"};
                return getRandomItemFromArray(cityRajasthan);
            default:
                return null;
        }
    };
}

