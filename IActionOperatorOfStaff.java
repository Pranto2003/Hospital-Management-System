package Interface;

import Entities.Staff;

public interface IActionOperatorOfStaff{

	Staff[] ShowAllInfo();

	void AddInfo(Staff s);

	void RemoveInfo(String id);


}