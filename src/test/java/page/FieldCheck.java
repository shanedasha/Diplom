package page;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class FieldCheck {
    public FieldCheck setNumberCard(String cardNumber) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input__inner").shouldHave(Condition.text("Номер карты")).setValue(cardNumber);
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".input__inner").shouldHave(Condition.text("Неверный формат"));
        return  new FieldCheck();
    }
    public FieldCheck setMonth(String month) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input__inner").shouldHave(Condition.text("Месяц")).setValue(month);
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".input__inner").shouldHave(Condition.text("Неверный формат"));
        return  new FieldCheck();
    }
    public FieldCheck setYear(String year) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input__inner").shouldHave(Condition.text("Год")).setValue(year);
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".input__inner").shouldHave(Condition.text("Неверный формат"));
        return  new FieldCheck();
    }
    public FieldCheck setOwner(String owner) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input__inner").shouldHave(Condition.text("Владелец")).setValue(owner);
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".input__inner").shouldHave(Condition.text("Неверный формат"));
        return  new FieldCheck();
    }
    public FieldCheck setCCV(String ccv) {
        $(".button").shouldHave(Condition.text("Купить")).click();
        $(".input__inner").shouldHave(Condition.text("CVC/CVC")).setValue(ccv);
        $(".button").shouldHave(Condition.text("Продолжить")).click();
        $(".input__inner").shouldHave(Condition.text("Неверный формат"));
        return  new FieldCheck();
    }
}
