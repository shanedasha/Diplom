package test;

import data.DataHelper;
import database.DataBase;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.BuyInCreditPage;
import page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static database.DataBase.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PayWithCreditCardTest extends MainPage {
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
        mainPage.goToCreditCardPay();
    }

    @Test
    void shouldBuyInCreditWithValidInfo() {
        var BuyInCreditPage = new BuyInCreditPage();
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.validInfo(BuyInfo);
    }

    @Test
    void shouldBuyInCreditWithValidNoInfo() {
        var BuyInCreditPage = new BuyInCreditPage();
        var BuyInfo = DataHelper.getBuyInfo2();
        BuyInCreditPage.noValidInfo(BuyInfo);
    }

    @Test
    void shouldBuyInCreditWithoutInfo() {
        var BuyInCreditPage = new BuyInCreditPage();
        BuyInCreditPage.withoutInfo();
    }

    @Test
    void shouldPassNegativeTestCard1() {
        var BuyInCreditPage = new BuyInCreditPage();
        var cardNumber = "1234 4567 7897";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setNumberCard(BuyInfo, cardNumber);
    }

    @Test
    void shouldPassNegativeTestCard2() {
        var BuyInCreditPage = new BuyInCreditPage();
        var cardNumber = "Vasya";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setNumberCard(BuyInfo, cardNumber);
    }

    @Test
    void shouldPassNegativeTestMonth1() {
        var BuyInCreditPage = new BuyInCreditPage();
        var month = "март";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setMonth(BuyInfo, month);
    }

    @Test
    void shouldPassNegativeTestMonth2() {
        var BuyInCreditPage = new BuyInCreditPage();
        var month = "24";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setMonth(BuyInfo, month);
    }

    @Test
    void shouldPassNegativeTestYear1() {
        var BuyInCreditPage = new BuyInCreditPage();
        var year = "Двадцать второй";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setYear(BuyInfo, year);
    }

    @Test
    void shouldPassNegativeTestYear2() {
        var BuyInCreditPage = new BuyInCreditPage();
        var year = "2022";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setYear(BuyInfo, year);
    }

    @Test
    void shouldPassNegativeTestYear3() {
        var BuyInCreditPage = new BuyInCreditPage();
        var year = "2018";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setYear(BuyInfo, year);
    }

    @Test
    void shouldPassNegativeTestOwner1() {
        var BuyInCreditPage = new BuyInCreditPage();
        var owner = "Фёдор";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setOwner(BuyInfo, owner);
    }

    @Test
    void shouldPassNegativeTestOwner2() {
        var BuyInCreditPage = new BuyInCreditPage();
        var owner = "1223";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setOwner(BuyInfo, owner);
    }

    @Test
    void shouldPassNegativeTestOwner3() {
        var BuyInCreditPage = new BuyInCreditPage();
        var owner = "Анна-Мария";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setOwner(BuyInfo, owner);
    }

    @Test
    void shouldPassNegativeTestOwner4() {
        var BuyInCreditPage = new BuyInCreditPage();
        var owner = "Анна Мария";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setOwner(BuyInfo, owner);
    }

    @Test
    void shouldPassNegativeTestCCV1() {
        var BuyInCreditPage = new BuyInCreditPage();
        var ccv = "один";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setCcv(BuyInfo, ccv);
    }

    @Test
    void shouldPassNegativeTestCCV2() {
        var BuyInCreditPage = new BuyInCreditPage();
        var ccv = "11";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setCcv(BuyInfo, ccv);
    }

    @Test
    void shouldPassNegativeTestCCV3() {
        var BuyInCreditPage = new BuyInCreditPage();
        var ccv = "1111";
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.setCcv(BuyInfo, ccv);
    }
    @Test
    public void shouldSuccessCreditRequestIfValidApprovedCards() {
        var BuyInCreditPage = new BuyInCreditPage();
        var BuyInfo = DataHelper.getBuyInfo1();
        BuyInCreditPage.validInfo(BuyInfo);

        val expectedStatus = "APPROVED";
        val actualStatus = getCardStatusForCreditRequest();
        assertEquals(expectedStatus, actualStatus);

        val bankIdExpected = getBankId();
        val paymentIdActual = getAmountPayment();
        assertNotNull(bankIdExpected);
        assertNotNull(paymentIdActual);
        assertEquals(bankIdExpected, paymentIdActual);
    }

    @Test
    public void shouldFailureCreditPayIfValidDeclinedCards() {
        var BuyInCreditPage = new BuyInCreditPage();
        var BuyInfo = DataHelper.getBuyInfo2();
        BuyInCreditPage.noValidInfo(BuyInfo);

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
