package com.jdbcconnection.connection;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection {


   @Value("${mysql.url}")
    private String url;

   @Value("${mysql.username}")
    private String username;
  @Value("${mysql.password}")
    private String password;

 @Value("${mysql.driver}")
    private  String Driver;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public void display()
    {
        System.out.println("url = " + url +"uname = " + username + "passw + " + password + "Driver =" + Driver);

    }

    public void jdbcdb() throws Exception
    {
        String Quiry = "select * from studenttable";
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("success" + con);

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(Quiry);
        while(rs.next()){
            String userdata   = rs.getInt(1)+":"+rs.getString(2);
            System.out.println(userdata);
        }
        st.close();
        con.close();

    }


}
