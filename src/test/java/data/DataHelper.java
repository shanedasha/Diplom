package data;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DataHelper {
    @Data
    @AllArgsConstructor
    public static class BuyInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String ccv;
    }

    public static BuyInfo getBuyInfo1() {
        return new BuyInfo("4444 4444 4444 4441", "08", "22", "Sonya", "112");
    }

    public static BuyInfo getBuyInfo2() {
        return new BuyInfo("4444 4444 4444 4442", "08", "22", "Vasya", "122");
    }
}
