package mian.JDBC.zsgc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JUITcon {
    public static Connection getConnection() throws Exception{

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user=pros.getProperty("user");
        String password=pros.getProperty("password");
        String url=pros.getProperty("url");
        String driverClass=pros.getProperty("driverClass");

        Class.forName(driverClass);

        Connection conn = DriverManager.getConnection(url, user, password);
       return conn;
    }

    public  static void closeRES(Connection conn, Statement ps){
        try {
            if (ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public  static void closeRES(Connection conn, Statement ps,ResultSet res){
        try {
            if (ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (res!=null){
                res.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
