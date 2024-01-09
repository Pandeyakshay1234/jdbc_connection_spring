package com.jdbcconnection.connection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("spring loaded");
        JDBCConnection jdbcConnection = context.getBean("connection" , JDBCConnection.class );
        jdbcConnection.display();
        jdbcConnection.jdbcdb();

    }
}
