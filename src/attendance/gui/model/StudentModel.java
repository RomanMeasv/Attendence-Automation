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
    ObservableList<String> lessons;
    public StudentModel() {
        studentLogic = new StudentLogic();
        lessons = FXCollections.observableList(studentLogic.getFormatedLessons());
    }

    public ObservableList<String> getLessons(){return lessons;}
}
