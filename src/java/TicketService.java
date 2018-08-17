
import java.util.List;
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
    
    private Ticket editTicket;
    private Ticket newTicket;
    private List<Ticket> allTickets;
    
    private Service<Ticket> service;
    
    
    public TicketService(){    
        this.service = new Service();
        this.editTicket = new Ticket();
        this.newTicket = new Ticket();
        this.allTickets = service.getAll("from Ticket");
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
    
    public List<Ticket> getByExample(Ticket example){
        return service.getByExample(example);
    }
    
}
