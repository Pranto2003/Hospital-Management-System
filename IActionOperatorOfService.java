package Interface;

import Entities.Service;

public interface IActionOperatorOfService{

    void AddInfo(Service s);
    void RemoveInfo(String id);
    Service[] ShowAllInfo();


}