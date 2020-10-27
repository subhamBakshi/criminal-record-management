package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import controller.Main;
import dao.CBIDAO;
import dao.PoliceDAO;

public class CBIAccess {

public void CBIFile() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	
			System.out.println();
			System.out.println("=====================================");
			System.out.println("1. View list all the criminals \n"
					 + "2. View Personal details of a criminal \n"
			 		 + "3. Search for specific criminal \n\n"
					 + "Enter 0 to LOG OUT  ");
			System.out.println("=====================================");
			System.out.println();
		int choice = Integer.parseInt(br.readLine());
		
	//	CBI police = new CBI();
		
		switch(choice) {
		
		case 1:
			CBIDAO.criminalList();
			CBIFile();
			break;
		
		case 2:
			PoliceDAO.criminalList();
			CBIFile();
			break;
		
		case 3:
			CBIDAO.searchList();
			CBIFile();
			break;
			
		case 0:
			Main.main(null);
			break;
			
		default:
			System.out.println("Please enter a valid choice!");
			break;
		}
	}
}
