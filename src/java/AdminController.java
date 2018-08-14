
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */
@ManagedBean(name="AdminController")
@SessionScoped
public class AdminController {
        
    private CityService cityService;
    private StationService stationService;
    private DriverService driverService;
    private CityLineService cityLineService;
    private BusService busService;
    private CarrierService carrierService;
    private IntercityLineService intercityLineService;
    private TicketOfferService ticketOfferService;
    

    public AdminController() {
        
        this.cityService = new CityService();
        this.stationService = new StationService();
        this.driverService = new DriverService();
        this.cityLineService = new CityLineService();
        this.busService = new BusService();
        this.carrierService = new CarrierService();
        this.intercityLineService = new IntercityLineService();
        this.ticketOfferService = new TicketOfferService();
    }
    

    public CityService getCityService() {
        return cityService;
    }

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    public StationService getStationService() {
        return stationService;
    }

    public void setStationService(StationService stationService) {
        this.stationService = stationService;
    }

    public DriverService getDriverService() {
        return driverService;
    }

    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    public CityLineService getCityLineService() {
        return cityLineService;
    }

    public void setCityLineService(CityLineService cityLineService) {
        this.cityLineService = cityLineService;
    }

    public BusService getBusService() {
        return busService;
    }

    public void setBusService(BusService busService) {
        this.busService = busService;
    }

    public CarrierService getCarrierService() {
        return carrierService;
    }

    public void setCarrierService(CarrierService carrierService) {
        this.carrierService = carrierService;
    }

    public IntercityLineService getIntercityLineService() {
        return intercityLineService;
    }

    public void setIntercityLineService(IntercityLineService intercityLineService) {
        this.intercityLineService = intercityLineService;
    }

    public TicketOfferService getTicketOfferService() {
        return ticketOfferService;
    }

    public void setTicketOfferService(TicketOfferService ticketOfferService) {
        this.ticketOfferService = ticketOfferService;
    }
    
    
}
