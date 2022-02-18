package attendance.gui.model;

import attendance.be.Attended;
import attendance.be.Lesson;
import attendance.bll.StudentLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.List;

public class StudentModel {
    StudentLogic studentLogic;
    ObservableList<String> s1Lessons;
    ObservableList<Attended> s1Attendance;
    public StudentModel(){
        studentLogic = new StudentLogic();
        s1Lessons = FXCollections.observableList(studentLogic.getS1FormatedLessons());
        s1Attendance = FXCollections.observableList(studentLogic.get1Attedance());
    }

    public ObservableList<Attended> getS1Attendace(){
        return this.s1Attendance;
    }

    public ObservableList<String> getS1Lessons(){return  this.s1Lessons;}
}
