package page;

import com.codeborne.selenide.Condition;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class BuyInCreditPage {
    public BuyInCreditPage validInfo(DataHelper.BuyInfo buyInfo) {
        $(".button").shouldHave(Condition.text("Купить в кредит")).click();
        $(".input__control").shouldHave(Condition.attribute("placeholder","0000 0000 0000 0000")).setValue(DataHelper.getBuyInfo1().getCardNumber());
        $(".input__control").shouldHave(Condition.attribute("placeholder","08")).setValue(DataHelper.getBuyInfo1().getMonth());
        $(".input__control").shouldHave(Condition.attribute("placeholder","22")).setValue(DataHelper.getBuyInfo1().getYear());
        $(".input__control").shouldHave(Condition.text("Владелец")).setValue(DataHelper.getBuyInfo1().getOwner());
        $(".input__control").shouldHave(Condition.attribute("placeholder","CVC/CCV")).setValue(DataHelper.getBuyInfo1().getCcv());
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".notification__content").shouldHave(Condition.text("Успешно!Операция одобрена Банком."));
        return new BuyInCreditPage();
    }

    public BuyInCreditPage NoValidInfo(DataHelper.BuyInfo buyInfo) {
        $(".button").shouldHave(Condition.text("Купить в кредит")).click();
        $(".input__control").shouldHave(Condition.attribute("placeholder","0000 0000 0000 0000")).setValue(DataHelper.getBuyInfo2().getCardNumber());
        $(".input__control").shouldHave(Condition.attribute("placeholder","08")).setValue(DataHelper.getBuyInfo2().getMonth());
        $(".input__control").shouldHave(Condition.attribute("placeholder","22")).setValue(DataHelper.getBuyInfo2().getYear());
        $(".input__control").shouldHave(Condition.text("Владелец")).setValue(DataHelper.getBuyInfo2().getOwner());
        $(".input__control").shouldHave(Condition.attribute("placeholder","CVC/CCV")).setValue(DataHelper.getBuyInfo2().getCcv());
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".notification__content").shouldHave(Condition.text("Ошибка!Банк отказал в проведении операции."));
        return new BuyInCreditPage();
    }

    public BuyInCreditPage WithoutInfo() {
        $(".button").shouldHave(Condition.text("Купить в кредит")).click();
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".input__control").shouldHave(Condition.text("Неверный формат"));
        $(".input__control").shouldHave(Condition.text("Неверный формат"));
        $(".input__control").shouldHave(Condition.text("Неверный формат"));
        $(".input__control").shouldHave(Condition.text("Поле обязательно для заполнения"));
        $(".input__control").shouldHave(Condition.text("Неверный формат"));
        return new BuyInCreditPage();
    }
}
