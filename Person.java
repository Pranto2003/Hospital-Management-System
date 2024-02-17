package Entities;

public class Person{
	private String Name;
	private int Age;
	private String  ID;
	private String Gender;
	private String DOB;
	private String BG;
	private String PhoneNo;
	
	//parameterized constructor
	public Person(String Name, String  ID, int Age, String Gender,String DOB,String BG,String PhoneNo){
	   setName(Name);
	   setID(ID);
	   setAge(Age);
	   setGender(Gender);
	   setDOB(DOB);
	   setBG(BG);
	   setPhoneNo(PhoneNo);
	}



	//settermethods
	public void setName(String Name){
		this.Name=Name;
	}
	public void setID(String ID){
		this.ID=ID;
	}
	public void setAge(int Age){
		this.Age = Age;
	}
	public void setGender(String Gender){
		this.Gender=Gender;
	}
	public void setDOB(String DOB) {this.DOB = DOB;}
	public void setBG(String BG){this.BG = BG;}
	public void setPhoneNo(String PhoneNo){this.PhoneNo = PhoneNo;}
	
	//getter methods
	public String getName(){
		return this.Name;
	}
	public String  getID(){
		return this.ID;
	}
	public int getAge(){
		return this.Age;
	}
	public String getGender(){
		return this.Gender;
	}
	public String getDOB(){return this.DOB;}
	public String getBG(){return this.BG;}
	public String getPhoneNo(){return this.PhoneNo;}
	//display data
	public void ShowInfo(){
		System.out.println("Name :"+ Name);
		System.out.println("ID :"+ this.ID);
		System.out.println("Age :"+ this.Age);
		System.out.println("Gender :" + this.Gender);
		System.out.println("Date of Birth:"+DOB);
		System.out.println("Blood Group:"+BG);
		System.out.println("Phone Number:"+this.PhoneNo);
	}
	
}