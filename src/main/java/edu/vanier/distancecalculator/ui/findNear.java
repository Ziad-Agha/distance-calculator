/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.vanier.distancecalculator.ui;

import com.opencsv.exceptions.CsvValidationException;
import edu.vanier.distancecalculator.controllers.PostalCodeController;
import edu.vanier.distancecalculator.models.PostalCode;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ziadagha
 */
public class findNear extends Stage {

    /**
     * controller instance that contains the findNearbyLocations functionality.
     */
    private PostalCodeController pcc = new PostalCodeController("/CSV/zipcodes.csv");

    /**
     * constructor for this class creates a new window on top of the owner
     * window that prompts the user to enter a postal code and a radius, the
     * button will find all the postal codes nearby and display them in table
     * and as a log message.
     *
     * @param Primary owner stage
     */
    public findNear(Stage Primary) {
        initOwner(Primary);
        initModality(Modality.WINDOW_MODAL);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 500, 500);
        setScene(scene);
        Text scenetitle = new Text("Insert a valid Postal Code and a radius in Km");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label From = new Label("Postal Code: (Only 3 inputs will be accepted) ");
        grid.add(From, 0, 1);

        TextField P1 = new TextField();
        grid.add(P1, 1, 1);

        Label radius = new Label("Radius: (Only number values will be accepted) ");
        grid.add(radius, 0, 2);

        TextField R = new TextField();
        grid.add(R, 1, 2);

        R.textProperty().addListener((observable) -> {

            if (!R.getText().matches("\\d*")) {
                R.setText(R.getText().replaceAll("[^\\d]", ""));
            }
        });
        P1.textProperty().addListener((observable) -> {

            if (P1.getText().length() > 3) {
                String s = P1.getText().substring(0, 3);
                P1.setText(s);
            }
        });

        Button btn = new Button("Find locations");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        btn.setOnAction((event) -> {

            HashMap<String, PostalCode> NBL = null;

            try {
                if (R.getText().isEmpty() || R.getText().isBlank()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR!");
                    alert.setContentText("Please enter a valid PostalCode and a Number");
                    alert.showAndWait();

                } else {

                    NBL = pcc.nearbylocations(P1.getText().toUpperCase(), Double.parseDouble(R.getText()));

                    if (NBL == null) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!");
                        alert.setContentText("Please enter a valid PostalCode and a Number");
                        alert.showAndWait();
                    } else {

                        tablui table = new tablui(NBL);
                        table.showAndWait();
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(findNear.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CsvValidationException ex) {
                Logger.getLogger(findNear.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

}
