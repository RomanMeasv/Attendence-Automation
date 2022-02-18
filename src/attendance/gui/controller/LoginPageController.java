package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Student;
import attendance.be.Teacher;
import attendance.gui.model.UserModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class LoginPageController {
    MainApp mainApp;
    UserModel userModel;

    @FXML
    TextField txfUsername;
    @FXML
    PasswordField pwfPassword;
    @FXML
    Label lblWrongLogin;

    public LoginPageController()
    {
        userModel = UserModel.getInstance();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void loginAction(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            try{
                handleLogin();
            } catch (IOException ex){

            }
        }
    }

    public void handleLogin() throws IOException {
        if (userModel.tryLogIn(txfUsername.getText(), pwfPassword.getText()) == null)
        {
            lblWrongLogin.setVisible(true);
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
