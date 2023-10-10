
package edu.vanier.distancecalculator.ui;

import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This is a JavaFX project template to be used for creating GUI applications.
 * JavaFX 20.0.2 is already linked to this project in the build.gradle file.
 * @link: https://openjfx.io/javadoc/20/
 * @see: Build Scripts/build.gradle
 * @author Sleiman Rabah.
 */
public class MainApp extends Application {

    public static void main(String[] args) throws IOException, FileNotFoundException, CsvValidationException {
        launch(args);

    }

    /**
     * starts the application by opening the main window the main window
     * contains 2 buttons, each with its own functionailty on postalcodes each
     * button opens a new window by calling the constructor of either DistanceTo
     * or findNear
     *
     * @param primaryStage the default stage already given by the application.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.isAlwaysOnTop();
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(50); //vertical gap in pixels
        root.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(root, 700, 300);
        primaryStage.setScene(scene);
        Text title = new Text("Distance Application");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        root.addColumn(0, title);

        Button computeDistance = new Button("Compute Distance");
        Button findNearby = new Button("Find nearby locations");

        findNearby.setOnAction((event) -> {
            findNear find = new findNear(primaryStage);
            find.showAndWait();

        });

        computeDistance.setOnAction((event) -> {

            DistanceTo distCalc = new DistanceTo(primaryStage);
            distCalc.showAndWait();
            String d = distCalc.getDistance();

            Label distance = new Label("Distance between " + distCalc.getPostl1() + " and " + distCalc.getPostl2() + " = ");

            Label computedDistance = new Label(d, distance);

            if (distCalc.getDistance() != null) {
                root.addColumn(6, computedDistance);
            }

        });
        primaryStage.show();

        root.addColumn(0, computeDistance);
        root.addColumn(0, findNearby);

    }

}
