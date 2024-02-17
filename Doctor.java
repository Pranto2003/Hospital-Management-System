package Entities;

public class Doctor extends Person{

    private String Specialist;
    private String Qualification;
    private int RoomNum;
    private double Salary;

    public void setSpecialist(String Specialist){  this.Specialist = Specialist;}

    public String getSpecialist(){ return Specialist;}

    public void setQualification(String Qualification){ this.Qualification = Qualification;}
	
	public void setSalary(double Salary){this.Salary = Salary;}

    public String getQualification(){
        return Qualification;
    }

    public void setRoomNum(int RoomNum){
        this.RoomNum = RoomNum;
    }

    public int getRoomNum(){
        return RoomNum;
    }

    public double getSalary(){return Salary;}

    public Doctor(String ID, String Name,  int Age, String Gender,String DOB,String BG,String PhoneNo,String Specialist, String Qualification,int RoomNum,double Salary){
        super(Name,ID,Age,Gender,DOB,BG,PhoneNo);
        this.Specialist = Specialist;
        this.Qualification = Qualification;
        this.RoomNum = RoomNum;
        this.Salary = Salary;
    }

    public void ShowInfo(){
        super.ShowInfo();
        System.out.println("Specialist : "+this.Specialist);
        System.out.println("Qualification: "+this.Qualification);
        System.out.println("Room number : "+this.RoomNum);
        System.out.println("Salary : "+this.Salary);
        System.out.println(); 
	}
}






