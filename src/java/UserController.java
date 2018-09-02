
import java.util.List;
import model.RegisteredUser;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.City;
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
    private RegisteredUserService registeredUserService;
    private CityService cityService;
    
    private UserCityLineController cityLineController;
    private UserIntercityLineController intercityLineController;
    private UserTicketController ticketController;
    private UserReservationController reservationController;
    
    
    public UserController(){
        this.cityService = new CityService();
        this.registeredUserService = new RegisteredUserService();
        this.user = new RegisteredUser();
    }
    
    public String login(){
        String adminPass = "6CAF0FE57EA8E20FE70BA99A85C20A4E";
        if(adminPass.equals(user.getPassword())){
            return "AdminWelcome";
        }
        
        RegisteredUser user = this.registeredUserService.find(this.user.getUserName(), this.user.getPassword());
        if(user==null){
            this.user = new RegisteredUser();
            return "Login";
        }
        this.user = user;
        return "RegisteredUser";
        
    }
    
    
    
    public String register(){
        
        RegisteredUser user = this.registeredUserService.find(this.user.getUserName());
        if(user!=null){
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
        this.cityLineController = new UserCityLineController(this.user, city);
        
        return "UserCityLines";
    }
    
    public String searchIntercityLines(){
        this.intercityLineController = new UserIntercityLineController(this.user);
        
        return "UserIntercityLines";
    }
    
    public String buyTicket(){
        
        this.ticketController = new UserTicketController(this.user);
        
        return "UserTickets";
        
    }
    
    public String showReservations(){
        this.reservationController = new UserReservationController(this.user);
        return "UserReservations";
    }

    public UserTicketController getTicketController() {
        return ticketController;
    }

    public void setTicketController(UserTicketController ticketController) {
        this.ticketController = ticketController;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public CityService getCityService() {
        return cityService;
    }

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }
    
    public RegisteredUserService getRegisteredUserService() {
        return registeredUserService;
    }

    public void setRegisteredUserService(RegisteredUserService registeredUserService) {
        this.registeredUserService = registeredUserService;
    }

    public UserCityLineController getCityLineController() {
        return cityLineController;
    }

    public void setCityLineController(UserCityLineController cityLineController) {
        this.cityLineController = cityLineController;
    }

    public UserIntercityLineController getIntercityLineController() {
        return intercityLineController;
    }

    public void setIntercityLineController(UserIntercityLineController intercityLineController) {
        this.intercityLineController = intercityLineController;
    }

    public UserReservationController getReservationController() {
        return reservationController;
    }

    public void setReservationController(UserReservationController reservationController) {
        this.reservationController = reservationController;
    }
    
    
}
