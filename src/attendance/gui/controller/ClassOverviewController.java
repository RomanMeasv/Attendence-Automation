package attendance.gui.controller;

import attendance.MainApp;
import attendance.be.Student;
import attendance.be._Class;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.chart.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import javax.swing.event.ChangeListener;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ClassOverviewController implements Initializable {
    MainApp mainApp;
    VBox root;

    @FXML
    TableView<Student> tbvClassAttendance;
    @FXML
    TableColumn<Student, String> colName, colTotal, colMostMissedClass, colMostMissedDay;
    @FXML
    ChoiceBox chbChart;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        colTotal.setCellValueFactory(data -> new SimpleStringProperty(String.format("%.2f", data.getValue().getTotalAbsence())+"%"));
        colMostMissedClass.setCellValueFactory(new PropertyValueFactory<Student, String>("mostMissedClass"));
        colMostMissedDay.setCellValueFactory(new PropertyValueFactory<Student, String>("mostMissedDay"));

        chbChart.getItems().add("Most missed days");
        chbChart.getItems().add("Most missed classes");
        chbChart.setValue(chbChart.getItems().get(0));

        chbChart.getSelectionModel()
                .selectedItemProperty()
                .addListener( (obs, newValue, oldValue) ->  showChart(oldValue.toString()));
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
        series.getData().add(new XYChart.Data("ITO", 10));
        series.getData().add(new XYChart.Data("SCO", 15));
        series.getData().add(new XYChart.Data("SDE", 40));
        series.getData().add(new XYChart.Data("DBO", 5));

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
                        new PieChart.Data("Tuesday", 25),
                        new PieChart.Data("Wednesday", 10),
                        new PieChart.Data("Thursday", 25),
                        new PieChart.Data("Friday", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Most missed days");

        root.getChildren().add(chart);
    }

    public void showOverviewOf(_Class c)
    {
        tbvClassAttendance.getItems().setAll(c.getStudents());
        showMostMissedDaysChart();
    }

    public void setRootElement(VBox root) {
        this.root = root;
    }
}
