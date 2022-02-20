package attendance.gui.model;

import attendance.be.Attended;
import attendance.be.Lesson;
import attendance.be.Student;
import attendance.bll.StudentLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class StudentModel {
    StudentLogic studentLogic;
    ObservableList<String> lessons;
    public StudentModel() {
        studentLogic = new StudentLogic();
        lessons = FXCollections.observableList(studentLogic.getFormatedLessons());
    }

    public ObservableList<String> getLessons(){return lessons;}

    public ObservableList<String> getLessonsForDay(String day){
        ObservableList<String> lessonsForToday = FXCollections.observableList(studentLogic.getSpecificDayLesson(day));
        return lessonsForToday;
    };

    public ObservableList<String> getLAttendaceForDay(String day, Student s){
        ObservableList<String> attedanceForToday = FXCollections.observableList(studentLogic.getSpecificDayAttendace(day,s));
        return attedanceForToday;
    };

    public ObservableList<Lesson> getAllLessons(LocalDate localDate){
        return FXCollections.observableList(studentLogic.getLessonsForDay( localDate));
    }

}
