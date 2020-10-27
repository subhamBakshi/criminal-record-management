package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Police;
import service.PoliceAccess;
import utility.ConnectionManager;

public class PoliceDAO {

	//case 1 (list of police stations)
	public static void policeStn() throws ClassNotFoundException, SQLException, IOException {
		
		Statement st = ConnectionManager.getConnection().createStatement();
		//result sets
		ResultSet rs = st.executeQuery("SELECT * FROM criminal_record_management.police_station;");
		System.out.println("List of police stations: ");
		
		while(rs.next()) {
		  System.out.print("ID: "+rs.getInt("ID")+", ");
	      System.out.print("Name: "+rs.getString("NAME")+", ");
	      System.out.print("City ID: "+rs.getInt("city_id")+", ");
	      System.out.print("Helpline no: "+rs.getInt("helpline_no"));
	      System.out.println();	
		}
		//ConnectionManager.getConnection().close();
	}
	
	
	//case 2 (list of cases)
	public static void caseList() throws ClassNotFoundException, SQLException, IOException {
		
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM criminal_record_management.case_table;");
		System.out.println("List of cases: ");
		
		while(rs.next()) {
	      System.out.print("Case ID: "+rs.getInt("case_id")+", ");
	      System.out.print("Crime ID: "+rs.getInt("crime_id")+", ");
	      System.out.print("Reg Date: "+rs.getDate("registration_date")+", ");
	      System.out.print("Reg PS: "+rs.getInt("registered_PS")+", ");
	      System.out.print("Case Description: "+rs.getString("case_description")+", ");
	      System.out.print("Case Status: "+rs.getString("case_status"));
	      System.out.println();
		}
	//	ConnectionManager.getConnection().close();
	}
	
	
	//case 3 (updating case status only)
	public static void updatedCaseList(Police police) throws ClassNotFoundException, SQLException, IOException {
		caseList();
		int case_id = police.getCase_id();
		String case_status = police.getCase_status();

		Statement st = ConnectionManager.getConnection().createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1. Enter Case ID: \n"
				+ "2. Enter Case Status: \n");
	    case_id= Integer.parseInt(br.readLine());
		case_status= br.readLine();
		String sql = "UPDATE criminal_record_management.case_table SET case_status= " +case_status+" WHERE case_id="+case_id +";";
				int rs = st.executeUpdate(sql);
				if(rs>0) {
			System.out.println(rs + " records updated");
			System.out.println(sql);
				}else
					System.out.println("\nInvalid data entered, no records updated");
	
		//System.out.println("________________________________________________________________________________________________________________________________________________________________________________");

		PoliceAccess prev = new PoliceAccess();
		prev.policeFile();
	}
	
	
	//case 4 (adding a new case)	
	public static boolean addCase() throws ClassNotFoundException, IOException, SQLException 
	{
		Statement st = ConnectionManager.getConnection().createStatement();
		if (st != null) 
		{
		  try {
			    //user inputs
			  BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter Case ID: ");
				int case_id = Integer.parseInt(sc.readLine());
				System.out.println("Enter Crime ID: ");
				int crime_id = Integer.parseInt(sc.readLine());
				System.out.println("Enter Registration Date: ");
				String reg_date = sc.readLine();
				System.out.println("Enter Registered Police Station ID: ");
				int reg_ps = Integer.parseInt(sc.readLine());
				System.out.println("Enter Case Description: ");
				String case_des = sc.readLine();
				System.out.println("Enter Case Status: ");
				String case_status = sc.readLine();
				
				//sql query
				String insertSQL = "INSERT INTO criminal_record_management.case_table(case_id, crime_id, registration_date, registered_PS, case_description, case_status) values (?,?,?,?,?,?);";
				PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(insertSQL);
				
				statement.setInt(1, case_id);
				statement.setInt(2, crime_id);
				statement.setString(3, reg_date);
				statement.setInt(4, reg_ps);
				statement.setString(5, case_des);
				statement.setString(6, case_status);			
			
				int rowAffected = statement.executeUpdate();
				if (rowAffected > 0)
				{
					System.out.println("New case added to the database \n");
					// display back the updated case list
					System.out.println("Upadated cases list: \n");
					PoliceDAO.caseList();
					return true;
				}
				else
					return false;
			  } 
			   catch (SQLException e) 
			   {
				e.printStackTrace();
			   }
 		 }
		return false;
	}
	
	
	
	//case 5 (view list of all the existing criminals)
	public static void criminalList() throws ClassNotFoundException, SQLException, IOException {
		
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM criminal_record_management.criminal;");
		System.out.println("List of Criminals: ");
		
		while(rs.next()) {
		  System.out.print(rs.getRow());
	      System.out.print("Criminal ID: "+rs.getInt("id")+", ");
	      System.out.print("Photo: "+rs.getBlob("photo")+", ");
	      System.out.print("Name: "+rs.getString("NAME")+", ");
	      System.out.print("DOB: "+rs.getDate("dob")+", ");
	      System.out.print("sex: "+rs.getString("gender")+", ");	      
	      System.out.print("Address: "+rs.getString("address")+", ");
	      System.out.print("Contact no.: "+rs.getLong("contact_no"));
	      System.out.println();
		}
	//	ConnectionManager.getConnection().close();
	}
	
	
	//case 6 (add names of criminals)
	public static boolean addCriminal() throws ClassNotFoundException, IOException, SQLException 
	{
		Statement st = ConnectionManager.getConnection().createStatement();
		if (st != null) 
		{
		  try {
			    //user inputs
			  BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter an ID: ");
				int criminal_id = Integer.parseInt(sc.readLine());
				System.out.println("Enter Name: ");
				String name = sc.readLine();
				System.out.println("Enter Date-of-Birth: ");
				String dob = sc.readLine();
				System.out.println("Enter Gender: ");
				String gender = sc.readLine();
				System.out.println("Enter Address: ");
				String address = sc.readLine();
				System.out.println("Enter Contact No.: ");
				long contact_no = Long.parseLong(sc.readLine());
				
				
				//1. proceed, edit, go back
				System.out.println("\nAre you sure the data input is correct? (press 'Y' to proceed or press 'N' to re-enter data \n"
						 + "Press 0 for previous menu");
				String x = sc.readLine();
				if(x=="Y" || x=="y") {	
					//sql query
					String insertSQL = "INSERT INTO criminal_record_management.criminal(id, name, dob, gender, address, contact_no) values (?,?,?,?,?,?);";
					PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(insertSQL);
					
					statement.setInt(1, criminal_id);
					statement.setString(2, name);
					statement.setString(3, dob);
					statement.setString(4, gender);
					statement.setString(5, address);
					statement.setLong(6, contact_no);
					
					int rowAffected = statement.executeUpdate();
					if (rowAffected > 0)
					{
						System.out.println("New criminal registered to the database \n");
						// display the updated criminal list
						System.out.println("Upadated list of criminals: \n");
						PoliceDAO.criminalList();
						return true;
					}else
						return false;
				}
				else if(x=="N"||x=="n") {
					addCriminal();
				} else if(x=="0") {
					PoliceAccess prev = new PoliceAccess();
					prev.policeFile();
				} else 
					System.out.println("Invalid character input");
				
			  }catch (SQLException e) 
			   {
				e.printStackTrace();
			   }
 		 }
		return false;
	}
	
	
	//case 7 (Updating Details of a criminal)
	public static void updatedCriminalList() throws ClassNotFoundException, SQLException, IOException {

		Statement st = ConnectionManager.getConnection().createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Existing Database: \n");
		PoliceDAO.criminalList();
		System.out.println();
		System.out.println("Choose what to edit: \n");
		System.out.println("1. Name of Criminal \n"
						 + "2. Date of Birth \n"
						 + "3. Address \n"
						 + "4. Contact no. \n"
						 + "Press 0 for previous menu");
		int x = Integer.parseInt(br.readLine());
		System.out.println("Enter Criminal ID: ");
		int criminal_id= Integer.parseInt(br.readLine());
		switch(x) {
		case 1:
			
			System.out.println("Enter Name: \n");
			String name= br.readLine();
			String sql = "UPDATE criminal_record_management.criminal SET name= " +name+" WHERE id="+criminal_id +";";
					int rs = st.executeUpdate(sql);
				System.out.println(rs + " records updated");
			break;
			
		case 2:
			System.out.println("Enter updated/corrected DOB: \n");
			String dob= br.readLine();
			String sql2 = "UPDATE criminal_record_management.criminal SET dob= " +dob+" WHERE id="+criminal_id +";";
					int rs2 = st.executeUpdate(sql2);
				System.out.println(rs2 + " records updated");
			break;
			
		case 3:
			System.out.println("Enter updated/corrected address: \n");
			String address= br.readLine();
			String sql3 = "UPDATE criminal_record_management.criminal SET address= " +address+" WHERE id="+criminal_id +";";
					int rs3 = st.executeUpdate(sql3);
				System.out.println(rs3 + " records updated");
			break;
			
		case 4:
			System.out.println("Enter updated/corrected address: \n");
			String contact= br.readLine();
			String sql4 = "UPDATE criminal_record_management.criminal SET contact_no= " +contact+" WHERE id="+criminal_id +";";
					int rs4 = st.executeUpdate(sql4);
				System.out.println(rs4 + " records updated");
			break;
			
		case 0:
			PoliceAccess prev = new PoliceAccess();
			prev.policeFile();
			break;
			
		}
		ConnectionManager.getConnection().close();
		
	}


}
