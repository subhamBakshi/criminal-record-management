package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import controller.Main;
import dao.PoliceDAO;
import model.Police;

public class PoliceAccess {

	public void policeFile() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	
			System.out.println();
			System.out.println("=====================================");
			System.out.println("1. View list of police stations \n"
					 + "2. View list of cases \n"
			 		 + "3. Update case list \n"
				 	 + "4. Add a new case \n"
					 + "5. View criminal list \n"
					 + "6. Add a new criminal \n"
					 + "7. Update criminal details \n\n"
					 + "Enter 0 to LOG OUT  ");
			System.out.println("=====================================");
			System.out.println();
		int choice = Integer.parseInt(br.readLine());
		
		Police police = new Police();
		
		switch(choice) {
		
		case 1:
			PoliceDAO.policeStn();
			policeFile();
			break;
		
		case 2:
			PoliceDAO.caseList();
			policeFile();
			break;
		
		case 3:
			PoliceDAO.updatedCaseList(police);
			policeFile();
			break;
		
		case 4:
			PoliceDAO.addCase();
			policeFile();
			break;
			
		case 5:	
			PoliceDAO.criminalList();
			policeFile();
			break;
			
		case 6:
			PoliceDAO.addCriminal();
			policeFile();
			break;
			
		case 7:
			PoliceDAO.updatedCriminalList();
			policeFile();
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
