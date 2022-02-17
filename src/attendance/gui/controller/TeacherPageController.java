package attendance.gui.controller;

import attendance.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.ResourceBundle;


public class TeacherPageController implements Initializable {
    MainApp mainApp;

    @FXML
    private TableView tbvClasses, tbvStudents;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

