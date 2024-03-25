package kr.co.sist.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static DBConnection dbConn;

    private DBConnection() {}

    public static DBConnection getInstance() {
        if (dbConn == null) {
            dbConn = new DBConnection();
        }

        return dbConn;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        File dbLogin = new File("./DB_login.txt");
        BufferedReader bufReader = null;
        String[] loginInfo = null;

        try {
            bufReader = new BufferedReader(new FileReader(dbLogin));
            loginInfo = bufReader.readLine().split(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Connection conn = DriverManager.getConnection(loginInfo[0], loginInfo[1], loginInfo[2]);
        return conn;
    }

    public void dbClose(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
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
