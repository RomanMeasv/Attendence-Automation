package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Attended;
import attendance.be.Lesson;
import attendance.be.Student;
import attendance.be._Class;
import attendance.gui.model.StudentModel;
import attendance.gui.model.UserModel;
import attendance.gui.model._ClassModel;
import attendance.gui.view.AttendanceDialog;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentPageController implements Initializable {
    @FXML
    private Label lblClassName, lblLessonName, lblTeacherName, lblLessonPeriod, lblStudentName, lblAbsencePercent;
    @FXML
    private TableView<Attended> tbvAttendance;
    @FXML
    private TableColumn<Attended, String> colArrived, colLeft;

    private MainApp mainApp;
    private _ClassModel classModel;
    private UserModel userModel;
    private Student loggedStudent;
    private _Class classOfLoggedStudent;
    private Lesson currentLesson;

    private StudentModel studentModel;

    public StudentPageController()
    {
        classModel = new _ClassModel();
        userModel = UserModel.getInstance();
        studentModel = new StudentModel();

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

        colArrived.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        colLeft.setCellValueFactory(new PropertyValueFactory<>("endTime"));

        tbvAttendance.setItems(loggedStudent.getAttendanceForDay(LocalDate.now()));


    }

    //we don t need this since it is just to pop up and show that it works but doesnt work xD
    //public void handleAddAttended()
    {
        System.out.println("To be implemented...");
    }

    public void handleRemoveAttended()
    {
        int selectedIndex = tbvAttendance.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1)
        {
            tbvAttendance.getItems().remove(selectedIndex);
        }
    }

    public void handleEditAttended() {
        AttendanceDialog dialog = new AttendanceDialog();
        dialog.showAndWait();
    }
}
