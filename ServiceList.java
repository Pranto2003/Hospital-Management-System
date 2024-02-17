package EntityList;
import Entities.Service;
import Interface.IActionOperatorOfService;

public class ServiceList implements IActionOperatorOfService {
	private Service services[];

	//empty constructor
	public ServiceList(){this.services = new Service[5];}

	//parameterized constructor
	public ServiceList(int sizeOfArray){
	this.services = new Service[sizeOfArray];
	}

	//adding
	public void AddInfo(Service s) {
		boolean flag = false;
		
		for(int i=0; i<services.length; i++) {
			if(services[i] == null) {
				services[i] = s;
				flag = true;
				break;
			}
		}
		
		if(flag){System.out.println("Service information added successfully");}
		else {System.out.println("Service information cannot be taken");}
	}

	//deleting
	public void RemoveInfo(String id) {
		boolean flag = false;
		for(int i = 0; i < services.length; i++) {
			if(services[i] != null && services[i].getPatientID().equals(id)) {
				services[i] = null;
				flag = true;
				break;
			}
		}
		if(flag){
			System.out.println("Service information deleted successfully");}
		else{
			System.out.println("Morgue information not found");}
	}


	public Service getInfoByID(String ID) {
		Service s = null;
		for(int i=0; i<services.length; i++) {
			if (services[i] != null && services[i].getPatientID().equals(ID)) {
				s = services[i];
				break;
			}
		}
		return s;
	}

	//display data
	public Service[] ShowAllInfo() {
		for(int i=0; i<services.length; i++) {
			if(services[i] != null) {
				System.out.println("-----------------------");
				services[i].ShowInfo();
				System.out.println();
			}
		}
        return new Service[0];
    }

	public void setAllServices(Service[] services){
		this.services = services;
	}
	public Service[] getAllService(){return services;}
}
	