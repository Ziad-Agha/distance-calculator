/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.vanier.distancecalculator.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ziadagha The class that represents each postal code. information for
 * each postal code can be stores in instances of each class.
 */
public class PostalCode {

    /**
     * The id for the postal code as a string.
     */
    private SimpleStringProperty id;

    /**
     * The country for the postal code.
     */
    private SimpleStringProperty country;

    /**
     * The postal code itself as a string.
     */
    private SimpleStringProperty postalCode;

    /**
     * The city for the postal code as a string.
     */
    private SimpleStringProperty city;

    /**
     * The province for the postal code as a string.
     */
    private SimpleStringProperty province;

    /**
     * The latitude for the postal code as a double.
     */
    private SimpleDoubleProperty latitude;

    /**
     * The longitude for the postal code as a double.
     */
    private SimpleDoubleProperty longitude;

    /**
     *
     * Gets the city
     *
     * @return the city
     */
    public String getCity() {

        return city.get();
    }

    /**
     *
     * Sets the city
     *
     * @param city the city.
     */
    public void setCity(String city) {

        this.city = new SimpleStringProperty(city);
    }

    /**
     *
     * Gets the identifier
     *
     * @return the identifier
     */
    public String getId() {

        return id.get();
    }

    /**
     *
     * Sets the identifier
     *
     * @param id the id.
     */
    public void setId(String id) {

        this.id = new SimpleStringProperty(id);

    }

    /**
     *
     * Gets the country
     *
     * @return the country
     */
    public String getCountry() {

        return country.get();
    }

    /**
     *
     * Sets the country
     *
     * @param country the country.
     */
    public void setCountry(String country) {

        this.country = new SimpleStringProperty(country);
    }

    /**
     *
     * Gets the postal code
     *
     * @return the postal code
     */
    public String getPostalCode() {

        return postalCode.get();
    }

    /**
     *
     * Sets the postal code
     *
     * @param postalCode the postal code.
     */
    public void setPostalCode(String postalCode) {

        this.postalCode = new SimpleStringProperty(postalCode);
    }

    /**
     *
     * Gets the province
     *
     * @return the province
     */
    public String getProvince() {

        return province.get();
    }

    /**
     *
     * Sets the province
     *
     * @param province the province.
     */
    public void setProvince(String province) {

        this.province = new SimpleStringProperty(province);
    }

    /**
     *
     * Gets the latitude
     *
     * @return the latitude
     */
    public double getLatitude() {

        return latitude.get();
    }

    /**
     *
     * Sets the latitude
     *
     * @param latitude the latitude.
     */
    public void setLatitude(double latitude) {

        this.latitude = new SimpleDoubleProperty(latitude);
    }

    /**
     *
     * Gets the longitude
     *
     * @return the longitude
     */
    public double getLongitude() {

        return longitude.get();
    }

    /**
     *
     * Sets the longitude
     *
     * @param longitude the longitude.
     */
    public void setLongitude(double longitude) {

        this.longitude = new SimpleDoubleProperty(longitude);
    }

}
