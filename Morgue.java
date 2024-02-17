package Entities;

public class Morgue {
    private String name;
    private String DOD;
    private String gender;
    private String ID;
    private String COD;
    // parameterized constructor
    public Morgue(String ID,String name, String gender,String DOD,String COD ) {
        setName(name);
        setDOD(DOD);
        setGender(gender);
        setID(ID);
        setCOD(COD);
    }

    // setter methods
    public void setName(String name) {
        this.name = name;
    }
    public void setDOD(String DOD) {
        this.DOD = DOD;
    }
    public void setCOD(String COD){ this.COD = COD;}

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    // getter methods
    public String getName() {
        return this.name;
    }
    public String getCOD() {
        return this.COD;
    }   

    public String getGender() {
        return this.gender;
    }

    public String getID() {
        return this.ID;
    }
    public String getDOD(){ return DOD;}

    // display data
    public void ShowInfo() {
        System.out.println("Corpse's ID : " +ID);
        System.out.println("Name : " +name);
        System.out.println("Gender: " + gender);
        System.out.println("Date of Death : "+ COD);
        System.out.println("Cause of death : "+DOD);
        System.out.println("===============================================");
    }
}
