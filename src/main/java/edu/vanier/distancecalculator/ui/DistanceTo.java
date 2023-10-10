/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.vanier.distancecalculator.ui;

import com.opencsv.exceptions.CsvValidationException;
import edu.vanier.distancecalculator.controllers.PostalCodeController;
import java.io.IOException;
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
 * GUI class for opening a new window to prompt the user to enter 2 postal codes
 * and compute their distance.
 *
 * @author ziadagha
 */
public class DistanceTo extends Stage {

    /**
     * double value where distance between the two postalcodes will be stored.
     */
    private double distance;

    /**
     * controller instance that contains the distance functionality.
     */
    private PostalCodeController pcc = new PostalCodeController("/CSV/zipcodes.csv");

    /**
     * string value of the distance
     */
    private String d;

    /**
     * String value where the first postal code is stored.
     */
    private String postl1;

    /**
     * String value where the second postal code is stored.
     */
    private String postl2;

    /**
     * constructor for this class creates a new window on top of the owner
     * window that prompts the user to enter two postal codes, the button will
     * compute the distance and display it on the main window.
     *
     * @param Primary the owner stage.
     */
    public DistanceTo(Stage Primary) {
        initOwner(Primary);
        initModality(Modality.WINDOW_MODAL);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        setScene(scene);
        Text scenetitle = new Text("Insert 2 valid postal codes");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        Text warning = new Text("Only 3 inputs will be accepted in each");
        warning.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));

        grid.add(scenetitle, 0, 0, 2, 1);
        grid.add(warning, 0, 1, 2, 1);

        Label From = new Label("From:");
        grid.add(From, 0, 2);

        TextField P1 = new TextField();
        grid.add(P1, 1, 2);

        Label To = new Label("To:");
        grid.add(To, 0, 3);

        TextField P2 = new TextField();
        grid.add(P2, 1, 3);

        P1.textProperty().addListener((observable) -> {

            if (P1.getText().length() > 3) {
                String s = P1.getText().substring(0, 3);
                P1.setText(s);
            }
        });

        P2.textProperty().addListener((observable) -> {

            if (P2.getText().length() > 3) {
                String s = P2.getText().substring(0, 3);
                P2.setText(s);
            }
        });

        Button btn = new Button("Compute");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);

        btn.setOnAction((event) -> {

            try {
                postl1 = P1.getText().toUpperCase();
                postl2 = P2.getText().toUpperCase();
                this.distance = pcc.distanceTo(postl1, postl2);

                if (distance == -1) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR!");
                    alert.setContentText("Please enter a valid PostalCode");
                    alert.showAndWait();

                } else {
                    d = Double.toString(distance);
                    this.hide();
                }

            } catch (IOException ex) {
                Logger.getLogger(DistanceTo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CsvValidationException ex) {
                Logger.getLogger(DistanceTo.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    /**
     * gets the string value of the first postal code.
     *
     * @return the first postal code.
     */
    public String getPostl1() {
        return postl1;
    }

    /**
     * gets the string value of the second postal code.
     *
     * @return the second postal code.
     */
    public String getPostl2() {
        return postl2;
    }

    /**
     * gets the distance computed in a string
     *
     * @return the distance
     */
    public String getDistance() {
        return d;
    }

}
