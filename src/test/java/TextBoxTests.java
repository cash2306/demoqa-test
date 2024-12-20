import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";

    }
       @Test
        void fillFormTest() {
           open(
                   "https://demoqa.com/automation-practice-form");
           executeJavaScript("$('#fixedban').remove()");
           executeJavaScript("$('footer').remove()");

           //Personal data
            $("#userForm #firstName").setValue("Bob");
            $("#userForm #lastName").setValue("Smith");
            $("#userEmail").setValue("bobsmith@candex.com");
            //Gender
           $("#genterWrapper").$(byText("Female")).click();
            //Number
            $("#userForm #userNumber").setValue("09876543210");
            //Date of Birth
           $("#userForm #dateOfBirthInput").click();
           $(".react-datepicker__month-select").selectOptionContainingText("June");
           $(".react-datepicker__year-select").selectOptionByValue("1990");
           $(".react-datepicker__day.react-datepicker__day--015").click();
            //Subjects
           $("#subjectsInput").setValue("Maths").pressEnter();
           //Hobbies
           $("#hobbiesWrapper").$(byText("Music")).click();
           //Picture
           $("#uploadPicture").uploadFromClasspath("cat.jpg");
            //Current Address
           $("#currentAddress").setValue("INDIA");
            //State and City
            $("#userForm #react-select-3-input").setValue("Haryana").pressEnter();
            $("#userForm #react-select-4-input").setValue("Panipat").pressEnter();
            $("#submit").click();
           $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
           $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Bob Smith"));
           $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("bobsmith@candex.com"));
           $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
           $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("0987654321"));
           $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("15 June,1990"));
           $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Maths"));
           $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Music"));
           $(".table").$(byText("Picture")).sibling(0).shouldHave(text("cat.jpg"));
           $(".table").$(byText("Address")).sibling(0).shouldHave(text("INDIA"));
           $(".table").$(byText("State and City")).sibling(0).shouldHave(text("Haryana Panipat"));
        }
    }

