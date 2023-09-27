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
 * @author ziadagha
 */
public class PostalCodeController {

    private HashMap<String, PostalCode> postalCodes = new HashMap<String, PostalCode>();

    private String csvFilePath;

    public PostalCodeController(String filePath) {

        this.csvFilePath = PostalCodeController.class.getResource(filePath).getFile();
    }

    public HashMap<String, PostalCode> parse() throws FileNotFoundException, IOException, CsvValidationException {
        CSVReader reader = new CSVReaderBuilder(new FileReader(csvFilePath)).build();
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            int m = 3;
            
            String CTY="";
            
            while (m<(nextLine.length-3)){
                CTY += nextLine[m];
                m++;
                
            }
           
            PostalCode curr = new PostalCode();
            curr.setId(nextLine[0]);
            curr.setCountry(nextLine[1]);
            curr.setPostalCode(nextLine[2]);
            curr.setCity(CTY);
            curr.setProvince(nextLine[nextLine.length-3]);
            curr.setLatitude(parseDouble(nextLine[nextLine.length-2]));
            curr.setLongitude(parseDouble(nextLine[nextLine.length-1]));
            postalCodes.put(nextLine[2], curr);

            // nextLine[] is an array of values from the line
        }
        return postalCodes;
    }

    public double distanceTo(String from, String to) throws IOException, FileNotFoundException, CsvValidationException {
        HashMap<String, PostalCode> Curr = this.parse();
        double lat1 = Curr.get(from).getLatitude();
        double lat2 = Curr.get(to).getLatitude();

        double long1 = Curr.get(from).getLongitude();
        double long2 = Curr.get(to).getLongitude();

        double r = 6378.1;

        double a = Math.pow(Math.sin((lat2 - lat1) / 2), 2);
        double b = Math.pow(Math.sin((long2 - long1) / 2), 2);
        double c = Math.sqrt(a + (Math.cos(lat1) * Math.cos(lat2) * b));

        double d = 2 * r * Math.asin(c);
        return d;
        // make sure that 0=<h<=1, refer to the haversine formula

    }

    public HashMap<String, PostalCode> nearbylocations(String from) throws IOException, FileNotFoundException, CsvValidationException {
        HashMap<String,PostalCode> NBL = new HashMap<String, PostalCode>();
        HashMap<String, PostalCode> Curr = this.parse();
        
        for (Map.Entry<String, PostalCode> entry : Curr.entrySet()) {
            
            double d = distanceTo(from, entry.getKey());
            if (d <= 100 && d!=0)
                NBL.put(entry.getKey(), Curr.get(entry.getKey()));
                
            
        }
        return NBL;
    }

}
