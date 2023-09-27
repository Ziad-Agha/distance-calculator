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
   private PostalCodeController PCC = new PostalCodeController("/CSV/zipcodes.csv");
    
    public static void main(String[] args) {
        
        
        
    }
    public void testParse(String filePath) throws IOException, FileNotFoundException, CsvValidationException{
        HashMap<String,PostalCode> test = PCC.parse();
        
        for (Map.Entry<String, PostalCode> entry : test.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            
        }
        
        
    }
    
    public void testDistanceTo(String From){
        
    }
    
    public void testNearbyLocations(String From){
        
        
    }

}
