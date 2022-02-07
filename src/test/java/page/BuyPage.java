package page;

import com.codeborne.selenide.Condition;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class BuyPage {
    public BuyPage validInfo(DataHelper.BuyInfo buyInfo) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input_inner").shouldHave(Condition.text("Номер карты")).setValue(DataHelper.getBuyInfo1().getCardNumber());
        $(".input_inner").shouldHave(Condition.text("Месяц")).setValue(DataHelper.getBuyInfo1().getMonth());
        $(".input_inner").shouldHave(Condition.text("Год")).setValue(DataHelper.getBuyInfo1().getYear());
        $(".input_inner").shouldHave(Condition.text("Владелец")).setValue(DataHelper.getBuyInfo1().getOwner());
        $(".input_inner").shouldHave(Condition.text("CVC/CVC")).setValue(DataHelper.getBuyInfo1().getCcv());
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".notification__content").shouldHave(Condition.text("Успешно!Операция одобрена Банком."));
        return new BuyPage();
    }
    public BuyPage NoValidInfo(DataHelper.BuyInfo buyInfo) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input_inner").shouldHave(Condition.text("Номер карты")).setValue(DataHelper.getBuyInfo2().getCardNumber());
        $(".input_inner").shouldHave(Condition.text("Месяц")).setValue(DataHelper.getBuyInfo2().getMonth());
        $(".input_inner").shouldHave(Condition.text("Год")).setValue(DataHelper.getBuyInfo2().getYear());
        $(".input_inner").shouldHave(Condition.text("Владелец")).setValue(DataHelper.getBuyInfo2().getOwner());
        $(".input_inner").shouldHave(Condition.text("CVC/CVC")).setValue(DataHelper.getBuyInfo2().getCcv());
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".notification__content").shouldHave(Condition.text("Ошибка!Банк отказал в проведении операции."));
        return new BuyPage();
    }

    public BuyPage WithoutInfo() {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".input_inner").shouldHave(Condition.text("Неверный формат"));
        $(".input_inner").shouldHave(Condition.text("Неверный формат"));
        $(".input_inner").shouldHave(Condition.text("Неверный формат"));
        $(".input_inner").shouldHave(Condition.text("Поле обязательно для заполнения"));
        $(".input_inner").shouldHave(Condition.text("Неверный формат"));
        return new BuyPage();
    }
}
