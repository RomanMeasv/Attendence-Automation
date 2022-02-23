package attendance.gui.view;

import attendance.be.Attended;
import attendance.gui.controller.AttendaceDialogController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;

import java.io.IOException;

public class AttendanceDialog extends Dialog<Attended> {
    private AttendaceDialogController controller;
    public AttendanceDialog(){
        super();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AttendedDialog.fxml"));
            DialogPane dp = loader.load();
            controller = loader.getController();
            this.setTitle("Add/Edit Attendance");
            this.setDialogPane(dp);
            this.setResultConverter(buttonType -> {
                if(buttonType == ButtonType.APPLY){
                    return new Attended(controller.getArrival(), controller.getLeave());
                }
                return null;
            });

        } catch (IOException ioex){
            //System.out.println("Couldn't load view!");
        }
    }
}
