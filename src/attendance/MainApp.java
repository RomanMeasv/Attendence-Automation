package attendance;

import attendance.be.Student;
import attendance.be._Class;
import attendance.gui.controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private Stage primaryStage;

    private AnchorPane anchorPane;
    private HBox rootLayout;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Attendance Automation");

        initRootLayout();

        showLoginPage();
    }

    private void initRootLayout() throws IOException {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("gui/view/RootLayout.fxml"));
            anchorPane = loader.load();
            rootLayout = (HBox)anchorPane.getChildren().get(0);
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(anchorPane);
            primaryStage.setScene(scene);
            primaryStage.show();

            RootLayoutController rootLayoutController = loader.getController();
            rootLayoutController.setMainApp(this);
    }

    private void showLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("gui/view/LoginPage.fxml"));
        Parent loginPage = loader.load();

        // Set person overview into the center of root layout.
        rootLayout.getChildren().add(loginPage);

        // Give the controller access to the main app.
        LoginPageController controller = loader.getController();
        controller.setMainApp(this);
    }

    public void showStudentPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("gui/view/StudentPage.fxml"));
        Parent studentPage = loader.load();

        // Set person overview into the center of root layout.
        rootLayout.getChildren().clear();
        rootLayout.getChildren().add(studentPage);

        // Give the controller access to the main app.
        StudentPageController controller = loader.getController();
        controller.setMainApp(this);
    }

    public void showTeacherPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("gui/view/TeacherPage.fxml"));
        Parent teacherPage = loader.load();

        rootLayout.getChildren().clear();
        rootLayout.getChildren().add(teacherPage);

        // Give the controller access to the main app.
        TeacherPageController controller = loader.getController();
        controller.setMainApp(this);
    }

    public void showClassOverview(_Class c) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("gui/view/ClassOverview.fxml"));
        Parent classOverview = loader.load();

        if(rootLayout.getChildren().size() == 1){
            rootLayout.getChildren().add(classOverview);
        } else {
            rootLayout.getChildren().set(1, classOverview);
        }

        // Give the controller access to the main app.
        ClassOverviewController controller = loader.getController();
        controller.setMainApp(this);
        controller.setRootElement((VBox)classOverview);
        controller.showOverviewOf(c);
    }

    public void showStudentOverview(Student s) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("gui/view/StudentOverview.fxml"));
        Parent studentOverview = loader.load();

        if(rootLayout.getChildren().size() == 1){
            rootLayout.getChildren().add(studentOverview);
        } else {
            rootLayout.getChildren().set(1, studentOverview);
        }

        // Give the controller access to the main app.
        StudentOverviewController controller = loader.getController();
        controller.setMainApp(this);
        controller.showOverviewOf(s);
    }
}
