package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import service.CBIAccess;
import utility.ConnectionManager;

public class CBIDAO {

	//Show all criminals
	public static void criminalList() throws ClassNotFoundException, SQLException, IOException {
		
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT criminal_record.criminal_id, criminal.name,  COUNT(case_id)\r\n" + 
				"FROM criminal_record_management.criminal_record\r\n" + 
				"JOIN criminal_record_management.criminal\r\n" + 
				"ON criminal_record.criminal_id = criminal.id\r\n" + 
				"GROUP by criminal_id;");
				
		System.out.println("List of Criminals: ");
		
		while(rs.next()) {
		  System.out.print(rs.getRow()+ ". ");
		  System.out.print("Name: "+rs.getString("NAME")+", \t");
	      System.out.print("Criminal ID: "+rs.getInt("criminal_id")+", \t");
	      System.out.print("No. of cases: "+rs.getInt("COUNT(case_id)")+", ");
	      System.out.println();
	    
		}

		 
	}
	
	
	//case 2 (Search)
	public static void searchList() throws ClassNotFoundException, SQLException, IOException {

		Statement st = ConnectionManager.getConnection().createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println();
		System.out.println("Search by: \n");
		System.out.println("1. Name \n"
						 + "2. Crime \n"
						 + "3. Date of Birth \n"
						 + "4. Gender \n"
						 + "Press 0 for previous menu");
		int x = Integer.parseInt(br.readLine());
		switch(x) {
		case 1:
			System.out.println("Enter Name: \n");
			String name= br.readLine();
			ResultSet rs = st.executeQuery("SELECT * FROM criminal_record_management.criminal where name like '%"+name+"%';");
			System.out.println("Details of "+name+":");
			
			
			while(rs.next()) {
		      System.out.print("Name: "+rs.getString("NAME")+", ");
		      System.out.print("Criminal ID: "+rs.getInt("id")+", ");
		      System.out.print("DOB: "+rs.getDate("dob")+", ");
		      System.out.print("sex: "+rs.getString("gender")+", ");	      
		      System.out.print("Address: "+rs.getString("address")+", ");
		      System.out.print("Contact no.: "+rs.getLong("contact_no"));
		      System.out.println();
			}
			break;
			
			
		case 2:
			System.out.print("__________________________\n");
			System.out.println("Reference for crime ID: ");
			ResultSet cr = st.executeQuery("SELECT * FROM criminal_record_management.crime;");
			while(cr.next()) {
			  System.out.print(cr.getRow()+": \t");
		      System.out.print(cr.getString("name"));
		      System.out.print("\n");
			}
			System.out.print("__________________________\n");
			System.out.println("Enter crime ID: ");
			int crime_id= Integer.parseInt(br.readLine());
			if(crime_id<=22) {
			Statement st2 = ConnectionManager.getConnection().createStatement();
			ResultSet rs2 = st2.executeQuery("select * from criminal_record_management.criminal_record where crime_id like "+crime_id+ ";");
			while(rs2.next()) {
				int id = rs2.getInt("criminal_id");
				Statement st3 = ConnectionManager.getConnection().createStatement();
				ResultSet rs3 = st3.executeQuery("select * from criminal_record_management.criminal where id = "+id+";");
				while(rs3.next()) {
				      System.out.print("Name: "+rs3.getString("NAME")+"\n");
				      System.out.print("Details about "+rs3.getString("NAME")+": \n");
				      System.out.print("Criminal ID: "+rs3.getInt("id")+", ");
				      System.out.print("DOB: "+rs3.getDate("dob")+", ");
				      System.out.print("sex: "+rs3.getString("gender")+", ");	      
				      System.out.print("Address: "+rs3.getString("address")+", ");
				      System.out.print("Contact no.: "+rs3.getLong("contact_no"));
				      System.out.println();
				}
			}
			}else
				System.out.print("No crime registered with this id / invalid id given. Retry.");
				searchList();
			  
			break;
			
			
		case 0:
			CBIAccess prev = new CBIAccess();
			prev.CBIFile();
			break;
			
		}
		
	}
}
