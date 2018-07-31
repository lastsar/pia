/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Lazar
 */
public class CityLine extends Line{
    
    private Integer lineNumber;
    private Date departureTime;
    private List<Driver> drivers;

    public CityLine(Integer lineNumber, Date departureTime, List<Driver> drivers, Station departureStation, List<Station> interstations, Station arrivalStation) {
        super(departureStation, interstations, arrivalStation);
        this.lineNumber = lineNumber;
        this.departureTime = departureTime;
        this.drivers = drivers;
    }
 
    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    


 
    
}
