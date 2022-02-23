package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Student;
import attendance.be.Teacher;
import attendance.be._Class;
import attendance.gui.model.UserModel;
import attendance.gui.model._ClassModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class TeacherPageController implements Initializable {
    MainApp mainApp;
    _ClassModel classModel;
    UserModel userModel;
    Teacher loggedTeacher;

    public TeacherPageController()
    {
        classModel = new _ClassModel();
        userModel = UserModel.getInstance();
        loggedTeacher = (Teacher)userModel.getLoggedUser();
    }

    @FXML
    private TableView<_Class> tbvClasses;
    @FXML
    private TableView<Student> tbvStudents;
    @FXML
    private TableColumn<_Class, String> colClassName;
    @FXML
    private TableColumn<Student, String> colStudentName;
    @FXML
    private Label lblTeacherName;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblTeacherName.setText(loggedTeacher.getName());

        colClassName.setCellValueFactory(new PropertyValueFactory<_Class, String>("name"));
        tbvClasses.getItems().setAll(classModel.getAllClasses());

        colStudentName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));

        tbvClasses.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
               tbvStudents.getItems().setAll(newSelection.getStudents());
                try {
                    mainApp.showClassOverview(newSelection);
                } catch (IOException e) {
                    //class overview couldnt be shown
                }
            }
        });

        tbvStudents.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                try {
                    mainApp.showStudentOverview(newSelection);
                } catch (IOException e) {
                    //class overview couldnt be shown
                }
            }
        });
    }
}

