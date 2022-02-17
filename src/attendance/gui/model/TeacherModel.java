package attendance.gui.model;

import attendance.be._Class;
import attendance.bll.TeacherLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

public class TeacherModel {
    TeacherLogic teacherLogic = new TeacherLogic();
    ObservableList allClasses = FXCollections.observableList(teacherLogic.getAllClasses());

    public ObservableList<_Class> getAllClasses(){
        return allClasses;
    }
}
