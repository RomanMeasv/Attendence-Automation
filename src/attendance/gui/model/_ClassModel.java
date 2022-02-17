package attendance.gui.model;

import attendance.be._Class;
import attendance.bll._ClassLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class _ClassModel {
    _ClassLogic classLogic;
    ObservableList allClasses;

    public _ClassModel()
    {
        classLogic = new _ClassLogic();
        allClasses = FXCollections.observableList(classLogic.getAllClasses());
    }

    public ObservableList<_Class> getAllClasses(){
        return allClasses;
    }
}
