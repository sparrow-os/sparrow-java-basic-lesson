package com.sparrow.passport.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCUtils {
    private static Logger logger = LoggerFactory.getLogger(JDBCUtils.class);

    public static Connection getConnection() {
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "11111111";
        String url = "jdbc:mysql://127.0.0.1/sparrow?useSSL=false&autoReconnect=true&failOverReadOnly=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
        try {
            Class.forName(driverClassName);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            logger.error("get connection error url is {}", url, ex);
            return null;
        }
    }

    public static ResultSet query(Connection connection,String sql) throws SQLException {
        Statement statement = null;
        try {
            if (connection != null) {
                statement = connection.createStatement();
                return statement.executeQuery(sql);
            }
            logger.error(" get connection is null");
            return null;
        } catch (Exception e) {
            logger.error("execute sql error ", e);
            return null;
        }
    }

    public static Boolean executeSql(String sql) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            if (connection != null) {
                statement = connection.createStatement();
                return statement.execute(sql);
            }
            logger.error(" get connection is null");
            return null;
        } catch (Exception e) {
            logger.error("execute sql error ", e);
            return null;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
