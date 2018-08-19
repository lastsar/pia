
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Driver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */

public class DriverService {
    
    private Driver exampleDriver;
    private Driver editDriver;
    private Driver newDriver;
    private List<Driver> drivers;
    private List<Driver> allDrivers;
    
    private Service<Driver> service;
    
    
    public DriverService(){
        
        this.service = new Service<>();
        
        this.exampleDriver = new Driver();
        this.editDriver = new Driver();
        this.newDriver = new Driver();
        this.drivers = new ArrayList<>();
        this.allDrivers = service.getAll("from Driver");
    }

    public Driver getExampleDriver() {
        return exampleDriver;
    }

    public void setExampleDriver(Driver exampleDriver) {
        this.exampleDriver = exampleDriver;
    }

    public Driver getEditDriver() {
        return editDriver;
    }

    public void setEditDriver(Driver editDriver) {
        this.editDriver = editDriver;
    }

    public Driver getNewDriver() {
        return newDriver;
    }

    public void setNewDriver(Driver newDriver) {
        this.newDriver = newDriver;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Driver> getAllDrivers() {
        return allDrivers;
    }

    public void setAllDrivers(List<Driver> allDrivers) {
        this.allDrivers = allDrivers;
    }
    
    public void edit(Driver driver){
        this.editDriver.setEditable(false);
        this.editDriver = driver;
        this.editDriver.setEditable(true);
    }
    
    public void update(){
        this.service.update(this.editDriver);
        this.editDriver.setEditable(false);
        this.editDriver = new Driver();
    }

    public void delete(Driver driver){
        this.service.delete(driver, this.allDrivers);
    }
    
    public void save(){
        this.service.save(this.newDriver, this.allDrivers);
        this.newDriver = new Driver();
    }
    
    public void setByExample(){
        this.drivers = service.getByExample(this.exampleDriver);
    }
    
}
