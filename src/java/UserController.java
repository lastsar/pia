
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
    private UserReservationController reservationControlle;
    
    
    public UserController(){
        this.cityService = new CityService();
        this.registeredUserService = new RegisteredUserService();
        this.user = new RegisteredUser();
    }
    
    public String login(){
        RegisteredUser exampleUser = new RegisteredUser();
        exampleUser.setUserName(this.user.getUserName());
        exampleUser.setPassword(this.user.getPassword());
        registeredUserService.setExampleRegisteredUser(exampleUser);
        this.registeredUserService.setByExample();
        List<RegisteredUser> users = this.registeredUserService.getRegisteredUsers();
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
        this.registeredUserService.setExampleRegisteredUser(exampleUser);
        this.registeredUserService.setByExample();
        List<RegisteredUser> users = this.registeredUserService.getRegisteredUsers();
        if(!users.isEmpty()){
            return "Registration";
        }
        registeredUserService.setNewRegisteredUser(this.user);
        registeredUserService.save();
        //test to see if user id is same as saved objects id, if not you should retreive object from data base
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
        
        return "IntercityLines";
    }
    
    public String buyTicket(){
        
        this.ticketController = new UserTicketController(this.user);
        
        
        return "UserTickets";
        
    }
    
    public String showReservations(){
        this.reservationControlle = new UserReservationController(this.user);
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

    public UserReservationController getReservationControlle() {
        return reservationControlle;
    }

    public void setReservationControlle(UserReservationController reservationControlle) {
        this.reservationControlle = reservationControlle;
    }
    
    
}
