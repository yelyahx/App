package controllers;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testarconeccao {

	public static void main(String[] args) throws SQLException {
    System.out.println("Hello, World!");
    //Class.forName("com.mysql.jdbc.Driver");
    
    DriverManager.getConnection("jdbc:mysql://localhost/northwind", "root", "password");
    System.out.println("Conectado !!!");

	}

}
