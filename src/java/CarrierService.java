
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
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
    
    private Carrier editCarrier;
    private Carrier newCarrier;
    private List<Carrier> allCarriers;
    
    private Service<Carrier> service;
    
    
    public CarrierService(){
        
        this.service = new Service<>();
        
        this.editCarrier = null;
        this.newCarrier = new Carrier();
        this.allCarriers = service.getAll("from Carrier");
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

    public List<Carrier> getAllCarriers() {
        return allCarriers;
    }

    public void setAllCarriers(List<Carrier> allCarriers) {
        this.allCarriers = allCarriers;
    }
    
    public void edit(Carrier carrier){
        if(this.editCarrier != null){
            this.editCarrier.setEditable(false);
        }
        this.editCarrier = carrier;
        this.editCarrier.setEditable(true);
    }
    
    public void update(Carrier carrier){
        this.editCarrier = carrier;
        this.service.update(this.editCarrier, this.allCarriers);
        this.editCarrier.setEditable(false);
        this.editCarrier = null;
    }

    public void delete(Carrier carrier){
        this.service.delete(carrier, this.allCarriers);
    }
    
    public void save(){
        this.service.save(this.newCarrier, this.allCarriers);
        this.newCarrier = new Carrier();
    }
    
}