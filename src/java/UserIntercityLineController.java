
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import model.IntercityLine;
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
public class UserIntercityLineController {
    
    private RegisteredUser user;
    private IntercityLineService intercityLineService;
    private ReservationService reservationService;

    public UserIntercityLineController(RegisteredUser user) {
        this.user = user;
        this.reservationService = new ReservationService();
        this.intercityLineService = new IntercityLineService();
        this.intercityLineService.setIntercityLines(this.intercityLineService.getAllIntercityLines());
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public IntercityLineService getIntercityLineService() {
        return intercityLineService;
    }

    public void setIntercityLineService(IntercityLineService intercityLineService) {
        this.intercityLineService = intercityLineService;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }

    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    
    
    public void reserve(IntercityLine line){
        Reservation reservation = this.reservationService.getNewReservation();
        reservation.setUser(this.user);
        reservation.setLine(line);
        reservationService.save();
    }
}
