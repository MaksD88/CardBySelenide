import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class CardTests {

    @BeforeEach
    void shouldOpenBrowser() {
        open("http://localhost:7777/");
    }


    @Test
    public void shouldSendForm() {
        $("[type=text]").setValue( "Иван Петров" );
        $("[type=tel]").setValue( "+79112345678");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=order-success]").shouldHave( exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.") );

    }


    @Test
    public void shouldSendFormWithDashInName() {
        $("[type=text]").setValue( "Иван Петров-Петров" );
        $("[type=tel]").setValue( "+79112345678");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=order-success]").shouldHave( exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.") );

    }
    @Test
    public void shouldSendFormWithDashInName() {
        $("[type=text]").setValue("иван петров");
        $("[type=tel]").setValue("+79112345678");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=order-success]").shouldHave(exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }


}