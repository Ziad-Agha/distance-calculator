/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.vanier.distancecalculator.tests;

import com.opencsv.exceptions.CsvValidationException;
import edu.vanier.distancecalculator.controllers.PostalCodeController;
import edu.vanier.distancecalculator.models.PostalCode;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ziadagha
 */
public class Driver {

    private static PostalCodeController PCC = new PostalCodeController("/CSV/zipcodes.csv");

    public static void main(String[] args) throws IOException, FileNotFoundException, CsvValidationException {

        testParse();
        testDistanceTo("H4T", "H4L");
        testNearbyLocations("H4L", 100);

    }

    public static void testParse() throws IOException, FileNotFoundException, CsvValidationException {
        HashMap<String, PostalCode> test = PCC.parse();

        for (Map.Entry<String, PostalCode> entry : test.entrySet()) {
            String key = entry.getKey();
            PostalCode val = entry.getValue();

            if (key != val.getPostalCode() || key.length() != 3 || val.getPostalCode().length() != 3) {
                System.out.println("false");
                return;
            }
            System.out.println("true");
            return;

        }

    }

    public static void testDistanceTo(String From, String To) throws IOException, FileNotFoundException, CsvValidationException {
        double d = PCC.distanceTo(From, To);

        System.out.println(d);

    }

    public static void testNearbyLocations(String From, double distance) throws IOException, FileNotFoundException, CsvValidationException {

        HashMap<String, PostalCode> test = PCC.nearbylocations(From, distance);
        for (Map.Entry<String, PostalCode> entry : test.entrySet()) {
            String key = entry.getKey();
            PostalCode val = entry.getValue();

            if (!(key.equals(val.getPostalCode()))) {
                System.out.println(key + " " + val.getPostalCode());
                return;
            }
            System.out.println("true");
            return;
        }

    }

}
