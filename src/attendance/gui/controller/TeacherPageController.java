package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Student;
import attendance.be._Class;
import attendance.gui.model._ClassModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class TeacherPageController implements Initializable {
    MainApp mainApp;
    _ClassModel classModel;

    public TeacherPageController()
    {
        classModel = new _ClassModel();
    }

    @FXML
    private TableView<_Class> tbvClasses;
    private TableView<Student> tbvStudents;
    @FXML
    private TableColumn<_Class, String> colClassName;
    private TableColumn<Student, String> colStudentName;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colClassName.setCellValueFactory(new PropertyValueFactory<_Class, String>("name"));

        tbvClasses.getItems().setAll(classModel.getClasses());
    }
}

