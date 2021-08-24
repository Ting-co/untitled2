package mian.JDBC.jdbccom;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class jdbcComnet {
    @Test
    public  void  getConnection1() throws Exception{
//        InputStream is = jdbcComnet.class.getClassLoader().getResourceAsStream("jdbc.properties");
        InputStream is = jdbcComnet.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user=pros.getProperty("user");
        String password=pros.getProperty("password");
        String url=pros.getProperty("url");
        String driverClass=pros.getProperty("driverClass");

        Class.forName(driverClass);

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }
}
