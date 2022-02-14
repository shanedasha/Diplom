package page;

import com.codeborne.selenide.Condition;
import data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BuyPage {
    public  void validInfo(DataHelper.BuyInfo buyInfo) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo1().getCardNumber());
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo1().getMonth());
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo1().getYear());
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo1().getOwner());
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo1().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Операция одобрена Банком."));
    }
    public BuyPage NoValidInfo(DataHelper.BuyInfo buyInfo) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo2().getCardNumber());
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo2().getMonth());
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo2().getYear());
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo2().getOwner());
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo2().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Ошибка! Банк отказал в проведении операции."));
        return new BuyPage();
    }

    public BuyPage WithoutInfo() {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return new BuyPage();
    }
    public BuyPage setNumberCard(DataHelper.BuyInfo buyInfo, String cardNumber) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $("input[placeholder='0000 0000 0000 0000']").setValue(cardNumber);
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo1().getMonth());
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo1().getYear());
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo1().getOwner());
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo1().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return new BuyPage();
    }
    public BuyPage setMonth(DataHelper.BuyInfo buyInfo, String month) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo1().getCardNumber());
        $("input[placeholder='08']").setValue(month);
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo1().getYear());
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo1().getOwner());
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo1().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return new BuyPage();
    }
    public BuyPage setOwner(DataHelper.BuyInfo buyInfo, String owner) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo1().getCardNumber());
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo1().getMonth());
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo1().getYear());
        $$(".input__control").get(3).setValue(owner);
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo1().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return new BuyPage();
    }
    public BuyPage setYear(DataHelper.BuyInfo buyInfo, String year) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo1().getCardNumber());
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo1().getMonth());
        $("input[placeholder='22']").setValue(year);
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo1().getOwner());
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo1().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return new BuyPage();
    }
    public BuyPage setCcv(DataHelper.BuyInfo buyInfo, String ccv) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo1().getCardNumber());
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo1().getMonth());
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo1().getYear());
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo1().getOwner());
        $("input[placeholder='999']").setValue(ccv);
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return new BuyPage();

    }
}
