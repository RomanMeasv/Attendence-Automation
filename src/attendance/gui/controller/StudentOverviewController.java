package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Attended;
import attendance.be.Lesson;
import attendance.be.Student;
import attendance.be._Class;
import attendance.gui.model.StudentModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class StudentOverviewController implements Initializable {
    StudentModel studentModel = new StudentModel();
    private MainApp mainApp;
    private Student s;
    VBox root;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private DatePicker datePicker;
    @FXML
    private TableView<Lesson> tbvLessons;
    @FXML
    private TableColumn<Lesson, String> colLessons, colStart, colEnd;
    @FXML
    private TableView<Attended> tbvAttendance;
    @FXML
    private TableColumn<Attended, String> colArrival, colLeft;
    @FXML
    private ChoiceBox<String> chbChart;

    public LocalDate getDatePickerValue(){
        return datePicker.getValue();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setValue( LocalDateTime.now().toLocalDate());
        tbvLessons.setItems(studentModel.getAllLessons(datePicker.getValue()));
        colLessons.setCellValueFactory(new PropertyValueFactory<Lesson, String>("name"));
        colStart.setCellValueFactory(new PropertyValueFactory<Lesson, String>("startTime"));
        colEnd.setCellValueFactory(new PropertyValueFactory<Lesson, String>("endTime"));

        chbChart.getItems().add("Most missed days");
        chbChart.getItems().add("Most missed classes");
        chbChart.setValue(chbChart.getItems().get(0));

        chbChart.getSelectionModel()
                .selectedItemProperty()
                .addListener( (obs, newValue, oldValue) ->  showChart(oldValue.toString()));
    }

    public void getSpecificDate(){
        tbvLessons.setItems(studentModel.getAllLessons(datePicker.getValue()));
        tbvAttendance.setItems(s.getAttendanceForDay(datePicker.getValue()));
        colArrival.setCellValueFactory(new PropertyValueFactory<Attended, String>("startTime"));
        colLeft.setCellValueFactory(new PropertyValueFactory<Attended, String>("endTime"));
    }

    public void showOverviewOf(Student s) {
        this.s = s;
        getSpecificDate();
        showMostMissedDaysChart();
    }

    public void setRootElement(VBox root) {
        this.root = root;
    }

    public void showChart(String chartName)
    {
        root.getChildren().remove(root.getChildren().size()-1);

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

        root.getChildren().add(bc);
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

        root.getChildren().add(chart);
    }
}
