package test;

import data.DataHelper;
import database.DataBase;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.BuyPage;
import page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static database.DataBase.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PayWithCardTest extends MainPage {

    MainPage mainPage = new MainPage();

    @AfterEach
    void cleanDataBases() {
        DataBase.dropDataBase();
    }

    @BeforeEach
    void setUpSutUrl() {
        open(System.getProperty("sut.url"));
    }

    @BeforeEach
    void setUpForPayWithCard() {
        mainPage.goToDebitCardPay();
    }

    @Test
    void shouldBuyWithValidInfo() {
        var BuyPage = new BuyPage();
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.validInfo(BuyInfo);
    }

    @Test
    void shouldBuyWithValidNoInfo() {
        var BuyPage = new BuyPage();
        var BuyInfo = DataHelper.getBuyInfo2();
        BuyPage.noValidInfo(BuyInfo);
    }

    @Test
    void shouldBuyWithoutInfo() {
        var BuyPage = new BuyPage();
        BuyPage.withoutInfo();
    }

    @Test
    void shouldPassNegativeTestCard1() {
        var BuyPage = new BuyPage();
        var cardNumber = "1234 4567 7897";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setNumberCard(BuyInfo, cardNumber);
    }

    @Test
    void shouldPassNegativeTestCard2() {
        var BuyPage = new BuyPage();
        var cardNumber = "Vasya";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setNumberCard(BuyInfo, cardNumber);
    }

    @Test
    void shouldPassNegativeTestMonth1() {
        var BuyPage = new BuyPage();
        var month = "март";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setMonth(BuyInfo, month);
    }

    @Test
    void shouldPassNegativeTestMonth2() {
        var BuyPage = new BuyPage();
        var month = "24";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setMonth(BuyInfo, month);
    }

    @Test
    void shouldPassNegativeTestYear1() {
        var BuyPage = new BuyPage();
        var year = "Двадцать второй";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setYear(BuyInfo, year);
    }

    @Test
    void shouldPassNegativeTestYear2() {
        var BuyPage = new BuyPage();
        var year = "2022";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setYear(BuyInfo, year);
    }

    @Test
    void shouldPassNegativeTestYear3() {
        var BuyPage = new BuyPage();
        var year = "2018";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setYear(BuyInfo, year);
    }

    @Test
    void shouldPassNegativeTestOwner1() {
        var BuyPage = new BuyPage();
        var owner = "Фёдор";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setOwner(BuyInfo, owner);
    }

    @Test
    void shouldPassNegativeTestOwner2() {
        var BuyPage = new BuyPage();
        var owner = "1223";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setOwner(BuyInfo, owner);
    }

    @Test
    void shouldPassNegativeTestOwner3() {
        var BuyPage = new BuyPage();
        var owner = "Анна-Мария";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setOwner(BuyInfo, owner);
    }

    @Test
    void shouldPassNegativeTestOwner4() {
        var BuyPage = new BuyPage();
        var owner = "Анна Мария";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setOwner(BuyInfo, owner);
    }

    @Test
    void shouldPassNegativeTestCCV1() {
        var BuyPage = new BuyPage();
        var ccv = "один";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setCcv(BuyInfo, ccv);
    }

    @Test
    void shouldPassNegativeTestCCV2() {
        var BuyPage = new BuyPage();
        var ccv = "11";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setCcv(BuyInfo, ccv);
    }

    @Test
    void shouldPassNegativeTestCCV3() {
        var BuyPage = new BuyPage();
        var ccv = "1111";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.setCcv(BuyInfo, ccv);
    }
    @Test
    public void shouldSuccessCreditRequestIfValidApprovedCards() {
        var BuyPage = new BuyPage();
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyPage.validInfo(BuyInfo);

        val expectedStatus = "APPROVED";
        val actualStatus = getCardStatusForPayment();
        assertEquals(expectedStatus, actualStatus);

        val bankIdExpected = getBankId();
        val paymentIdActual = getAmountPayment();
        assertNotNull(bankIdExpected);
        assertNotNull(paymentIdActual);
        assertEquals(bankIdExpected, paymentIdActual);
    }

    @Test
    public void shouldFailurePayIfValidDeclinedCards() {
        var BuyPage = new BuyPage();
        var BuyInfo = DataHelper.getBuyInfo2();
        BuyPage.noValidInfo(BuyInfo);

        val expectedStatus = "DECLINED";
        val actualStatus = getCardStatusForCreditRequest();
        assertEquals(expectedStatus, actualStatus);

        val bankIdExpected = getBankId();
        val paymentIdActual = getPaymentId();
        assertNotNull(bankIdExpected);
        assertNotNull(paymentIdActual);
        assertEquals(bankIdExpected, paymentIdActual);
    }
}