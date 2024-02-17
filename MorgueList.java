package EntityList;
import Entities.Morgue;
import Interface.IActionOperatorOfMorgue;

public class MorgueList implements IActionOperatorOfMorgue {
    
	private Morgue[] morgues;

    public MorgueList(int size) {
        this.morgues = new Morgue[size];
    }

    public void AddInfo(Morgue m) {
        boolean flag = false;

        for (int i = 0; i < morgues.length; i++) {
            if (morgues[i] == null) {
                morgues[i] = m;
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("Morgue information added successfully");
        } else {
            System.out.println("Morgue information cannot be added");
        }
    }

    public void RemoveInfo(String id) {
        boolean flag = false;
        for (int i = 0; i < morgues.length; i++) {
        if (morgues[i] != null && morgues[i].getID().equals(id)) {
            morgues[i] = null;
            flag = true;
            break;
        }
    }

    if (flag) {
        System.out.println("Morgue information deleted successfully");
    } else {
        System.out.println("Morgue information not found");
    }
}


    public Morgue getInfoByID(String ID) {
		Morgue m = null;
        for (int i = 0; i < morgues.length; i++) {
            if (morgues[i] != null && morgues[i].getID().equals(ID)) {
                m = morgues[i];
				break;
            }
        }
        return m;
    }

    public Morgue[] ShowAllInfo() {
        for (int i = 0; i < morgues.length; i++) {
            if (morgues[i] != null) {
                System.out.println("-----------------------");
                morgues[i].ShowInfo();
                System.out.println();
            }
        }
        return new Morgue[0];
    }

    public void setAllMorgues(Morgue[] morgues){
        this.morgues = morgues;
    }
    public Morgue[] getAllMorgue(){return morgues;}
}
   
