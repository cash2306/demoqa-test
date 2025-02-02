package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;


public class TextBoxTestsRandomUtils extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
   RandomUtils RandomUtils = new RandomUtils();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @BeforeEach
    void setUp() {
        RandomUtils = new RandomUtils();
    }

    @Test
    void fullFillFormTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(RandomUtils.firstName)
                .setLastName(RandomUtils.lastName)
                .setEmail(RandomUtils.email)
                .setBirthDate( RandomUtils.BirthDay, RandomUtils.BirthMonth, RandomUtils.BirthYear)
                .setMobileNumber(RandomUtils.MobileNumber)
                .chooseGender(RandomUtils.gender)
                .setAndChooseSubject(RandomUtils.subject)
                .chooseHobbies(RandomUtils.hobbies)
                .uploadPicture(RandomUtils.picture)
                .setAddress(RandomUtils.address)
                .chooseStateAndCity(RandomUtils.state, RandomUtils.city)
                .clickSubmit();
        }

    @Test
    @DisplayName("Проверка успешного сценария с минимальным количеством параметров")
    void studentRegistrationFormSuccessMinTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(RandomUtils.firstName)
                .setLastName(RandomUtils.lastName)
                .chooseGender(RandomUtils.gender)
                .setMobileNumber(RandomUtils.MobileNumber)
                .clickSubmit();

    }
    @Test
    @DisplayName("Проверка сценария с отправкой формы без обязательного параметра")
    void studentRegistrationFormWithoutRequiredParameter() {
        registrationPage.openPage()
                .removeBanners()
                .setLastName(RandomUtils.lastName)
                .chooseGender(RandomUtils.gender)
                .setMobileNumber(RandomUtils.MobileNumber)
                .clickSubmit();

    }
}

