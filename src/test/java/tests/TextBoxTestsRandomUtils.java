package tests;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static utils.RandomUtils.*;

public class TextBoxTestsRandomUtils {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker(new Locale("en-GB"));
    String firstName = getRandomString(10);
    String lastName = getRandomString(10);
    String userEmail = getRandomEmail();
    String streetAddress = getRandomAddress();
    String MobileNumber = getRandomPhone();
    String Gender = getRandomGender();
    String BirthDay = String.valueOf(getRandomInt(1,28));
    String BirthMonth = getRandomMonth();
    String BirthYear = String.valueOf(getRandomInt(1925,2025));
    String Subject = getRandomSubject();
    String Hobbies = getRandomHobbies();
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fullFillFormTest() {
        registrationPage
                .openPage()
                 .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setBirthDate(BirthDay,BirthMonth,BirthYear)
                .setMobileNumber(MobileNumber)
                .chooseGender(Gender)
                .setAndChooseSubject(Subject)
                .chooseHobbies(Hobbies)
                .uploadPicture("cat.jpg")
                .setAddress(streetAddress)
                .chooseStateAndCity("Haryana","Panipat")
                .clickSubmit();


        }
    @Test
    @DisplayName("Проверка успешного сценария с минимальным количеством параметров")
    void studentRegistrationFormSuccessMinTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .chooseGender(Gender)
                .setMobileNumber(MobileNumber)
                .clickSubmit();

    }
    @Test
    @DisplayName("Проверка сценария с отправкой формы без обязательного параметра")
    void studentRegistrationFormWithoutRequiredParameter() {
        registrationPage.openPage()
                .removeBanners()
                .setLastName(lastName)
                .chooseGender(Gender)
                .setMobileNumber(MobileNumber)
                .clickSubmit();
    }
                                                      }

