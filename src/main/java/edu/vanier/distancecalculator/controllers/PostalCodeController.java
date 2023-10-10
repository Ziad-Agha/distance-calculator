/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.vanier.distancecalculator.controllers;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import edu.vanier.distancecalculator.models.PostalCode;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ziadagha Controller class the provides the functionalities of the
 * application.
 */
public class PostalCodeController {

    /**
     * The Hashmap that will store all the postal codes.
     */
    private HashMap<String, PostalCode> postalCodes = new HashMap<String, PostalCode>();

    /**
     * contains the filepath inorder to access the csvfile.
     */
    private String csvFilePath;

    /**
     * class constructor specifying the filepath of the csv file.
     *
     * @param filepath the filepath.
     */
    public PostalCodeController(String filePath) {

        this.csvFilePath = PostalCodeController.class.getResource(filePath).getFile();
    }

    /**
     * loads all the postal codes from the csv file into the hashmap as
     * instances of the postal code class.
     *
     * @return the hashmap.
     */
    public HashMap<String, PostalCode> parse() throws FileNotFoundException, IOException, CsvValidationException {
        CSVReader reader = new CSVReaderBuilder(new FileReader(csvFilePath)).build();
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            int m = 3;

            String CTY = "";

            while (m < (nextLine.length - 3)) {
                CTY += nextLine[m];
                m++;

            }

            PostalCode curr = new PostalCode();
            curr.setId(nextLine[0]);
            curr.setCountry(nextLine[1]);
            curr.setPostalCode(nextLine[2]);
            curr.setCity(CTY);
            curr.setProvince(nextLine[nextLine.length - 3]);
            curr.setLatitude(parseDouble(nextLine[nextLine.length - 2]));
            curr.setLongitude(parseDouble(nextLine[nextLine.length - 1]));
            postalCodes.put(nextLine[2], curr);

            // nextLine[] is an array of values from the line
        }
        return postalCodes;
    }

    /**
     * calculates the distance between 2 postalcodes.
     *
     * @param from the first postalcode
     * @param to the second postalcode
     * @return the distance
     * @throws IOException
     * @throws FileNotFoundException
     * @throws CsvValidationException
     */
    public double distanceTo(String from, String to) throws IOException, FileNotFoundException, CsvValidationException {
        HashMap<String, PostalCode> Curr = this.parse();
        if (Curr.containsKey(from) && Curr.containsKey(to)) {

            double lat1 = Curr.get(from).getLatitude();
            double lat2 = Curr.get(to).getLatitude();

            double long1 = Curr.get(from).getLongitude();
            double long2 = Curr.get(to).getLongitude();

            long1 = Math.toRadians(long1);
            long2 = Math.toRadians(long2);
            lat1 = Math.toRadians(lat1);
            lat2 = Math.toRadians(lat2);

            double r = 6378.1;

            double a = Math.pow(Math.sin((lat2 - lat1) / 2), 2);
            double b = Math.pow(Math.sin((long2 - long1) / 2), 2);
            double c = Math.sqrt(a + (Math.cos(lat1) * Math.cos(lat2) * b));

            double d = 2 * r * Math.asin(c);
            return Math.round(d);
        } else {
            return -1;
        }
    }

    /**
     * stores all nearby postal codes of the specified postalcode in a hashmap.
     *
     * @param from the postal code
     * @param radius the radius
     * @return a hashmap of all nearby postal codes
     * @throws IOException
     * @throws FileNotFoundException
     * @throws CsvValidationException
     */
    public HashMap<String, PostalCode> nearbylocations(String from, double radius) throws IOException, FileNotFoundException, CsvValidationException {
        HashMap<String, PostalCode> NBL = new HashMap<String, PostalCode>();
        HashMap<String, PostalCode> Curr = this.parse();

        for (Map.Entry<String, PostalCode> entry : Curr.entrySet()) {

            double d = distanceTo(from, entry.getKey());
            if (d == -1) {
                return null;
            }
            if (d <= radius && d != 0) {
                NBL.put(entry.getKey(), entry.getValue());
                System.out.println(entry.getValue().getId() + ", "
                        + entry.getValue().getId() + ", "
                        + entry.getValue().getCountry() + ", "
                        + entry.getValue().getPostalCode() + ", "
                        + entry.getValue().getCity() + ", "
                        + entry.getValue().getProvince() + ", "
                        + entry.getValue().getLatitude() + ", "
                        + entry.getValue().getLongitude());

            }

        }
        return NBL;
    }

}
