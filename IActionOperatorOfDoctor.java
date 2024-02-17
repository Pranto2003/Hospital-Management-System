package Interface;

import Entities.Doctor;

public interface IActionOperatorOfDoctor{

    void AddInfo(Doctor s);
    void RemoveInfo(String s);
    Doctor[] ShowAllInfo();
}