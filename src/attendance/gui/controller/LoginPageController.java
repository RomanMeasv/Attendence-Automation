package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Student;
import attendance.be.Teacher;
import attendance.gui.model.UserModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginPageController {
    MainApp main;
    UserModel userModel;

    @FXML
    TextField txfUsername, txfPassword;

    public LoginPageController()
    {
        userModel = new UserModel();
    }

    public void setMainApp(MainApp main) {
        this.main = main;
    }

    public void handleLogin()
    {
        if (userModel.tryLogIn(txfUsername.getText(), txfPassword.getText()) == null)
        {
            return;
        }
        if (userModel.getLoggedUser().getClass() == Teacher.class)
        {

        }
        if (userModel.getLoggedUser().getClass() == Student.class)
        {

        }
    }
}
