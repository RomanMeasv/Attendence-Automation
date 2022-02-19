package attendance.gui.model;

import attendance.be.Student;
import attendance.be._Class;
import attendance.bll._ClassLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class _ClassModel {
    _ClassLogic classLogic;
    ObservableList<_Class> allClasses;

    public _ClassModel()
    {
        classLogic = new _ClassLogic();
        allClasses = FXCollections.observableList(classLogic.getAllClasses());
    }

    public ObservableList<_Class> getAllClasses(){
        return allClasses;
    }

    public _Class getClassOfStudent(Student student)
    {
        System.out.println(student.getName());
        for (_Class c : allClasses)
        {
            for (Student s : c.getStudents())
            {
                System.out.println(s.getName());
            }
        }
        return allClasses.stream().filter(_class -> _class.getStudents().contains(student)).findFirst().orElse(null);
    }
}
