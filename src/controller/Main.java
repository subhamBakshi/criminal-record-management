package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.LoginDAO;
import model.Login;
import service.CBIAccess;
import service.JailerAccess;
import service.PoliceAccess;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
	
		System.out.println("LOGIN TO SYSTEM!");	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//objects
		Login login = new Login();
		LoginDAO logindao = new LoginDAO();

		System.out.println("Enter Department:");
		String name = br.readLine();
		System.out.println("Enter password:");
		String pass = br.readLine();
			
		login.setUsername(name);
		login.setPassword(pass);
			
		if(logindao.validate(login)==true)
			{
				System.out.println("=====================================");
				System.out.println("Welcome " + name +"!");
				System.out.println("=====================================");
				switch(name) {
				case "police":
					
					PoliceAccess policeFile = new PoliceAccess();
					policeFile.policeFile();
					break;
					
				case "Jailer":
					
					JailerAccess jailerFile = new JailerAccess();
					jailerFile.jailerFile();	
					break;
					
				case "CBI":
					 
					CBIAccess cbi = new CBIAccess();
					cbi.CBIFile();
					break;
				}
			}
		else
			System.out.println("Incorrect Username/ Password");
			Main.main(null); //reloads the username & password option
	}

}
