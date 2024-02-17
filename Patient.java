package Entities;

public class Patient extends Person{

    private String Disease;
    private String AdmitStatus;
    
    public void setDisease(String Disease){
        this.Disease = Disease;
    }
    
    public String getDisease(){
        return Disease;
    }
    
    public void setAdmitStatus(String AdmitStatus){
        this.AdmitStatus = AdmitStatus;
    }
    public String getAdmitStatus(){
        return AdmitStatus;
    }
    
    public Patient(String Name, String ID, int Age, String Gender,String DOB,String BG,String PhoneNo,String Disease,String AdmitStatus){
        super(Name,ID,Age,Gender,DOB,BG,PhoneNo);
        this.Disease = Disease;
        this.AdmitStatus = AdmitStatus;

    }

    public void ShowInfo(){
        super.ShowInfo();
        System.out.println("Disease : "+Disease);
        System.out.println("Admit Status : "+AdmitStatus);
        System.out.println("===============================================");
    }
    
    
}