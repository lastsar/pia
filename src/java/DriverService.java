
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
    
    private Driver editDriver;
    private Driver newDriver;
    private List<Driver> allDrivers;
    
    private Service<Driver> service;
    
    
    public DriverService(){
        
        this.service = new Service<>();
        
        this.editDriver = null;
        this.newDriver = new Driver();
        this.allDrivers = service.getAll("from Driver");
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

    public List<Driver> getAllDrivers() {
        return allDrivers;
    }

    public void setAllDrivers(List<Driver> allDrivers) {
        this.allDrivers = allDrivers;
    }
    
    public void edit(Driver driver){
        if(this.editDriver != null){
            this.editDriver.setEditable(false);
        }
        this.editDriver = driver;
        this.editDriver.setEditable(true);
    }
    
    public void update(Driver driver){
        this.editDriver = driver;
        this.service.update(this.editDriver, this.allDrivers);
        this.editDriver.setEditable(false);
        this.editDriver = null;
    }

    public void delete(Driver driver){
        this.service.delete(driver, this.allDrivers);
    }
    
    public void save(){
        this.service.save(this.newDriver, this.allDrivers);
        this.newDriver = new Driver();
    }
    
}
