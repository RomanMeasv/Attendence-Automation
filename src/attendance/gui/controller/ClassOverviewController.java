package attendance.gui.controller;

import attendance.be.Student;
import attendance.be._Class;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class ClassOverviewController implements Initializable {
    @FXML
    TableView<Student> tbvClassAttendance;
    @FXML
    TableColumn<Student, String> colName, colMostMissedClass, colMostMissedDay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        colMostMissedClass.setCellValueFactory(new PropertyValueFactory<Student, String>("mostMissedClass"));
        colMostMissedDay.setCellValueFactory(new PropertyValueFactory<Student, String>("mostMissedDay"));
    }

    public void showOverviewOf(_Class c)
    {
        tbvClassAttendance.getItems().setAll(c.getStudents());
    }
}
