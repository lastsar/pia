/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lazar
 */
public class IntercityLine extends Line{
    
    private Carrier carrier;
    private Date departureDateAndTime;//at particullar date and time and therefore there is one driver
    private Date arrivalDateAndTIme;
    private Bus bus;
    private Driver drivers;

    public IntercityLine(Carrier carrier, Station departureStation, List<Station> interstations, Station arrivalStation) {
        super(departureStation, interstations, arrivalStation);
        this.carrier = carrier;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Date getDepartureDateAndTime() {
        return departureDateAndTime;
    }

    public void setDepartureDateAndTime(Date departureDateAndTime) {
        this.departureDateAndTime = departureDateAndTime;
    }

    public Date getArrivalDateAndTIme() {
        return arrivalDateAndTIme;
    }

    public void setArrivalDateAndTIme(Date arrivalDateAndTIme) {
        this.arrivalDateAndTIme = arrivalDateAndTIme;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Driver getDrivers() {
        return drivers;
    }

    public void setDrivers(Driver drivers) {
        this.drivers = drivers;
    }
    
    

}
