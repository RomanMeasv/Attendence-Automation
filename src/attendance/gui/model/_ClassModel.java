package attendance.gui.model;

import attendance.be._Class;
import attendance.bll._ClassLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class _ClassModel {
    _ClassLogic classLogic;
    ObservableList classes;

    public _ClassModel()
    {
        classLogic = new _ClassLogic();
        classes = FXCollections.observableList(classLogic.getClasses());
    }

    public ObservableList<_Class> getAllClasses(){
        return classes;
    }
}
