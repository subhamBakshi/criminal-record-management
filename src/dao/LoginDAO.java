package dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Login;
import utility.ConnectionManager;

public class LoginDAO {

	public boolean validate(Login login) throws ClassNotFoundException, SQLException, IOException {
		String username = login.getUsername();
		String password = login.getPassword();
		
		Statement st = ConnectionManager.getConnection().createStatement();
		
		//result sets
		ResultSet rs = st.executeQuery("SELECT * FROM criminal_record_management.admin;");
		while(rs.next()) {
			if(username.equals(rs.getString("USERNAME")) && password.equals(rs.getString("PASSWORD"))){
				ConnectionManager.getConnection().close();
				return true;
			}
		}
		ConnectionManager.getConnection().close();
		return false;
	}
}
