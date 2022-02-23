package attendance.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class AttendedDialogController implements Initializable {
    @FXML
    private TextField txfArrival, txfLeave;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public LocalDateTime getArrival (){
        return LocalDateTime.parse(txfArrival.getText());
    }
    public LocalDateTime getLeave (){
        return LocalDateTime.parse(txfLeave.getText());
    }
}
