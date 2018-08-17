
import java.util.ArrayList;
import java.util.List;
import model.RegisteredUser;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.City;
import model.CityLine;
import model.IntercityLine;
import model.Reservation;
import model.Ticket;
import model.TicketOffer;
import org.hibernate.criterion.Example;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */

@ManagedBean(name="UserController")
@SessionScoped
public class UserController {
    
    private RegisteredUser user;
    
    private City city;
    private List<City> cities;
    private List<CityLine> cityLines;
    private List<IntercityLine> intercityLines;
    private List<Ticket> tickets;
    private List<TicketOffer> ticketOffers;
    private List<Reservation> reservations;
    
    private CityService cityService;
    private CityLineService cityLineService;
    private IntercityLineService intercityLineService;
    private TicketService ticketService;
    private TicketOfferService ticketOfferService;
    private ReservationService reservationService;
    private RegisteredUserService registeredUserService;
    
    
    
    public UserController(){
        
        this.cityService = new CityService();
        this.cityLineService = new CityLineService();
        this.intercityLineService = new IntercityLineService();
        this.ticketService = new TicketService();
        this.ticketOfferService = new TicketOfferService();
        this.reservationService = new ReservationService();
        
        this.registeredUserService = new RegisteredUserService();
        
        this.city = new City();
        this.cities = this.cityService.getAllCities();
        this.cityLines = new ArrayList<>();
        this.intercityLines = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.ticketOffers = new ArrayList<>();
        this.reservations = new ArrayList<>();
        
        this.user = new RegisteredUser();
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<TicketOffer> getTicketOffers() {
        return ticketOffers;
    }

    public void setTicketOffers(List<TicketOffer> ticketOffers) {
        this.ticketOffers = ticketOffers;
    }


    
    

    public List<CityLine> getCityLines() {
        return cityLines;
    }

    public void setCityLines(List<CityLine> cityLines) {
        this.cityLines = cityLines;
    }

    public List<IntercityLine> getIntercityLines() {
        return intercityLines;
    }

    public void setIntercityLines(List<IntercityLine> intercityLines) {
        this.intercityLines = intercityLines;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }
    
    public String login(){
        RegisteredUser exampleUser = new RegisteredUser();
        exampleUser.setUserName(this.user.getUserName());
        exampleUser.setPassword(this.user.getPassword());
        List<RegisteredUser> users = this.registeredUserService.getByExample(exampleUser);
        if(users.isEmpty()){
            this.user = new RegisteredUser();
            return "Login";
        }
        this.user = users.get(0);
        return "RegisteredUser";
        
    }
    
    
    
    public String register(){
        
        RegisteredUser exampleUser = new RegisteredUser();
        exampleUser.setUserName(this.user.getUserName());
        List<RegisteredUser> users = this.registeredUserService.getByExample(exampleUser);
        if(!users.isEmpty()){
            return "Registration";
        }
        registeredUserService.setNewRegisteredUser(this.user);
        registeredUserService.save();
        return "RegisteredUser";
    }
    
    public String logout(){
        this.user = new RegisteredUser();
        return "Guest";
    }
    
    public String searchCityLines(City city){
        this.city = city;
        CityLine exampleCityLine = new CityLine();
        exampleCityLine.setCity(this.city);
        this.cityLines = this.cityLineService.getByExample(exampleCityLine);
        return "UserCityLines";
    }
    
    public String searchIntercityLines(){
        this.intercityLines = this.intercityLineService.getAllIntercityLines();
        return "IntercityLines";
    }
    
    public String buyTicket(){
        
        Ticket exampleTicket = new Ticket();
        exampleTicket.setUser(this.user);
        this.tickets = this.ticketService.getByExample(exampleTicket);
        
        String category = this.user.getCategory();
        TicketOffer exampleTicketOffer = new TicketOffer();
        exampleTicketOffer.setStatus(category);
        this.ticketOffers = this.ticketOfferService.getByExample(exampleTicketOffer);
        
        return "UserTickets";
        
    }
    
    public String showReservations(){
        Reservation exampleReservation = new Reservation();
        exampleReservation.setUser(this.user);
        this.reservations = this.reservationService.getByExample(exampleReservation);
        return "UserReservations";
    }
}
