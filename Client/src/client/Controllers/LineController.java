package client.Controllers;

import client.CollectionReports;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Locale;

public class LineController {
    public Button exitLineChart;
    public LineChart<String, Number> lineChart;
    public CategoryAxis xAxis;
    public NumberAxis yAxis;

    public void exitChart(ActionEvent actionEvent) {
        Stage stage = (Stage) exitLineChart.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize(CollectionReports collection){
        //final NumberAxis xAxis = new NumberAxis();
        //final NumberAxis yAxis = new NumberAxis();
       // xAxis.setLabel("Динамика результата расчетов");
        //creating the chart
        //final LineChart<String,Number> lineChart =
          //      new LineChart<String, Number>(xAxis,yAxis);

        //lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        //series.setName("My portfolio");
        //populating the series with data
        int num = collection.getReports().size();
        for(int i = 0; i< num; i++){
            series.getData().add(new XYChart.Data(String.valueOf( i ), collection.getReport( i ).getResult()));
        }
        series.setName("Показатель банкротсва предприятия");
        lineChart.getData().add(series);

    }
}
