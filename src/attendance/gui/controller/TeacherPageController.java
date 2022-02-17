package attendance.gui.controller;

import attendance.MainApp;
import attendance.be._Class;
import attendance.gui.model.TeacherModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.net.URL;
import java.util.ResourceBundle;


public class TeacherPageController implements Initializable {
    TeacherModel teacherModel = new TeacherModel();
    MainApp mainApp;

    @FXML
    private TableColumn  teacherClass;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

