package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseHelper {

    private DataBaseHelper() {
    }
    private static QueryRunner runner;
    private static Connection conn;

    private static String dbUrl = System.getProperty("datasource.url");
    private static String user = System.getProperty("datasource.username");
    private static String password = System.getProperty("datasource.password");
    @SneakyThrows
    public static void setUp() {
        runner = new QueryRunner();
        conn = DriverManager.getConnection(dbUrl, user, password);
    }

    @SneakyThrows
    public static String getStatusPaymentStatus() {
        setUp();;
        var codeSQL = "SELECT status FROM payment_entity ORDER BY created DESC";
        return runner.query(conn, codeSQL, new ScalarHandler<String>());
    }

    @SneakyThrows
    public static String getCreditStatus() {
        setUp();
        var codeQSL = "SELECT status FROM credit_request_entity ORDER BY created DESC";
        return runner.query(conn, codeQSL, new ScalarHandler<String>());
    }
}