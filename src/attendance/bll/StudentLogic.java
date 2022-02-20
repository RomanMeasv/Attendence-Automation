package attendance.bll;

import attendance.be.Attended;
import attendance.be.Lesson;
import attendance.be.Student;
import attendance.dal.MockData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentLogic {
    MockData mockData;
    public StudentLogic(){
        mockData = new MockData();
    }

    public List<String> getFormatedLessons(){
        List<Lesson> allLessons = mockData.getLessons();
        List<String> formated = new ArrayList<>();
        for(Lesson s : allLessons){
            formated.add(s.getFullLessonInfoString());
        }
        return formated;
    }

    public List<String> getSpecificDayLesson(String day){
        List<String> thisDayLessons = new ArrayList<>();
        for(Lesson l : mockData.getLessons()){
            String date = l.getStart().format(DateTimeFormatter.ISO_DATE);
            if(day.equals(date)){
                thisDayLessons.add(l.getFullLessonInfoString());
            }
        }
        return thisDayLessons;
    }

    public List<String> getSpecificDayAttendace(String day, Student s){
        List<String> thisDayAttendace = new ArrayList<>();
        for(Attended a : s.getAttendeds()){
            String date = a.getStart().format(DateTimeFormatter.ISO_DATE);
            if(day.equals(date)){
                thisDayAttendace.add(a.getFormatOverView());
            }
        }
        return thisDayAttendace;
    }
    //table view rework + renaming it, cause I am giving it random shit I come with now
    public List<Lesson> getLessonsForDay(LocalDate localDate){
        List<Lesson> dayLessons = new ArrayList<>();
        for (Lesson l : mockData.getLessons()){
            if(l.getStart().format(DateTimeFormatter.ISO_DATE).equals(localDate.format(DateTimeFormatter.ISO_DATE))){
                dayLessons.add(l);
            }
        }
        return dayLessons;
    }
}
