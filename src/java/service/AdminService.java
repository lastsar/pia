/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.City;
import model.CityDriver;
import model.CityLine;
import model.Driver;
import model.Station;

/**
 *
 * @author Lazar
 */
public class AdminService {
    
    public void addCityStation(Station station){
        //hibernate save station
    }
    
    public void addCityDriver(Driver driver){
        //hibernate save driver
    }
    
    public void addStation(Station station){
        //if not exits add station using hibernate
    }
    
    public List<Driver> getAllCityDrivers(City city){
        
        List<Driver> drivers = new ArrayList<>();
        
        Driver driver = null;
        try {
            String firstName = "firstName";
            String lastName = "lastName";
            String sDateOfBirdth = "31/12/1998";
            Date dateOfBirdth=new SimpleDateFormat("dd/MM/yyyy").parse(sDateOfBirdth);
            String sDriverLincenseIssueDate = "31/12/1998";
            Date driverLincenseIssueDate=new SimpleDateFormat("dd/MM/yyyy").parse(sDriverLincenseIssueDate);
            
            driver = new CityDriver(city, firstName, lastName, dateOfBirdth, driverLincenseIssueDate);
        } catch (ParseException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        drivers.add(driver);
        
        
        return drivers;
        
    }
    
}
