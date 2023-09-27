
package edu.vanier.distancecalculator;

import com.opencsv.exceptions.CsvValidationException;
import edu.vanier.distancecalculator.controllers.PostalCodeController;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This is a JavaFX project template to be used for creating GUI applications.
 * JavaFX 20.0.2 is already linked to this project in the build.gradle file.
 * @link: https://openjfx.io/javadoc/20/
 * @see: Build Scripts/build.gradle
 * @author Sleiman Rabah.
 */
public class MainApp {

    public static void main(String[] args) throws IOException, FileNotFoundException, CsvValidationException {
        System.out.println("Hello there friend!");
        PostalCodeController PCC = new PostalCodeController(("/CSV/zipcodes.csv"));
        // PCC.nearbylocations("V0N")
        System.out.println(PCC.distanceTo("H4L", "H4T"));
//        for (Map.Entry<String, PostalCode> en : PCC.nearbylocations("T9W").entrySet()) {
//            Object key = en.getKey();
//            Object value = en.getValue();
//            System.out.println(key);

    }

}
