package attendance.gui.controller;

import attendance.gui.model.StudentModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class StudentOverviewController implements Initializable {
    StudentModel studentModel = new StudentModel();
    @FXML
    private DatePicker datePicker;
    @FXML
    private ListView ltvClasses, ltvAttendend;

    public LocalDate getDatePickerValue(){
        return datePicker.getValue();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

}
