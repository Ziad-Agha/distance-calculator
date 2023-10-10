/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.vanier.distancecalculator.ui;

import edu.vanier.distancecalculator.models.PostalCode;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * class responsible for creating the table view for the findnearbyLocations
 * functionality.
 *
 * @author ziadagha
 */
public class tablui extends Stage {

    /**
     * the table.
     */
    private TableView table = new TableView();

    /**
     * the id column.
     */
    private TableColumn idColumn = new TableColumn("ID");

    /**
     * the country column.
     */
    private TableColumn conColumn = new TableColumn("Country");

    /**
     * the postal code column.
     */
    private TableColumn pcColumn = new TableColumn("PostalCode");

    /**
     * the city column.
     */
    private TableColumn cityColumn = new TableColumn("City");

    /**
     * the province column.
     */
    private TableColumn provinceColumn = new TableColumn("Province");

    /**
     * the latitude column.
     */
    private TableColumn latColumn = new TableColumn("Latitude");

    /**
     * the longitude column.
     */
    private TableColumn lonColumn = new TableColumn("Longitude");

    /**
     * the list that will contain the postal codes.
     */
    private ObservableList<PostalCode> data = FXCollections.observableArrayList();

    /**
     * constructor for this class. adds all the found postal codes to the list.
     * creates the table view.
     *
     * @param tab
     */
    public tablui(HashMap<String, PostalCode> tab) {
        for (Map.Entry<String, PostalCode> entry : tab.entrySet()) {
            PostalCode val = entry.getValue();
            data.addAll(val);

        }

        table.setEditable(true);

        idColumn.setMinWidth(100);

        conColumn.setMinWidth(100);

        pcColumn.setMinWidth(100);

        cityColumn.setMinWidth(100);

        provinceColumn.setMinWidth(100);

        latColumn.setMinWidth(100);

        lonColumn.setMinWidth(100);

        idColumn.setCellValueFactory(
                new PropertyValueFactory<PostalCode, String>("id"));

        conColumn.setCellValueFactory(
                new PropertyValueFactory<PostalCode, String>("country"));

        cityColumn.setCellValueFactory(
                new PropertyValueFactory<PostalCode, String>("city"));

        pcColumn.setCellValueFactory(
                new PropertyValueFactory<PostalCode, String>("postalCode"));

        provinceColumn.setCellValueFactory(
                new PropertyValueFactory<PostalCode, String>("province"));

        latColumn.setCellValueFactory(
                new PropertyValueFactory<PostalCode, Double>("latitude"));

        lonColumn.setCellValueFactory(
                new PropertyValueFactory<PostalCode, Double>("longitude"));

        table.getColumns().addAll(idColumn, conColumn, pcColumn, cityColumn, provinceColumn, latColumn, lonColumn);

        table.setItems(data);

        VBox root = new VBox(table);

        Scene scene = new Scene(root);

        setScene(scene);

    }

}
