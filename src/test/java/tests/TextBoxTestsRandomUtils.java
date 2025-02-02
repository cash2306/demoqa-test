package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;


public class TextBoxTestsRandomUtils extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
   RandomUtils randomUtils = new RandomUtils();

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
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setEmail(randomUtils.email)
                .setBirthDate( randomUtils.BirthDay, randomUtils.BirthMonth, randomUtils.BirthYear)
                .setMobileNumber(randomUtils.MobileNumber)
                .chooseGender(randomUtils.gender)
                .setAndChooseSubject(randomUtils.subject)
                .chooseHobbies(randomUtils.hobbies)
                .uploadPicture(randomUtils.picture)
                .setAddress(randomUtils.address)
                .chooseStateAndCity(randomUtils.state, randomUtils.city)
                //.clickSubmit();
                .checkResult("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResult("Student Email", randomUtils.email)
                .checkResult("Gender", randomUtils.gender)
                .checkResult("Mobile", randomUtils.MobileNumber)
                .checkResult("Date of Birth", randomUtils.BirthDay + " " + randomUtils.BirthMonth + "," + randomUtils.BirthYear)
                .checkResult("Subjects", randomUtils.subject)
                .checkResult("Hobbies", randomUtils.hobbies)
                .checkResult("Picture", randomUtils.picture)
                .checkResult("Address", randomUtils.address)
                .checkResult("State and City", randomUtils.state + " " + randomUtils.city);
        }

    @Test
    @DisplayName("Проверка успешного сценария с минимальным количеством параметров")
    void studentRegistrationFormSuccessMinTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .chooseGender(randomUtils.gender)
                .setMobileNumber(randomUtils.MobileNumber)
                .clickSubmit();

    }
    @Test
    @DisplayName("Проверка сценария с отправкой формы без обязательного параметра")
    void studentRegistrationFormWithoutRequiredParameter() {
        registrationPage.openPage()
                .removeBanners()
                .setLastName(randomUtils.lastName)
                .chooseGender(randomUtils.gender)
                .setMobileNumber(randomUtils.MobileNumber)
                .clickSubmit();

    }
}

