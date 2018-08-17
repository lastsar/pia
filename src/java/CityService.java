
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.City;
import model.CityLine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */

public class CityService {
    
    private City editCity;
    private City newCity;
    private List<City> allCities;
    
    private Service<City> service;
    
    
    public CityService(){
        
        this.service = new Service<>();
        
        this.editCity = new City();
        this.newCity = new City();
        this.allCities = service.getAll("from City");
    }

    public City getEditCity() {
        return editCity;
    }

    public void setEditCity(City editCity) {
        this.editCity = editCity;
    }

    public City getNewCity() {
        return newCity;
    }

    public void setNewCity(City newCity) {
        this.newCity = newCity;
    }

    public List<City> getAllCities() {
        return allCities;
    }

    public void setAllCities(List<City> allCities) {
        this.allCities = allCities;
    }
    
    public void edit(City city){
        this.editCity.setEditable(false);
        this.editCity = city;
        this.editCity.setEditable(true);
    }
    
    public void update(){
        this.service.update(this.editCity);
        this.editCity.setEditable(false);
        this.editCity = new City();
    }

    public void delete(City city){
        this.service.delete(city, this.allCities);
    }
    
    public void save(){
        this.service.save(this.newCity, this.allCities);
        this.newCity = new City();
    }
    
    public List<City> getByExample(City example){
        return service.getByExample(example);
    }
    
}
