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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Lazar
 */
@Entity
public class IntercityLine implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Carrier carrier;
    @ManyToOne
    private City departureCity;
    @ManyToMany
    private List<City> interCities;
    @ManyToOne
    private City arrivalCity;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date departureDateAndTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date arrivalDateAndTime;
    @ManyToOne
    private Bus bus;
    @ManyToOne
    private Driver driver;
    
    private transient Boolean editable;

    public IntercityLine() {
        this.editable = false;
        this.carrier = new Carrier();
        this.departureCity = new City();
        this.interCities = new ArrayList<>();
        this.arrivalCity = new City();
        this.bus = new Bus();
        this.driver = new Driver();
    }

    public IntercityLine(Carrier carrier, City departureCity, List<City> interCities, City arrivalCity) {
        this.carrier = carrier;
        this.departureCity = departureCity;
        this.interCities = interCities;
        this.arrivalCity = arrivalCity;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    public List<City> getInterCities() {
        return interCities;
    }

    public void setInterCities(List<City> interCities) {
        this.interCities = interCities;
    }

    public City getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(City arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Date getDepartureDateAndTime() {
        return departureDateAndTime;
    }

    public void setDepartureDateAndTime(Date departureDateAndTime) {
        this.departureDateAndTime = departureDateAndTime;
    }

    public Date getArrivalDateAndTime() {
        return arrivalDateAndTime;
    }

    public void setArrivalDateAndTime(Date arrivalDateAndTime) {
        this.arrivalDateAndTime = arrivalDateAndTime;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }
    
}
