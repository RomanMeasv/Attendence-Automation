package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Student;
import attendance.be._Class;
import attendance.gui.model.UserModel;
import attendance.gui.model._ClassModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class StudentPageController implements Initializable {
    @FXML
    private Label lblCurrentClass, lblLessonName, lblTeacherName, lblLessonPeriod, lblStudentName, lblAbsencePercent;

    MainApp mainApp;
    _ClassModel classModel;
    UserModel userModel;
    Student loggedStudent;

    public StudentPageController()
    {
        classModel = new _ClassModel();
        userModel = UserModel.getInstance();

        loggedStudent = (Student) userModel.getLoggedUser();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblCurrentClass.setText(classModel.getClassOfStudent(loggedStudent).getLessonAt(LocalDateTime.of(2022, 2, 22, 10, 1)).getName());
    }
}
