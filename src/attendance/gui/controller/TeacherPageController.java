package attendance.gui.controller;

import attendance.MainApp;
import attendance.be._Class;
import attendance.gui.model.TeacherModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class TeacherPageController implements Initializable {
    TeacherModel teacherModel = new TeacherModel();
    MainApp mainApp;
    @FXML
    private TableView<_Class> classTBV;
    @FXML
    private TableColumn<_Class, String> teacherClass;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.classTBV.setItems(teacherModel.getAllClasses());
        this.teacherClass.setCellValueFactory(new PropertyValueFactory<>("name"));
    }
}

