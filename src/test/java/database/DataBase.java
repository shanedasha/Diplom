package database;

import data.DataHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static final String url = System.getProperty("db.url");
    private static final String user = System.getProperty("db.user");
    private static final String password = System.getProperty("db.password");
    private static Connection connection;
    
    private static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DataHelper.BuyInfo getNumberCardFromSQL() {
        var runner = new QueryRunner();
        var getNumberCardSQL = "SELECT card FROM cards ORDER BY created DESC LIMIT 1;";
        try (var conn = getConnection()) {
            return runner.query(conn, getNumberCardSQL, new BeanHandler<>(DataHelper.BuyInfo.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
