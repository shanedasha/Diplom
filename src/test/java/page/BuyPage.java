package page;

import com.codeborne.selenide.Condition;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class BuyPage {
    public  void validInfo(DataHelper.BuyInfo buyInfo) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input__control").shouldHave(Condition.attribute("placeholder","0000 0000 0000 0000")).setValue(DataHelper.getBuyInfo1().getCardNumber());
        $(".input__control").shouldHave(Condition.attribute("placeholder","08")).setValue(DataHelper.getBuyInfo1().getMonth());
        $(".input__control").shouldHave(Condition.attribute("placeholder","22")).setValue(DataHelper.getBuyInfo1().getYear());
        $(".input__control").setValue(DataHelper.getBuyInfo1().getOwner());
        $(".input__control").shouldHave(Condition.attribute("placeholder","CVC/CCV")).setValue(DataHelper.getBuyInfo1().getCcv());
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".notification__content").shouldHave(Condition.text("Успешно!Операция одобрена Банком."));
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
    public BuyPage setNumberCard(DataHelper.BuyInfo buyInfo, String cardNumber) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input_inner").shouldHave(Condition.text("Номер карты")).setValue(cardNumber);
        $(".input_inner").shouldHave(Condition.text("Месяц")).setValue(DataHelper.getBuyInfo1().getMonth());
        $(".input_inner").shouldHave(Condition.text("Год")).setValue(DataHelper.getBuyInfo1().getYear());
        $(".input_inner").shouldHave(Condition.text("Владелец")).setValue(DataHelper.getBuyInfo1().getOwner());
        $(".input_inner").shouldHave(Condition.text("CVC/CVC")).setValue(DataHelper.getBuyInfo1().getCcv());
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".input__inner").shouldHave(Condition.text("Неверный формат"));
        return new BuyPage();
    }
    public BuyPage setMonth(DataHelper.BuyInfo buyInfo, String month) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input_inner").shouldHave(Condition.text("Номер карты")).setValue(DataHelper.getBuyInfo1().getCardNumber());
        $(".input_inner").shouldHave(Condition.text("Месяц")).setValue(month);
        $(".input_inner").shouldHave(Condition.text("Год")).setValue(DataHelper.getBuyInfo1().getYear());
        $(".input_inner").shouldHave(Condition.text("Владелец")).setValue(DataHelper.getBuyInfo1().getOwner());
        $(".input_inner").shouldHave(Condition.text("CVC/CVC")).setValue(DataHelper.getBuyInfo1().getCcv());
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".input__inner").shouldHave(Condition.text("Неверный формат"));
        return new BuyPage();
    }
    public BuyPage setOwner(DataHelper.BuyInfo buyInfo, String owner) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input_inner").shouldHave(Condition.text("Номер карты")).setValue(DataHelper.getBuyInfo1().getCardNumber());
        $(".input_inner").shouldHave(Condition.text("Месяц")).setValue(DataHelper.getBuyInfo1().getMonth());
        $(".input_inner").shouldHave(Condition.text("Год")).setValue(DataHelper.getBuyInfo1().getYear());
        $(".input_inner").shouldHave(Condition.text("Владелец")).setValue(owner);
        $(".input_inner").shouldHave(Condition.text("CVC/CVC")).setValue(DataHelper.getBuyInfo1().getCcv());
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".input__inner").shouldHave(Condition.text("Неверный формат"));
        return new BuyPage();
    }
    public BuyPage setYear(DataHelper.BuyInfo buyInfo, String year) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input_inner").shouldHave(Condition.text("Номер карты")).setValue(DataHelper.getBuyInfo1().getCardNumber());
        $(".input_inner").shouldHave(Condition.text("Месяц")).setValue(DataHelper.getBuyInfo1().getMonth());
        $(".input_inner").shouldHave(Condition.text("Год")).setValue(year);
        $(".input_inner").shouldHave(Condition.text("Владелец")).setValue(DataHelper.getBuyInfo1().getOwner());
        $(".input_inner").shouldHave(Condition.text("CVC/CVC")).setValue(DataHelper.getBuyInfo1().getCcv());
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".input__inner").shouldHave(Condition.text("Неверный формат"));
        return new BuyPage();
    }
    public BuyPage setCcv(DataHelper.BuyInfo buyInfo, String ccv) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input_inner").shouldHave(Condition.text("Номер карты")).setValue(DataHelper.getBuyInfo1().getCardNumber());
        $(".input_inner").shouldHave(Condition.text("Месяц")).setValue(DataHelper.getBuyInfo1().getMonth());
        $(".input_inner").shouldHave(Condition.text("Год")).setValue(DataHelper.getBuyInfo1().getYear());
        $(".input_inner").shouldHave(Condition.text("Владелец")).setValue(DataHelper.getBuyInfo1().getOwner());
        $(".input_inner").shouldHave(Condition.text("CVC/CVC")).setValue(ccv);
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".input__inner").shouldHave(Condition.text("Неверный формат"));
        return new BuyPage();
    }
}
