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
public class CityStation extends Station {
    private final Type TYPE = Type.CITY;

    public CityStation(City city, String name) {
        super(city, name);
    }

    public Type getTYPE() {
        return TYPE;
    }
    
}
