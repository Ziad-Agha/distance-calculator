/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.vanier.distancecalculator.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ziadagha Here is the class that represents each postal code.
 * information for each postal code can be stores in instances of each class.
 */
public class PostalCode {

    private SimpleStringProperty id;

    private SimpleStringProperty country;

    private SimpleStringProperty postalCode;

    private SimpleStringProperty city;

    private SimpleStringProperty province;

    private SimpleDoubleProperty latitude;

    private SimpleDoubleProperty longitude;

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city = new SimpleStringProperty(city);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id = new SimpleStringProperty(id);

    }

    public String getCountry() {
        return country.get();
    }

    public void setCountry(String country) {
        this.country = new SimpleStringProperty(country);
    }

    public String getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = new SimpleStringProperty(postalCode);
    }

    public String getProvince() {
        return province.get();
    }

    public void setProvince(String province) {
        this.province = new SimpleStringProperty(province);
    }

    public double getLatitude() {
        return latitude.get();
    }

    public void setLatitude(double latitude) {
        this.latitude = new SimpleDoubleProperty(latitude);
    }

    public double getLongitude() {
        return longitude.get();
    }

    public void setLongitude(double longitude) {
        this.longitude = new SimpleDoubleProperty(longitude);
    }

}
