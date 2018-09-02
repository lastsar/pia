
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.RegisteredUser;
import model.Ticket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */

public class TicketService {
    
    private Ticket exampleTicket;
    private Ticket editTicket;
    private Ticket newTicket;
    private List<Ticket> tickets;
    private List<Ticket> allTickets;
    private List<Ticket> notApproved;
    
    private Service<Ticket> service;
    
    
    public TicketService(){    
        this.service = new Service();
        
        this.exampleTicket = new Ticket();
        this.editTicket = new Ticket();
        this.newTicket = new Ticket();
        this.tickets = new ArrayList<>();
        this.allTickets = service.getAll("from Ticket");
    }

    public List<Ticket> getNotApproved() {
        loadNotApproved();
        return notApproved;
    }

    public void setNotApproved(List<Ticket> notApproved) {
        this.notApproved = notApproved;
    }

    
    
    public Ticket getExampleTicket() {
        return exampleTicket;
    }

    public void setExampleTicket(Ticket exampleTicket) {
        this.exampleTicket = exampleTicket;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Ticket getEditTicket() {
        return editTicket;
    }

    public void setEditTicket(Ticket editTicket) {
        this.editTicket = editTicket;
    }

    public Ticket getNewTicket() {
        return newTicket;
    }

    public void setNewTicket(Ticket newTicket) {
        this.newTicket = newTicket;
    }

    public List<Ticket> getAllTickets() {
        return allTickets;
    }

    public void setAllTickets(List<Ticket> allTickets) {
        this.allTickets = allTickets;
    }
    
    public void edit(Ticket ticket){
        this.editTicket.setEditable(false);
        this.editTicket = ticket;
        this.editTicket.setEditable(true);
    }
    
    public void update(){
        this.service.update(this.editTicket);
        this.editTicket.setEditable(false);
        this.editTicket = new Ticket();
    }

    public void delete(Ticket ticket){
        this.service.delete(ticket, this.allTickets);
    }
    
    public void save(){
        this.service.save(this.newTicket, this.allTickets);
        this.newTicket = new Ticket();
    }
    
    public void setByExample(){
        this.tickets = service.getByExample(this.exampleTicket);
    }
    
    public void loadNotApproved(){
        notApproved = new ArrayList<>();
        for(Ticket ticket: allTickets){
            if(!ticket.getApproved()){
                notApproved.add(ticket);
            }
        }
    }
    
    public void setByUser(RegisteredUser user){
        tickets = new ArrayList<>();
        for(Ticket ticket: allTickets){
            if(ticket.getUser().getUserName().equals(user.getUserName())){
                tickets.add(ticket);
            }
        }
    }
    
    public void approveAndUpdate(Ticket ticket){
        editTicket = ticket;
        editTicket.setApproved(true);
        update();
    }
    
}
