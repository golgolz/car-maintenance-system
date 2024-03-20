package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static DBConnection dbConn;
    private Connection conn;

    private DBConnection() {}

    public static DBConnection getInstance() {
        if (dbConn == null) {
            dbConn = new DBConnection();
        }

        return dbConn;
    }

    public Connection getConnection(String id, String pw) throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:oracle:thin:@192.168.10.216:1521:orcl";

        conn = DriverManager.getConnection(url, id, pw);
        return conn;
    }

    public Connection getConnection(String url, String id, String pw) throws SQLException {
        try {
            Class.forName("orcle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        conn = DriverManager.getConnection(url, id, pw);
        return conn;
    }

    public void dbClose(ResultSet rs, Statement stmt) throws SQLException {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
