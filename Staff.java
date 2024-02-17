package Entities;

public class Staff extends Person{
	private String Designation;
    private String Qualification;
	private double Salary;

	 
	//parameterized constructor
	public Staff(String ID,String Name,int Age, String Gender,String DOB,String BG,String PhoneNo,String Designation, String Qualification,double Salary){
		super(Name,ID,Age,Gender,DOB,BG,PhoneNo);
		this.Designation = Designation;
        this.Qualification = Qualification;
		this.Salary = Salary;
	}
	
	//setter methods
	public void setDesignation(String Designation){
	    this.Designation = Designation;
	}
	public void setQualification(String Qualification){
        this.Qualification = Qualification;
    }

	public void setSalary(double Salary){this.Salary = Salary;}

	
	//getter methods
	public String getDesignation(){return this.Designation;}
	
	public String getQualification(){return this.Qualification;}

	public double getSalary(){return Salary;}
	
	//display data
	public void ShowInfo(){
        super.ShowInfo();
        System.out.println("Designation : "+this.Designation);
        System.out.println("Qualification : "+this.Qualification);
		System.out.println("Salary : "+this.Salary);
		System.out.println("===============================================");
	}
}