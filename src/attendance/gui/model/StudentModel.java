package attendance.gui.model;

import attendance.be.Attended;
import attendance.bll.StudentLogic;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class StudentModel {
    StudentLogic studentLogic;
    public StudentModel(){
        studentLogic = new StudentLogic();
    }

    public ObservableList getS1Attendace(){
        return (ObservableList) studentLogic.get1Attedance();
    }
}
