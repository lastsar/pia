/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lazar
 */

import java.util.List;

public class Line {
    
    private Station departureStation;
    private List<Station> interstations;
    private Station arrivalStation;

    public Line(Station departureStation, List<Station> interstations, Station arrivalStation) {
        this.departureStation = departureStation;
        this.interstations = interstations;
        this.arrivalStation = arrivalStation;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public List<Station> getInterstations() {
        return interstations;
    }

    public void setInterstations(List<Station> interstations) {
        this.interstations = interstations;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }
    
    
    
    
}
