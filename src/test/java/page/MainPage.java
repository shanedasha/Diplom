package page;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public void goToDebitCardPay() {
        $$("button").find(exactText("Купить")).click();
        $("#root > div > h3").shouldHave(text("Оплата по карте"));
    }

    public void goToCreditCardPay() {
        $$("button").find(exactText("Купить в кредит")).click();
        $("#root > div > h3").shouldHave(text("Кредит по данным карты"));
    }
}
