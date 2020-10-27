package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import controller.Main;
import dao.JailerDAO;

public class JailerAccess {

	public void jailerFile() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		System.out.println("1. View list of Jails \n"
				 + "2. List of prisoners \n"
		 		 + "3. Adding new prisoners \n"
			 	 + "4. Updating Prisoners Details \n"
//				 + "5. View criminal list \n"
//				 + "6. Add a new criminal \n"
				 + "7. Update criminal details \n\n"
				 + "Enter 0 to LOG OUT");
		int choice2 = Integer.parseInt(br.readLine());
		switch(choice2) {
		case 1:
			JailerDAO.jail();
			jailerFile();
			break;
			
		case 2:
			JailerDAO.prisoner();
			jailerFile();
			break;
			
		case 3:
			JailerDAO.addPrisoner();
			jailerFile();
			break;
			
		case 4:
			JailerDAO.updatedPrisonerList();
			jailerFile();
			break;
			
			
			
		case 0:
			Main.main(null);
			break;
		}

		
		
	}
}
