/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lazar
 */
public class Station {
    
    protected enum Type{
        CITY, INTERCITY
    }
    
    private City city;
    private String name;
    private List<Line> lines;

    public Station(City city, String name) {
        this.city = city;
        this.name = name;
        this.lines = new ArrayList<>();
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
    
}
