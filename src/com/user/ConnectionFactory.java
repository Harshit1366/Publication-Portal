/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Deepanshu
 */
public class ConnectionFactory {

    private static ConnectionFactory instance = new ConnectionFactory();
    private final static String URL = "jdbc:mysql://localhost/publication";
    private final static String USER = "root";
    private final static String PASSWORD = "root";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    private ConnectionFactory() {
        try {
           Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
    
    public static Connection getConnection() throws SQLException{
        if(instance == null){
            instance = new ConnectionFactory();
            //System.out.println("NEW CONNECTION!");
        }
        try{
            //System.out.println("CONNECTION CALLED!");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch(SQLException e){
            throw e;
        }
    }

//    private Connection createConnection() throws SQLException{
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//        } catch (SQLException s) {
//            s.printStackTrace();
//        }
//        return connection;
//    }
//
//    public static Connection getConnection() {
//        return instance.createConnection();
//    }
    
    public static void close(Connection connection){
        try{
            if(null!=connection){
                connection.close();
                connection=null;
                //System.out.println("CONNECTION CLOSED");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
