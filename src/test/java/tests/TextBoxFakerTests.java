package tests;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxFakerTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";

    }
       @Test
        void fillFormTest() {
           Faker faker = new Faker(new Locale("en-GB"));
           String firstName = faker.name().firstName();
           String lastName = faker.name().lastName();
           String userEmail = faker.internet().emailAddress();
           String streetAddress = faker.address().streetAddress();


           open("https://demoqa.com/automation-practice-form");
           executeJavaScript("$('#fixedban').remove()");
           executeJavaScript("$('footer').remove()");

           //Personal data
            $("#userForm #firstName").setValue(firstName);
            $("#userForm #lastName").setValue(lastName);
            $("#userEmail").setValue(userEmail);
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
           $("#currentAddress").setValue(streetAddress);
            //State and City
            $("#userForm #react-select-3-input").setValue("Haryana").pressEnter();
            $("#userForm #react-select-4-input").setValue("Panipat").pressEnter();
            $("#submit").click();
           $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
           $(".table").$(byText("Student Name")).sibling(0).shouldHave(text(firstName),text(lastName));
           $(".table").$(byText("Student Email")).sibling(0).shouldHave(text(userEmail));
           $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
           $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("0987654321"));
           $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("15 June,1990"));
           $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Maths"));
           $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Music"));
           $(".table").$(byText("Picture")).sibling(0).shouldHave(text("cat.jpg"));
           $(".table").$(byText("Address")).sibling(0).shouldHave(text(streetAddress));
           $(".table").$(byText("State and City")).sibling(0).shouldHave(text("Haryana Panipat"));
        }
    }

