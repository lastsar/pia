
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Bus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */

public class BusService {
    
    private Bus exampleBus;
    private Bus editBus;
    private Bus newBus;
    private List<Bus> busses;
    private List<Bus> allBusses;
    
    private Service<Bus> service;
    
    
    public BusService(){
        
        this.service = new Service<>();
        
        this.exampleBus = new Bus();
        this.editBus = new Bus();
        this.newBus = new Bus();
        this.busses = new ArrayList();
        this.allBusses = service.getAll("from Bus");
    }

    public Bus getExampleBus() {
        return exampleBus;
    }

    public void setExampleBus(Bus exampleBus) {
        this.exampleBus = exampleBus;
    }

    public Bus getEditBus() {
        return editBus;
    }

    public void setEditBus(Bus editBus) {
        this.editBus = editBus;
    }

    public Bus getNewBus() {
        return newBus;
    }

    public void setNewBus(Bus newBus) {
        this.newBus = newBus;
    }

    public List<Bus> getBusses() {
        return busses;
    }

    public void setBusses(List<Bus> busses) {
        this.busses = busses;
    }

    public List<Bus> getAllBusses() {
        return allBusses;
    }

    public void setAllBusses(List<Bus> allBusses) {
        this.allBusses = allBusses;
    }
    
    public void edit(Bus bus){
        this.editBus.setEditable(false);
        this.editBus = bus;
        this.editBus.setEditable(true);
    }
    
    public void update(){
        this.service.update(this.editBus);
        this.editBus.setEditable(false);
        this.editBus = new Bus();
    }

    public void delete(Bus bus){
        this.service.delete(bus, this.allBusses);
    }
    
    public void save(){
        this.service.save(this.newBus, this.allBusses);
        this.newBus = new Bus();
    }
    
    public void setByExample(){
        this.busses = service.getByExample(this.exampleBus);
    }
    
}
