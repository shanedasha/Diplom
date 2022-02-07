package test;

import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.BuyInCreditPage;
import page.BuyPage;
import page.FieldCheck;

import static com.codeborne.selenide.Selenide.open;

public class TravelPurchaseTest {
    @Test
    void shouldBuyWithValidInfo() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var BuyInfo = DataHelper.getBuyInfo1();
    }

    @Test
    void shouldBuyWithValidNoInfo() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var BuyInfo = DataHelper.getBuyInfo2();
    }

    @Test
    void shouldBuyWithoutInfo() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var BuyInfo = BuyPage.WithoutInfo();
    }

    @Test
    void shouldBuyInCreditWithValidInfo() {
        open("http://localhost:8080/");
        var BuyInCreditPage = new BuyInCreditPage();
        var BuyInfo = DataHelper.getBuyInfo1();
    }

    @Test
    void shouldBuyInCreditWithValidNoInfo() {
        open("http://localhost:8080/");
        var BuyInCreditPage = new BuyInCreditPage();
        var BuyInfo = DataHelper.getBuyInfo2();
    }

    @Test
    void shouldBuyInCreditWithoutInfo() {
        open("http://localhost:8080/");
        var BuyInCreditPage = new BuyInCreditPage();
        var BuyInfo = BuyInCreditPage.WithoutInfo();
    }

    @Test
    void shouldPassNegativeTestCard1() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var cardNumber = "1234 4567 7897";
        FieldCheck.setNumberCard(cardNumber);
    }

    @Test
    void shouldPassNegativeTestCard2() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var cardNumber = "Vasya";
        FieldCheck.setNumberCard(cardNumber);
    }

    @Test
    void shouldPassNegativeTestMonth1() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var month = "март";
        FieldCheck.setMonth(month);
    }

    @Test
    void shouldPassNegativeTestMonth2() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var month = "24";
        FieldCheck.setMonth(month);
    }

    @Test
    void shouldPassNegativeTestYear1() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var year = "Двадцать второй";
        FieldCheck.setYear(year);
    }

    @Test
    void shouldPassNegativeTestYear2() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var year = "2022";
        FieldCheck.setYear(year);
    }

    @Test
    void shouldPassNegativeTestYear3() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var year = "2018";
        FieldCheck.setYear(year);
    }

    @Test
    void shouldPassNegativeTestOwner1() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var owner = "Фёдор";
        FieldCheck.setOwner(owner);
    }

    @Test
    void shouldPassNegativeTestOwner2() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var owner = "1223";
        FieldCheck.setOwner(owner);
    }

    @Test
    void shouldPassNegativeTestOwner3() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var owner = "Анна-Мария";
        FieldCheck.setOwner(owner);
    }

    @Test
    void shouldPassNegativeTestOwner4() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var owner = "Анна Мария";
        FieldCheck.setOwner(owner);
    }

    @Test
    void shouldPassNegativeTestCCV1() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var ccv = "один";
        FieldCheck.setCCV(ccv);
    }

    @Test
    void shouldPassNegativeTestCCV2() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var ccv = "11";
        FieldCheck.setCCV(ccv);
    }

    @Test
    void shouldPassNegativeTestCCV3() {
        open("http://localhost:8080/");
        var FieldCheck = new FieldCheck();
        var ccv = "1111";
        FieldCheck.setCCV(ccv);
    }
}
