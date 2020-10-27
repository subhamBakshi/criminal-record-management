package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import service.JailerAccess;
import utility.ConnectionManager;

public class JailerDAO {

	//case 1 (list of jails)
	public static void jail() throws ClassNotFoundException, SQLException, IOException {
			
			Statement st = ConnectionManager.getConnection().createStatement();
			//result sets
			ResultSet rs = st.executeQuery("SELECT * FROM criminal_record_management.jail;");
			System.out.println("Detailed List of Jails: ");
			System.out.println("-----------------------");
			
			while(rs.next()) {
			  System.out.print("ID: "+rs.getInt("ID")+", ");
		      System.out.print("Name: "+rs.getString("NAME")+", ");
		      System.out.print("City ID: "+rs.getInt("city_id")+", ");
		      System.out.print("No. of inmates: "+rs.getInt("no_of_inmates"));
		      System.out.print("Prisoner capacity: "+rs.getInt("prisoner_capacity"));
		      System.out.println();
			}
			 System.out.println("_________________________________________________________________________________________________________________________________________________________________");	
		}
	
	//case 2 (list of prisoners)
	public static void prisoner() throws ClassNotFoundException, SQLException, IOException {
		
		Statement st = ConnectionManager.getConnection().createStatement();
		//result sets
		ResultSet rs = st.executeQuery("SELECT * FROM criminal_record_management.prisoner;");
		System.out.println("Detailed List of Prisoners: ");
		System.out.println("---------------------------");
		
		while(rs.next()) {
		  System.out.print("ID: "+rs.getInt("inmate_id")+", ");
	      System.out.print("Name: "+rs.getString("NAME")+", ");
	      System.out.print("Inmate's ID number: "+rs.getInt("criminal_id")+", ");
	      System.out.print("Jail ID: "+rs.getInt("jail_id")+", ");
	      System.out.print("Sentence: "+rs.getString("sentence")+", ");
	      System.out.print("Serving from: "+rs.getDate("serving_from")+", ");
	      System.out.print("Release Date: "+rs.getDate("release_date")+", ");
	      System.out.print("Behaviour : "+rs.getString("behaviour")+", ");
	      System.out.print("Status: "+rs.getString("status"));
	      
	      System.out.println();	
		}
		 System.out.println("_________________________________________________________________________________________________________________________________________________________________");	
	}
	
	
	//case 3 (adding new prisoners)
	public static boolean addPrisoner() throws ClassNotFoundException, IOException, SQLException 
	{
		Statement st = ConnectionManager.getConnection().createStatement();
		if (st != null) 
		{
		  try {
			    //user inputs
			  BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter new inmate ID: ");
				int inmate_id = Integer.parseInt(sc.readLine());
				System.out.println("Enter Name: ");
				String name = sc.readLine();
				System.out.println("Enter crime ID: ");
				int crime_id = Integer.parseInt(sc.readLine());
				System.out.println("Enter sentence: ");
				String sentence = sc.readLine();
				System.out.println("Enter jail ID: ");
				int jail_id = Integer.parseInt(sc.readLine());
				
				System.out.println("Enter sentence serving date: ");
				String serving_from = sc.readLine();
				System.out.println("Enter date of release: ");
				String release_date = sc.readLine();
				
				
				//sql query
				String insertSQL = "INSERT INTO criminal_record_management.prisoner(inmate_id, name, crime_id, sentence, jail_id, serving_from, release_date) values (?,?,?,?,?,?,?);";
				PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(insertSQL);
				
				statement.setInt(1, inmate_id);
				statement.setString(2, name);
				statement.setInt(3, crime_id);
				statement.setString(4, sentence);
				statement.setInt(5, jail_id);
				statement.setString(6, serving_from);
				statement.setString(7, release_date);
				
				int rowAffected = statement.executeUpdate();
				if (rowAffected > 0)
				{
					System.out.println("New prisoner registered to the database \n");
					// display the updated criminal list
					System.out.println("Upadated list of prisoners: \n");
					JailerDAO.prisoner();
					return true;
				}else
					return false;
				
			  }catch (SQLException e) 
			   {
				e.printStackTrace();
			   }
 		 }
		 System.out.println("_________________________________________________________________________________________________________________________________________________________________");	
		return false;
	}
	
	
	//case 4 (Updating Prisoners Details)
	public static void updatedPrisonerList() throws ClassNotFoundException, SQLException, IOException {

		Statement st = ConnectionManager.getConnection().createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Existing Database: \n");
		prisoner();
		System.out.println();
		System.out.println("Choose what to edit: \n");
		System.out.println("1. Name of Inmate \n"
						 + "2. Sentence \n"
						 + "3. Release Date \n"
						 + "4. Behaviour \n" 
						 + "5. Status \n"
						 + "Press 0 for previous menu");
		
		int x = Integer.parseInt(br.readLine());
		System.out.println("Enter Inmate ID: ");
		int inmate_id= Integer.parseInt(br.readLine());
		switch(x) {
		case 1:
			System.out.println("Enter Name: \n");
			String name= br.readLine();
			String sql = "UPDATE criminal_record_management.prisoner SET name= " +name+" WHERE inmate_id="+inmate_id +";";
					int rs = st.executeUpdate(sql);
				System.out.println(rs + " records updated");
			break;
			
		case 2:
			System.out.println("Enter updated/corrected DOB: \n");
			String sentence= br.readLine();
			String sql2 = "UPDATE criminal_record_management.criminal SET sentence= " +sentence+" WHERE inmate_id="+inmate_id +";";
					int rs2 = st.executeUpdate(sql2);
				System.out.println(rs2 + " records updated");
			break;
			
		case 3:
			System.out.println("Enter updated/corrected address: \n");
			String release_date= br.readLine();
			String sql3 = "UPDATE criminal_record_management.criminal SET release_date= " +release_date+" WHERE inmate_id="+inmate_id +";";
					int rs3 = st.executeUpdate(sql3);
				System.out.println(rs3 + " records updated");
			break;
			
		case 4:
			System.out.println("Enter updated/corrected address: \n");
			String behaviour= br.readLine();
			String sql4 = "UPDATE criminal_record_management.criminal SET behaviour= " +behaviour+" WHERE inmate_id="+inmate_id +";";
					int rs4 = st.executeUpdate(sql4);
				System.out.println(rs4 + " records updated");
			break;
			
		case 5:
			System.out.println("Enter updated/corrected address: \n");
			String status= br.readLine();
			String sql5 = "UPDATE criminal_record_management.criminal SET status= " +status+" WHERE inmate_id="+inmate_id +";";
					int rs5 = st.executeUpdate(sql5);
				System.out.println(rs5 + " records updated");
			break;
			
		case 0:
			JailerAccess prev = new JailerAccess();
			prev.jailerFile();
			break;
			
		}
		 System.out.println("_________________________________________________________________________________________________________________________________________________________________");	
	}
}
