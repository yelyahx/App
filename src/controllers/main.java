package controllers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Customers;

public class main {

	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("Atualize o banco de dados");
		inserir();
		recuperartodos dao = new recuperartodos();
		dao.select();
		
	}
	
	public static void inserir() throws SQLException {
		Connection con = new ConnectionFactory().getConnection();
		
		String sql = "insert into customers (id, company, last_name, first_name, email_address, job_title, business_phone,home_phone,mobile_phone, fax_number, address, city, state_province, zip_postal_code,country_region,web_page,notes,attachments) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, 26);
		stmt.setString(2, "Unaerp");
		stmt.setString(3, "Otávio");
		stmt.setString(4, "Felipe");
		stmt.setString(5, "felipe@email.com");
		stmt.setString(6, "Engsftw");
		stmt.setString(7, "9234-9129");
		stmt.setString(8, "8321-3235");
		stmt.setString(9, "2221-1635");
		stmt.setString(10, "735");
		stmt.setString(11, "Av. Costábile Romano, 2201 - Ribeirânia");
		stmt.setString(12, "Ribeirão Preto");
		stmt.setString(13, "SP");
		stmt.setString(14, "14096-900");
		stmt.setString(15, "Brasil");
		stmt.setString(16, "www.google.com");
		stmt.setString(17, "123");
		stmt.setString(18, "1234");
		stmt.execute();
		
		
		
		con.close();
	}
	
	public void select() {
		Connection con = new ConnectionFactory().getConnection();
		String sql = "select * from customers";
		
		List<Customers> lista = new ArrayList<Customers>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String company = rs.getString("company");
				String last_name = rs.getString("last_name");
				String first_name = rs.getString("first_name");
				String email_address = rs.getString("email_address");
				String job_title = rs.getString("job_title");
				String business_phone = rs.getString("business_phone");
				String home_phone =  rs.getString("home_phone");
				String mobile_phone = rs.getString("mobile_phone");
				String fax_number = rs.getString("fax_number");
				
				Customers os = new Customers();
				os.setId(id);
				os.setCompany(company);
				os.setLast_name(last_name);
				os.setFirst_name(first_name);
				os.setEmail_address(email_address);
				os.setJob_title(job_title);
				os.setBusiness_phone(business_phone);
				os.setHome_phone(home_phone);
				os.setMobile_phone(mobile_phone);
				os.setFax_number(fax_number);
				
				lista.add(os);
			}
			
			rs.close();
			stmt.close();
			
			for (Customers status : lista) {
				System.out.println("Id: "+ status.getId()+ " - Company: "+ status.getCompany()+ "- Last Name: "+ status.getLast_name()+ "- First Name: "+ status.getFirst_name()+ "- Email address: "+ status.getEmail_address());
			}
						
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
