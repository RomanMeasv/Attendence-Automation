package attendance.bll;

import attendance.be.Student;
import attendance.be._Class;
import attendance.dal.MockData;

import java.util.ArrayList;
import java.util.List;

public class TeacherLogic {
    MockData mockData = new MockData();

    public List<_Class> getAllClasses(){
        return mockData.getAllClasses();
    }
}
