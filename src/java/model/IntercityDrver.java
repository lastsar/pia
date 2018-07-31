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
public class IntercityDrver extends Driver{
    
    private Carrier carrier;
    private Bus bus;

    public IntercityDrver(Carrier carrier, String firstName, String lastName, Date dateOfBirdth, Date driverLicenseIssueDate) {
        super(firstName, lastName, dateOfBirdth, driverLicenseIssueDate);
        this.carrier = carrier;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
    
    
    
}
