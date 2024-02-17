package Interface;

import Entities.Morgue;

public interface IActionOperatorOfMorgue{

    void AddInfo(Morgue m);
    void RemoveInfo(String id);
    Morgue[] ShowAllInfo();

}