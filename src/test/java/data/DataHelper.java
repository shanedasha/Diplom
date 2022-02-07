package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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


    private static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BuyInfo getNumberCardFromSQL() {
        var runner = new QueryRunner();
        var getNumberCardSQL = "SELECT card FROM cards ORDER BY created DESC LIMIT 1;";
        try (var conn = getConnection()) {
            return runner.query(conn, getNumberCardSQL, new BeanHandler<>(BuyInfo.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
