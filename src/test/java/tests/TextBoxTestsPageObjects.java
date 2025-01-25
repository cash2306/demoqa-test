package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class TextBoxTestsPageObjects {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName="Bob",
            lastName="Smith",
            userEmail="bobsmith@candex.com";
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
                .setFirstName("Bob")
                .setLastName("Smith")
                .setEmail("bobsmith@candex.com")
                .setBirthDate("15", "July", "1990")
                .setMobileNumber("09876543210")
                .chooseGender("Female")
                .setAndChooseSubject("Maths")
                .chooseHobbies("Music")
                .uploadPicture("cat.jpg")
                .setAddress("INDIA")
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

