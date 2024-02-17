package EntityList;
import Entities.Staff;
import Interface.IActionOperatorOfStaff;

public class StaffList implements IActionOperatorOfStaff{
	
	private Staff[] staffs;
	private int numberOfStaffs;

	// Parameterized Constructor
	public StaffList(int size) {
		
		this.staffs = new Staff[size];
		
	}

	// Display Data
	public Staff[] ShowAllInfo() {
        for (int i = 0; i < staffs.length; i++) {
            if (staffs[i] != null) {
                System.out.println("-----------------------");
                staffs[i].ShowInfo();
                System.out.println();
            }
        }
        return new Staff[0];
    }

	// Adding Doctors
	public void AddInfo(Staff s) {
        boolean flag = false;

        for (int i = 0; i < staffs.length; i++) {
            if (staffs[i] == null) {
                staffs[i] = s;
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("Staff information added successfully");
        } else {
            System.out.println("Staff information cannot be added");
        }
    }


	// Deleting doctors
	public void RemoveInfo(String id) {
        boolean flag = false;

        for (int i = 0; i < staffs.length; i++) {
            if (staffs[i] != null && staffs[i].getID().equals(id)) {
                staffs[i] = null;
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("Staff information deleted successfully");
        } else {
            System.out.println("Staff information not found");
        }
    }
	
	// Searching Doctors by ID
	public Staff getInfoByID(String ID) {
		Staff s = null;
        for (int i = 0; i < staffs.length; i++) {
            if (staffs[i] != null && staffs[i].getID().equals(ID)) {
                s = staffs[i];
				break;
            }
        }
        return s;
    }

    public void setAllStaffs(Staff[] staffs){
        this.staffs = staffs;
    }
    public Staff[] getAllStaff(){return staffs;}

}
