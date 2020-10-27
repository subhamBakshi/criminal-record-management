package model;

public class CBI {

	private int case_id;
	private int crime_id;
	private String reg_date;
	private int reg_ps;
	private String name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
