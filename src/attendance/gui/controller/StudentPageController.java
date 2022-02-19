package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Lesson;
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
    private Label lblClassName, lblLessonName, lblTeacherName, lblLessonPeriod, lblStudentName, lblAbsencePercent;

    private MainApp mainApp;
    private _ClassModel classModel;
    private UserModel userModel;
    private Student loggedStudent;
    private _Class classOfLoggedStudent;
    private Lesson currentLesson;

    public StudentPageController()
    {
        classModel = new _ClassModel();
        userModel = UserModel.getInstance();

        loggedStudent = (Student) userModel.getLoggedUser();
        classOfLoggedStudent = classModel.getClassOfStudent(loggedStudent);
        currentLesson = classOfLoggedStudent.getLessonAt(LocalDateTime.of(2022, 2, 22, 10, 1)); //change this if you wanna display different login time
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblClassName.setText(classOfLoggedStudent.getName());
        lblLessonName.setText(currentLesson.getName());
        lblTeacherName.setText(currentLesson.getTeacher().getName());
        lblLessonPeriod.setText(currentLesson.getLessonPeriodString());
        lblStudentName.setText(loggedStudent.getName());
        lblAbsencePercent.setText(loggedStudent.getTotalAbsenceString());
    }
}
