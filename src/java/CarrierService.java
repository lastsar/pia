
import java.util.ArrayList;
import java.util.List;
import model.Carrier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */

public class CarrierService {
    
    private Carrier exampleCarrier;
    private Carrier editCarrier;
    private Carrier newCarrier;
    private List<Carrier> carriers;
    private List<Carrier> allCarriers;
    
    private Service<Carrier> service;
    
    
    public CarrierService(){
        
        this.service = new Service<>();
        
        this.exampleCarrier = new Carrier();
        this.editCarrier = new Carrier();
        this.newCarrier = new Carrier();
        this.carriers = new ArrayList<>();
        this.allCarriers = service.getAll("from Carrier");
    }

    public Carrier getExampleCarrier() {
        return exampleCarrier;
    }

    public void setExampleCarrier(Carrier exampleCarrier) {
        this.exampleCarrier = exampleCarrier;
    }

    public Carrier getEditCarrier() {
        return editCarrier;
    }

    public void setEditCarrier(Carrier editCarrier) {
        this.editCarrier = editCarrier;
    }

    public Carrier getNewCarrier() {
        return newCarrier;
    }

    public void setNewCarrier(Carrier newCarrier) {
        this.newCarrier = newCarrier;
    }

    public List<Carrier> getCarriers() {
        return carriers;
    }

    public void setCarriers(List<Carrier> carriers) {
        this.carriers = carriers;
    }

    public List<Carrier> getAllCarriers() {
        return allCarriers;
    }

    public void setAllCarriers(List<Carrier> allCarriers) {
        this.allCarriers = allCarriers;
    }
    
    public void edit(Carrier carrier){
        this.editCarrier.setEditable(false);
        this.editCarrier = carrier;
        this.editCarrier.setEditable(true);
    }
    
    public void update(){
        this.service.update(this.editCarrier);
        this.editCarrier.setEditable(false);
        this.editCarrier = new Carrier();
    }

    public void delete(Carrier carrier){
        this.service.delete(carrier, this.allCarriers);
    }
    
    public void save(){
        this.service.save(this.newCarrier, this.allCarriers);
        this.newCarrier = new Carrier();
    }
    
    public void setByExample(){
        this.carriers = service.getByExample(this.exampleCarrier);
    }
    
}
