package attendance;

import attendance.be.Student;
import attendance.be._Class;
import attendance.gui.controller.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        Parent loginPage = loader.load();

        // Set person overview into the center of root layout.
        rootLayout.setCenter(loginPage);

        // Give the controller access to the main app.
        LoginPageController controller = loader.getController();
        controller.setMainApp(this);
    }

    public void showStudentPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("gui/view/StudentPage.fxml"));
        Parent studentPage = loader.load();

        // Set person overview into the center of root layout.
        rootLayout.setCenter(studentPage);

        // Give the controller access to the main app.
        StudentPageController controller = loader.getController();
        controller.setMainApp(this);
    }

    public void showTeacherPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("gui/view/TeacherPage.fxml"));
        Parent teacherPage = loader.load();

        rootLayout.setLeft(teacherPage);
        rootLayout.setCenter(null);

        // Give the controller access to the main app.
        TeacherPageController controller = loader.getController();
        controller.setMainApp(this);
    }

    public void showClassOverview(_Class c) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("gui/view/ClassOverview.fxml"));
        Parent classOverview = loader.load();

        rootLayout.setRight(classOverview);

        // Give the controller access to the main app.
        ClassOverviewController controller = loader.getController();
        controller.setMainApp(this);
        controller.setRootElement((VBox)classOverview);
        controller.showOverviewOf(c);
    }

    public void showStudentOverview() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("gui/view/StudentOverview.fxml"));
        Parent studentOverview = loader.load();

        rootLayout.setRight(studentOverview);

        // Give the controller access to the main app.
        StudentOverviewController controller = loader.getController();
        controller.setMainApp(this);
    }
}
