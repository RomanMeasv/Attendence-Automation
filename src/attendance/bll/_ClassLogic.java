package attendance.bll;

import attendance.be._Class;
import attendance.dal.MockData;

import java.util.List;

public class _ClassLogic {
    MockData mockData = new MockData();

    public _ClassLogic()
    {
        MockData mockData = new MockData();
    }

    public List<_Class> getAllClasses(){
        return mockData.getAllClasses();
    }
}
