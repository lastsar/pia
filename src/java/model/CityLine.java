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
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Lazar
 */

@Entity
public class CityLine implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private City city;
    private Integer lineNumber;
    @ManyToOne
    private Station departureStation;
    @ManyToMany(fetch=FetchType.EAGER)
    private List<Station> interStations;
    @ManyToOne
    private Station arrivalStation;
    
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date departureTime; 
    @ManyToMany(fetch=FetchType.EAGER)
    private List<Driver> drivers;
    
    private transient Boolean editable;

    public CityLine() {
        this.editable = false;
        this.city = new City();
        this.departureStation = new Station();
        this.interStations = new ArrayList<>();
        this.arrivalStation = new Station();
        this.drivers = new ArrayList<>();
    }
    
    public CityLine(CityLine cityLine){
        this.id = cityLine.id;
        this.lineNumber = cityLine.lineNumber;
        this.departureTime = cityLine.departureTime;
        this.city = cityLine.city;
    }
    

    public CityLine(City city, Integer lineNumber, Station departureStation, List<Station> interStations, Station arrivalStation, Date departureTime, List<Driver> drivers) {
        this.city = city;
        this.lineNumber = lineNumber;
        this.departureStation = departureStation;
        this.interStations = interStations;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.drivers = drivers;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public List<Station> getInterStations() {
        return interStations;
    }

    public void setInterStations(List<Station> interStations) {
        this.interStations = interStations;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }
    
}
