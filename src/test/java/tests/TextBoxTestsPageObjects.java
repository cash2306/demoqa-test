package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class TextBoxTestsPageObjects {
    RegistrationPage registrationPage = new RegistrationPage();
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
           //Personal data
                .setFirstName("Bob")
                .setLastName("Smith")
                .setEmail("bobsmith@candex.com")
            //Date of Birth
                .setBirthDate("15", "July", "1990")
            //Number
                .setMobileNumber("09876543210")
            //Gender
                .chooseGender("Female")
            //Subjects
                .setAndChooseSubject("Maths")
           //Hobbies
                .chooseHobbies("Music")
           //Picture
                .uploadPicture("cat.jpg")
            //Current Address
                .setAddress("INDIA")
            //State and City
                .chooseStateAndCity("Haryana","Panipat")
                .clickSubmit();


        }
    @Test
    @DisplayName("Проверка успешного сценария с минимальным количеством параметров")
    void studentRegistrationFormSuccessMinTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Bob")
                .setLastName("Smith")
                .chooseGender("Female")
                .setMobileNumber("09876543210")
                .clickSubmit();

    }
    @Test
    @DisplayName("Проверка сценария с отправкой формы без обязательного параметра")
    void studentRegistrationFormWithoutRequiredParameter() {
        registrationPage.openPage()
                .removeBanners()
                .setLastName("Smith")
                .chooseGender("Female")
                .setMobileNumber("09876543210")
                .clickSubmit();
    }
                                                      }

