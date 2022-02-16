package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Student;
import attendance.be.Teacher;
import attendance.gui.model.UserModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginPageController {
    MainApp mainApp;
    UserModel userModel;

    @FXML
    TextField txfUsername, txfPassword;

    public LoginPageController()
    {
        userModel = new UserModel();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void handleLogin() throws IOException {
        if (userModel.tryLogIn(txfUsername.getText(), txfPassword.getText()) == null)
        {
            return;
        }
        if (userModel.getLoggedUser().getClass() == Teacher.class)
        {
            mainApp.showTeacherPage();
        }
        if (userModel.getLoggedUser().getClass() == Student.class)
        {
            mainApp.showStudentPage();
        }
    }
}
