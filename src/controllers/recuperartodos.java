package controllers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Customers;

public class recuperartodos {
	private Connection conexao;
	
	public recuperartodos() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void select() {
		String sql = "select * from customers";
		
		List<Customers> lista = new ArrayList<Customers>();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
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