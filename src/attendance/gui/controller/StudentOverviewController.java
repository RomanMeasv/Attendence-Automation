package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Lesson;
import attendance.be.Student;
import attendance.be._Class;
import attendance.gui.model.StudentModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

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
    private ListView lsvLessons, lsvAttendend;

    public LocalDate getDatePickerValue(){
        return datePicker.getValue();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setValue(LocalDate.now());
        //getSpecificDate(); ?
    }

    public void getSpecificDate(){
        String date = getDatePickerValue().format(DateTimeFormatter.ISO_DATE);
        lsvLessons.setItems(studentModel.getLessonsForDay(date));
        lsvAttendend.setItems(studentModel.getLAttendaceForDay(date, s));
    }

    public void showOverviewOf(Student s) {
        this.s = s;
    }
}
