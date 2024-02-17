package EntityList;
import Entities.Doctor;
import Interface.IActionOperatorOfDoctor;

public class DoctorList implements IActionOperatorOfDoctor{

	private Doctor[] doctors;

	// Parameterized Constructor
	public DoctorList(int size) {

		this.doctors = new Doctor[size];

	}

	// Display Data
	public Doctor[] ShowAllInfo() {
		for (int i = 0; i < doctors.length; i++) {
			if (doctors[i] != null) {
				System.out.println("-----------------------");
				doctors[i].ShowInfo();
				System.out.println();
			}
		}
        return new Doctor[0];
    }

	// Adding Doctors
	public void AddInfo(Doctor s) {
		boolean flag = false;

		for (int i = 0; i < doctors.length; i++) {
			if (doctors[i] == null) {
				doctors[i] = s;
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("Doctor information added successfully");
		} else {
			System.out.println("Doctor information cannot be added");
		}
	}


	// Deleting doctors
	public void RemoveInfo(String s) {
		boolean flag = false;

		for (int i = 0; i < doctors.length; i++) {
			if (doctors[i] != null && doctors[i].equals(s)) {
				doctors[i] = null;
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("Doctor information deleted successfully");
		} else {
			System.out.println("Doctor information not found");
		}
	}

	// Searching Doctors by ID
	public Doctor getInfoByID(String ID) {
		Doctor s = null;
		for (int i = 0; i < doctors.length; i++) {
			if (doctors[i] != null && doctors[i].getID().equals(ID)) {
				s = doctors[i];
				break;
			}
		}
		return s;
	}

	public void setAllDoctors(Doctor[] doctors){
		this.doctors = doctors;
	}
	public Doctor[] getAllDoctor(){return doctors;}
}

