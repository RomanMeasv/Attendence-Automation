package attendance.bll;

import attendance.be.Attended;
import attendance.be.Student;
import attendance.dal.MockData;

import java.util.List;

public class StudentLogic {
    MockData mockData;
    public StudentLogic(){
        mockData = new MockData();
    }

    public List<Attended> get1Attedance(){
       return mockData.getS1Attendance();
    }
}
