package EntityList;
import Entities.Patient;
import Interface.IActionOperatorOfPatient;

public class PatientList implements IActionOperatorOfPatient {
	private Patient patients[];
	
	//empty constructor
	public PatientList(){
		this.patients = new Patient[5];
	}
	
	//parameterized constructor
	public PatientList(int size){
		this.patients = new Patient[size];
	}

	//adding patients
	public void AddInfo(Patient p) {
		boolean flag = false;

		for (int i = 0; i < patients.length; i++) {
			if (patients[i] == null) {
				patients[i] = p;
				flag = true;
				break;
			}
		}

		if (flag) {System.out.println("Patient information added successfully");}
		else {System.out.println("Patient information cannot be added");}
	}
	
	//deleting patients
	public void RemoveInfo(String id) {
		boolean flag = false;
		for (int i = 0; i < patients.length; i++) {
			if (patients[i] != null && patients[i].getID().equals(id)) {
				patients[i] = null;
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("Patient information deleted successfully");}
		else {
			System.out.println("Patient information not found");
		}
	}
	
	//searching patients by ID
	public Patient getInfoByID(String ID) {
		Patient p = null;
		for (int i = 0; i < patients.length; i++) {
			if (patients[i] != null && patients[i].getID().equals(ID)) {
				p = patients[i];
				break;
			}
		}
		return p;
	}

	//display data
	public Patient[] ShowAllInfo() {
		for (int i = 0; i < patients.length; i++) {
			if (patients[i] != null) {
				System.out.println("-----------------------");
				patients[i].ShowInfo();
				System.out.println();
			}
		}
		return new Patient[0];
	}

	public void setAllPatients(Patient[] patients){
		this.patients = patients;
	}
	public Patient[] getAllPatient(){return patients;}
}