
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import model.Reservation;
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
public class UserReservationController {
    
    private RegisteredUser user;
    private ReservationService reservationService;

    public UserReservationController(RegisteredUser user) {
        this.user = user;
        this.reservationService = new ReservationService();
        
        reservationService.getByUser(user);
       
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }

    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void cancel(Reservation reservation){
        this.reservationService.delete(reservation);
        this.reservationService.getReservations().remove(reservation);
    }
    
}
