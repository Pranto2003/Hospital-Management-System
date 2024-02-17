import Entities.*;
import EntityList.*;
import GUI.*;

public class Start{
	
	public static void main(String[] args){

		DoctorList doctorList = new DoctorList(200);
		PatientList patientList = new PatientList(200);
		StaffList staffList = new StaffList(200);
		ServiceList serviceList = new ServiceList(200);
		MorgueList morgueList = new MorgueList(200);

		LogIn log = new LogIn(doctorList,patientList,staffList,morgueList,serviceList);
		log.setVisible(true);
		
	}
}