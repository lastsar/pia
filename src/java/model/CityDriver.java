/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Lazar
 */
public class CityDriver extends Driver{
    
    private City city;

    public CityDriver(City city, String firstName, String lastName, Date dateOfBirdth, Date driverLicenseIssueDate) {
        super(firstName, lastName, dateOfBirdth, driverLicenseIssueDate);
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
   
}
