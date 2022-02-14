package page;

import com.codeborne.selenide.Condition;
import data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BuyInCreditPage {
    public BuyInCreditPage validInfo(DataHelper.BuyInfo buyInfo) {
        $$("button").find(exactText("Купить в кредит")).click();
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo1().getCardNumber());
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo1().getMonth());
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo1().getYear());
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo1().getOwner());
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo1().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Операция одобрена Банком."));
        return new BuyInCreditPage();
    }

    public BuyInCreditPage NoValidInfo(DataHelper.BuyInfo buyInfo) {
        $$("button").find(exactText("Купить в кредит")).click();
        $("input[placeholder='0000 0000 0000 0000']").setValue(DataHelper.getBuyInfo2().getCardNumber());
        $("input[placeholder='08']").setValue(DataHelper.getBuyInfo2().getMonth());
        $("input[placeholder='22']").setValue(DataHelper.getBuyInfo2().getYear());
        $$(".input__control").get(3).setValue(DataHelper.getBuyInfo2().getOwner());
        $("input[placeholder='999']").setValue(DataHelper.getBuyInfo2().getCcv());
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Ошибка! Банк отказал в проведении операции."));
        return new BuyInCreditPage();
    }

    public BuyInCreditPage WithoutInfo() {
        $$("button").find(exactText("Купить в кредит")).click();
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат"));
        return new BuyInCreditPage();
    }
}
