package model;

public class Police {

	private int case_id;
	private int crime_id;
	private String reg_date;
	private int reg_ps;
	private String case_des;
	private String case_status;
	private String name;
	private String dob;
	private String gender;
	private String address;
	private long contact_no;
	public int getCase_id() {
		return case_id;
	}
	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}
	public int getCrime_id() {
		return crime_id;
	}
	public void setCrime_id(int crime_id) {
		this.crime_id = crime_id;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getReg_ps() {
		return reg_ps;
	}
	public void setReg_ps(int reg_ps) {
		this.reg_ps = reg_ps;
	}
	public String getCase_des() {
		return case_des;
	}
	public void setCase_des(String case_des) {
		this.case_des = case_des;
	}
	public String getCase_status() {
		return case_status;
	}
	public String setCase_status(String case_status) {
		return this.case_status = case_status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
}
