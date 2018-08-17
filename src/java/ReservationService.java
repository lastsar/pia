
import java.util.List;
import model.Reservation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */

public class ReservationService {
    
    private Reservation editReservation;
    private Reservation newReservation;
    private List<Reservation> allReservations;
    
    private Service<Reservation> service;
    
    
    public ReservationService(){    
        this.service = new Service();
        this.editReservation = new Reservation();
        this.newReservation = new Reservation();
        this.allReservations = service.getAll("from Reservation");
    }

    public Reservation getEditReservation() {
        return editReservation;
    }

    public void setEditReservation(Reservation editReservation) {
        this.editReservation = editReservation;
    }

    public Reservation getNewReservation() {
        return newReservation;
    }

    public void setNewReservation(Reservation newReservation) {
        this.newReservation = newReservation;
    }

    public List<Reservation> getAllReservations() {
        return allReservations;
    }

    public void setAllReservations(List<Reservation> allReservations) {
        this.allReservations = allReservations;
    }
    
    public void edit(Reservation reservation){
        this.editReservation.setEditable(false);
        this.editReservation = reservation;
        this.editReservation.setEditable(true);
    }
    
    public void update(){
        this.service.update(this.editReservation);
        this.editReservation.setEditable(false);
        this.editReservation = new Reservation();
    }

    public void delete(Reservation reservation){
        this.service.delete(reservation, this.allReservations);
    }
    
    public void save(){
        this.service.save(this.newReservation, this.allReservations);
        this.newReservation = new Reservation();
    }
    
    public List<Reservation> getByExample(Reservation example){
        return service.getByExample(example);
    }
    
}
