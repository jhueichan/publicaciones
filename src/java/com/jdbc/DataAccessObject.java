package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataAccessObject {
	private static Connection connection = null;

	public static Connection getConnection() {
		 Connection Cnn = null;
        try{
            String Url = "jdbc:mysql://localhost:3306/publicaciones";
            String User = "root";
            String Password = "";
            Class.forName("com.mysql.jdbc.Driver");
            Cnn = DriverManager.getConnection(Url, User, Password);
            System.out.println("Exito publicaciones BD");
        }catch(Exception e){
            System.out.println("Error publicaciones BD");
        }
        return Cnn;
	}
}