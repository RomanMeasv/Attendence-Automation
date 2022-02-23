package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Attended;
import attendance.be.Lesson;
import attendance.be.Student;
import attendance.be._Class;
import attendance.gui.model.StudentModel;
import attendance.gui.view.AttendanceDialog;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class StudentOverviewController implements Initializable {
    StudentModel studentModel = new StudentModel();
    private MainApp mainApp;
    private Student s;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private DatePicker datePicker;
    @FXML
    private TableView<Lesson> tbvLessons;
    @FXML
    private TableColumn<Lesson, String> colLessons, colStart, colEnd;
    @FXML
    private TableView<Attended> tbvAttendance;
    @FXML
    private TableColumn<Attended, String> colArrival, colLeft;

    public LocalDate getDatePickerValue(){
        return datePicker.getValue();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setValue( LocalDateTime.now().toLocalDate());
        tbvLessons.setItems(studentModel.getAllLessons(datePicker.getValue()));
        colLessons.setCellValueFactory(new PropertyValueFactory<Lesson, String>("name"));
        colStart.setCellValueFactory(new PropertyValueFactory<Lesson, String>("startTime"));
        colEnd.setCellValueFactory(new PropertyValueFactory<Lesson, String>("endTime"));


    }

    public void getSpecificDate(){
        tbvLessons.setItems(studentModel.getAllLessons(datePicker.getValue()));
        tbvAttendance.setItems(s.getAttendanceForDay(datePicker.getValue()));
        colArrival.setCellValueFactory(new PropertyValueFactory<Attended, String>("startTime"));
        colLeft.setCellValueFactory(new PropertyValueFactory<Attended, String>("endTime"));
    }

    public void showOverviewOf(Student s) {
        this.s = s;
        getSpecificDate();
    }

    public void handleEditAttended() {
        AttendanceDialog dialog = new AttendanceDialog();
        dialog.showAndWait();
    }
}
