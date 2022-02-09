package test;

import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.BuyInCreditPage;
import page.BuyPage;

import static com.codeborne.selenide.Selenide.open;

public class TravelPurchaseTest {
    @Test
    void shouldBuyWithValidInfo() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.validInfo(BuyInfo);
    }

    @Test
    void shouldBuyWithValidNoInfo() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var BuyInfo = DataHelper.getBuyInfo2();
        BuyPage.NoValidInfo(BuyInfo);
    }

    @Test
    void shouldBuyWithoutInfo() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        BuyPage.WithoutInfo();
    }

    @Test
    void shouldBuyInCreditWithValidInfo() {
        open("http://localhost:8080/");
        var BuyInCreditPage = new BuyInCreditPage();
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.validInfo(BuyInfo);
    }

    @Test
    void shouldBuyInCreditWithValidNoInfo() {
        open("http://localhost:8080/");
        var BuyInCreditPage = new BuyInCreditPage();
        var BuyInfo = DataHelper.getBuyInfo2();
        BuyInCreditPage.NoValidInfo(BuyInfo);
    }

    @Test
    void shouldBuyInCreditWithoutInfo() {
        open("http://localhost:8080/");
        var BuyInCreditPage = new BuyInCreditPage();
        BuyInCreditPage.WithoutInfo();
    }

    @Test
    void shouldPassNegativeTestCard1() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var cardNumber = "1234 4567 7897";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setNumberCard(BuyInfo, cardNumber);
    }

    @Test
    void shouldPassNegativeTestCard2() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var cardNumber = "Vasya";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setNumberCard(BuyInfo, cardNumber);
    }

    @Test
    void shouldPassNegativeTestMonth1() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var month = "март";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setMonth(BuyInfo,month);
    }

    @Test
    void shouldPassNegativeTestMonth2() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var month = "24";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setMonth(BuyInfo,month);
    }

    @Test
    void shouldPassNegativeTestYear1() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var year = "Двадцать второй";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setYear(BuyInfo,year);
    }

    @Test
    void shouldPassNegativeTestYear2() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var year = "2022";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setYear(BuyInfo,year);
    }

    @Test
    void shouldPassNegativeTestYear3() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var year = "2018";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setYear(BuyInfo,year);
    }

    @Test
    void shouldPassNegativeTestOwner1() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var owner = "Фёдор";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setOwner(BuyInfo,owner);
    }

    @Test
    void shouldPassNegativeTestOwner2() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var owner = "1223";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setOwner(BuyInfo,owner);
    }

    @Test
    void shouldPassNegativeTestOwner3() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var owner = "Анна-Мария";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setOwner(BuyInfo,owner);
    }

    @Test
    void shouldPassNegativeTestOwner4() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var owner = "Анна Мария";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setOwner(BuyInfo,owner);
    }

    @Test
    void shouldPassNegativeTestCCV1() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var ccv = "один";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setCcv(BuyInfo,ccv);
    }

    @Test
    void shouldPassNegativeTestCCV2() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var ccv = "11";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setCcv(BuyInfo,ccv);
    }

    @Test
    void shouldPassNegativeTestCCV3() {
        open("http://localhost:8080/");
        var BuyPage = new BuyPage();
        var ccv = "1111";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setCcv(BuyInfo,ccv);
    }
}
