
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.RegisteredUser;
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
    
    private Reservation exampleReservation;
    private Reservation editReservation;
    private Reservation newReservation;
    private List<Reservation> reservations;
    private List<Reservation> allReservations;
    private List<Reservation> notApproved;
    
    private Service<Reservation> service;
    
    
    public ReservationService(){    
        this.service = new Service();
        
        this.exampleReservation = new Reservation();
        this.editReservation = new Reservation();
        this.newReservation = new Reservation();
        this.reservations = new ArrayList<>();
        this.allReservations = service.getAll("from Reservation");
        this.loadNotApproved();
    }

    public Reservation getExampleReservation() {
        return exampleReservation;
    }

    public void setExampleReservation(Reservation exampleReservation) {
        this.exampleReservation = exampleReservation;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
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
    
    public void setByExample(){
        this.reservations = service.getByExample(this.exampleReservation);
    }
    
    public final void loadNotApproved(){
        notApproved = new ArrayList<>();
        for(Reservation reservation: allReservations){
            if(!reservation.getApproved()){
                notApproved.add(reservation);
            }
        }
    }

    public List<Reservation> getNotApproved() {
        loadNotApproved();
        return notApproved;
    }

    public void setNotApproved(List<Reservation> notApproved) {
        this.notApproved = notApproved;
    }
    
    
    public void getByUser(RegisteredUser user){
        reservations = new ArrayList<>();
        for(Reservation reservation:allReservations){
            if(reservation.getUser().getUserName().equals(user.getUserName())){
                reservations.add(reservation);
            }
        }
    }
    
    public void approveAndUpdate(Reservation reservation){
        editReservation = reservation;
        editReservation.setApproved(true);
        update();
    }
    
}
