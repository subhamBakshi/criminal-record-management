package model;

public class Jailer {

	private int inmate_id;
	private String name;
	private int criminal_id;
	private int crime_id;
	private String sentence;
	private int jail_id;
	private String serving_from;
	private String release_date;
	
	public int getInmate_id() {
		return inmate_id;
	}
	public void setInmate_id(int inmate_id) {
		this.inmate_id = inmate_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCriminal_id() {
		return criminal_id;
	}
	public void setCriminal_id(int criminal_id) {
		this.criminal_id = criminal_id;
	}
	public int getCrime_id() {
		return crime_id;
	}
	public void setCrime_id(int crime_id) {
		this.crime_id = crime_id;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public int getJail_id() {
		return jail_id;
	}
	public void setJail_id(int jail_id) {
		this.jail_id = jail_id;
	}
	public String getServing_from() {
		return serving_from;
	}
	public void setServing_from(String serving_from) {
		this.serving_from = serving_from;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getBehaviour() {
		return behaviour;
	}
	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String behaviour;
	private String status;
	
}
