package biz.aavaz.aavazapplicantfreshjrproject.model;

//!!! Serialization to handle json snake case and java camel case
//!!! https://www.javadoc.io/doc/com.google.code.gson/gson/2.6.2/com/google/gson/annotations/SerializedName.html
//!!! https://sites.google.com/site/gson/gson-user-guide#TOC-JSON-Field-Naming-Support (JSON Field Naming Support)

public class User {
    
    	private int id;
	private String Firstname;
	private String Lastname;
	private int age;
	
	//Setter and getter method
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setFirstname(String Firstname) {
		this.Firstname=Firstname;
		
	}
	
	public String getFirstname() {
		return Firstname;
	}
	
	public void setLastname(String Lastname) {
		this.Lastname=Lastname;
	}
	
	public String getLastname() {
		return Lastname;
	}
	
	public void setAge(int age) {
		this.age=age;
		
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "User[id=" + id + "Firstname=" + Firstname + ",Lastname=" + Lastname + ",Age=" + age +"]";
	}
	
    
    
}
