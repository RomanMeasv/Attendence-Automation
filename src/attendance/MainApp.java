package attendance;

import attendance.gui.controller.LoginPageController;
import attendance.gui.controller.RootLayoutController;
import attendance.gui.controller.StudentPageController;
import attendance.gui.controller.TeacherPageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

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
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            RootLayoutController rootLayoutController = loader.getController();
            rootLayoutController.setMainApp(this);
    }

    private void showLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("gui/view/LoginPage.fxml"));
        AnchorPane loginPage = loader.load();

        // Set person overview into the center of root layout.
        rootLayout.setCenter(loginPage);

        // Give the controller access to the main app.
        LoginPageController controller = loader.getController();
        controller.setMainApp(this);
    }

    public void showStudentPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("gui/view/StudentPage.fxml"));
        AnchorPane studentPage = loader.load();

        // Set person overview into the center of root layout.
        rootLayout.setCenter(studentPage);

        // Give the controller access to the main app.
        StudentPageController controller = loader.getController();
        controller.setMainApp(this);
    }

    public void showTeacherPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("gui/view/TeacherPage.fxml"));
        AnchorPane teacherPage = loader.load();

        rootLayout.setCenter(teacherPage);

        // Give the controller access to the main app.
        TeacherPageController controller = loader.getController();
        controller.setMainApp(this);
    }
}
