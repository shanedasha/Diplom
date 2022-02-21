package page;

import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BuyInCreditPage {
    public BuyInCreditPage validInfo(DataHelper.BuyInfo buyInfo) {
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo1().getCardNumber());
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo1().getMonth());
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo1().getYear());
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo1().getOwner());
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo1().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Операция одобрена Банком.")).shouldBe(visible, Duration.ofSeconds(15));
        return this;
    }

    public BuyInCreditPage noValidInfo(DataHelper.BuyInfo buyInfo) {
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo2().getCardNumber());
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo2().getMonth());
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo2().getYear());
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo2().getOwner());
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo2().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Ошибка! Банк отказал в проведении операции.")).shouldBe(visible, Duration.ofSeconds(15));
        return this;
    }

    public BuyInCreditPage withoutInfo() {
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return this;
    }

    public BuyInCreditPage setNumberCard(DataHelper.BuyInfo buyInfo, String cardNumber) {
        $("input[placeholder='0000 0000 0000 0000']").setValue(cardNumber);
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo1().getMonth());
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo1().getYear());
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo1().getOwner());
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo1().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return this;
    }

    public BuyInCreditPage setMonth(DataHelper.BuyInfo buyInfo, String month) {
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo1().getCardNumber());
        $("input[placeholder='08']").setValue(month);
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo1().getYear());
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo1().getOwner());
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo1().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return this;
    }

    public BuyInCreditPage setOwner(DataHelper.BuyInfo buyInfo, String owner) {
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo1().getCardNumber());
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo1().getMonth());
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo1().getYear());
        $$(".input__control").get(3).setValue(owner);
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo1().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return this;
    }

    public BuyInCreditPage setYear(DataHelper.BuyInfo buyInfo, String year) {
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo1().getCardNumber());
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo1().getMonth());
        $("input[placeholder='22']").setValue(year);
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo1().getOwner());
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo1().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return this;
    }

    public BuyInCreditPage setCcv(DataHelper.BuyInfo buyInfo, String ccv) {
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo1().getCardNumber());
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo1().getMonth());
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo1().getYear());
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo1().getOwner());
        $("input[placeholder='999']").setValue(ccv);
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return this;

    }
}
