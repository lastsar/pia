
import java.util.ArrayList;
import java.util.List;
import model.TicketOffer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */

public class TicketOfferService {
    
    private TicketOffer exampleTicketOffer;
    private TicketOffer editTicketOffer;
    private TicketOffer newTicketOffer;
    private List<TicketOffer> ticketOffers;
    private List<TicketOffer> allTicketOffers;
    
    private Service<TicketOffer> service;
    
    
    public TicketOfferService(){    
        this.service = new Service();
        
        this.exampleTicketOffer = new TicketOffer();
        this.editTicketOffer = new TicketOffer();
        this.newTicketOffer = new TicketOffer();
        this.ticketOffers = new ArrayList<>();
        this.allTicketOffers = service.getAll("from TicketOffer");
    }

    public TicketOffer getExampleTicketOffer() {
        return exampleTicketOffer;
    }

    public void setExampleTicketOffer(TicketOffer exampleTicketOffer) {
        this.exampleTicketOffer = exampleTicketOffer;
    }

    
    public List<TicketOffer> getTicketOffers() {
        return ticketOffers;
    }

    public void setTicketOffers(List<TicketOffer> ticketOffers) {
        this.ticketOffers = ticketOffers;
    }

    public TicketOffer getEditTicketOffer() {
        return editTicketOffer;
    }

    public void setEditTicketOffer(TicketOffer editTicketOffer) {
        this.editTicketOffer = editTicketOffer;
    }

    public TicketOffer getNewTicketOffer() {
        return newTicketOffer;
    }

    public void setNewTicketOffer(TicketOffer newTicketOffer) {
        this.newTicketOffer = newTicketOffer;
    }

    public List<TicketOffer> getAllTicketOffers() {
        return allTicketOffers;
    }

    public void setAllTicketOffers(List<TicketOffer> allTicketOffers) {
        this.allTicketOffers = allTicketOffers;
    }
    
    public void edit(TicketOffer ticketOffer){
        this.editTicketOffer.setEditable(false);
        this.editTicketOffer = ticketOffer;
        this.editTicketOffer.setEditable(true);
    }
    
    public void update(){
        this.service.update(this.editTicketOffer);
        this.editTicketOffer.setEditable(false);
        this.editTicketOffer = new TicketOffer();
    }

    public void delete(TicketOffer ticketOffer){
        this.service.delete(ticketOffer, this.allTicketOffers);
    }
    
    public void save(){
        this.service.save(this.newTicketOffer, this.allTicketOffers);
        this.newTicketOffer = new TicketOffer();
    }
    
    public void setByExample(){
        this.ticketOffers = service.getByExample(this.exampleTicketOffer);
    }
}
