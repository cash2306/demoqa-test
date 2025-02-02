package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalComponent {
    public void checkResult(String key, String value) {
        modal().$(byText(key)).parent()
                .shouldHave(text(value));



    }

    private Selenide modal() {
        return null;
    }

    public void verifyModalAppears(){
        $(".modal-dialog").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(text(value));
    }
}
