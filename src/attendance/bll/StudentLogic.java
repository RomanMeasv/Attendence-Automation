package attendance.bll;

import attendance.be.Attended;
import attendance.be.Lesson;
import attendance.be.Student;
import attendance.be._Class;
import attendance.dal.MockData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentLogic {
    MockData mockData;
    public StudentLogic(){
        mockData = new MockData();
    }

    public List<Attended> get1Attedance(){
       return mockData.getS1Attendance();
    }

    public List<String> getS1FormatedLessons(){
        List<Lesson> allLessons = mockData.getS1Lessons();
        List<String> formated = new ArrayList<>();
        for(Lesson s : allLessons){
            formated.add(s.getFormatOverView());
        }
        return formated;
    }

//    public List<Lesson> getSpecificDayLesson(LocalDateTime day){
//        List<Lesson> thisDayLessons = new ArrayList<>();
//        for(Lesson l : getS1Lessons()){
//            if(l.getStart().format(DateTimeFormatter.ofPattern("YYYY")));
//        }
//
//    }
}
