
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import model.Ticket;
import model.RegisteredUser;
import model.Reservation;
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
public class UserTicketController {
    
    private RegisteredUser user;
    private TicketService ticketService;
    private TicketOfferService ticketOfferService;

    public UserTicketController(RegisteredUser user) {
        this.user = user;
        this.ticketService = new TicketService();
        this.ticketOfferService = new TicketOfferService();
        
        Ticket exampleTicket = new Ticket();
        exampleTicket.setUser(this.user);
        this.ticketService.setExampleTicket(exampleTicket);
        this.ticketService.setByExample();
        
        String category = this.user.getCategory();
        TicketOffer exampleTicketOffer = new TicketOffer();
        exampleTicketOffer.setStatus(category);
        this.ticketOfferService.setExampleTicketOffer(exampleTicketOffer);
        this.ticketOfferService.setByExample();
        
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public TicketService getTicketService() {
        return ticketService;
    }

    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketOfferService getTicketOfferService() {
        return ticketOfferService;
    }

    public void setTicketOfferService(TicketOfferService ticketOfferService) {
        this.ticketOfferService = ticketOfferService;
    }

    public void buy(TicketOffer ticketOffer){
        String category = ticketOffer.getStatus();
        String duration = ticketOffer.getDuration();
        Integer price = ticketOffer.getPrice();
        
        Ticket ticket = this.ticketService.getNewTicket();
        ticket.setUser(this.user);
        ticket.setCategory(category);
        ticket.setDuration(duration);
        ticket.setPrice(price);
        
        this.ticketService.save();
    }
}
