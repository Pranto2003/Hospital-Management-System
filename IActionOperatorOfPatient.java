package Interface;

import Entities.Patient;

public interface IActionOperatorOfPatient{

    void AddInfo(Patient p);
    void RemoveInfo(String id);
    Patient[] ShowAllInfo();
}