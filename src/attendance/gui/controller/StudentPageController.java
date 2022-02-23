package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Attended;
import attendance.be.Lesson;
import attendance.be.Student;
import attendance.be._Class;
import attendance.gui.model.StudentModel;
import attendance.gui.model.UserModel;
import attendance.gui.model._ClassModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class StudentPageController implements Initializable {
    @FXML
    private Label lblClassName, lblLessonName, lblTeacherName, lblLessonPeriod, lblStudentName, lblAbsencePercent;
    @FXML
    private TableView<Attended> tbvAttendance;
    @FXML
    private TableColumn<Attended, String> colArrived, colLeft;
    @FXML
    private VBox vbxOverview;
    @FXML
    private ChoiceBox<String> chbChart;

    private MainApp mainApp;
    private _ClassModel classModel;
    private UserModel userModel;
    private Student loggedStudent;
    private _Class classOfLoggedStudent;
    private Lesson currentLesson;

    private StudentModel studentModel;

    public StudentPageController()
    {
        classModel = new _ClassModel();
        userModel = UserModel.getInstance();
        studentModel = new StudentModel();

        loggedStudent = (Student) userModel.getLoggedUser();
        classOfLoggedStudent = classModel.getClassOfStudent(loggedStudent);
        currentLesson = classOfLoggedStudent.getLessonAt(LocalDateTime.of(2022, 2, 22, 10, 1)); //change this if you wanna display different login time
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblClassName.setText(classOfLoggedStudent.getName());
        lblLessonName.setText(currentLesson.getName());
        lblTeacherName.setText(currentLesson.getTeacher().getName());
        lblLessonPeriod.setText(currentLesson.getLessonPeriodString());
        lblStudentName.setText(loggedStudent.getName());
        lblAbsencePercent.setText(loggedStudent.getTotalAbsenceString());

        colArrived.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        colLeft.setCellValueFactory(new PropertyValueFactory<>("endTime"));

        tbvAttendance.setItems(loggedStudent.getAttendanceForDay(LocalDate.now()));

        chbChart.getItems().add("Most missed days");
        chbChart.getItems().add("Most missed classes");
        chbChart.setValue(chbChart.getItems().get(0));

        chbChart.getSelectionModel()
                .selectedItemProperty()
                .addListener( (obs, newValue, oldValue) ->  showChart(oldValue.toString()));

        showMostMissedDaysChart();
    }


    public void handleAddAttended()
    {
        System.out.println("To be implemented...");
    }

    public void handleRemoveAttended()
    {
        int selectedIndex = tbvAttendance.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1)
        {
            tbvAttendance.getItems().remove(selectedIndex);
        }
    }

    public void handleEditAttended()
    {
        System.out.println("To be implemented...");
    }

    public void showChart(String chartName)
    {
        vbxOverview.getChildren().remove(vbxOverview.getChildren().size()-1);

        if (chartName.equals("Most missed days"))
        {
            showMostMissedDaysChart();
        }
        if (chartName.equals("Most missed classes"))
        {
            showMostMissedClassesChart();
        }
    }

    private void showMostMissedClassesChart() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Most missed classes");
        xAxis.setLabel("Class");
        yAxis.setLabel("No. of classes missed");

        XYChart.Series series = new XYChart.Series();

        series.setName("Results");
        series.getData().add(new XYChart.Data("ITO", 70));
        series.getData().add(new XYChart.Data("SCO", 5));
        series.getData().add(new XYChart.Data("SDE", 10));
        series.getData().add(new XYChart.Data("DBO", 15));

        bc.getData().add(series);

        bc.setLegendVisible(false);

        vbxOverview.getChildren().add(bc);
    }

    public void showMostMissedDaysChart()
    {
        //make this actually work based on mock data, taking a _Class as a parameter?
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Monday", 10),
                        new PieChart.Data("Tuesday", 0),
                        new PieChart.Data("Wednesday", 0),
                        new PieChart.Data("Thursday", 7),
                        new PieChart.Data("Friday", 18));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Most missed days");

        vbxOverview.getChildren().add(chart);
    }
}
