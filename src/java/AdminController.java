import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Address;
import model.Bus;
import model.Carrier;
import model.City;
import model.CityLine;
import model.Driver;
import model.IntercityLine;
import model.Station;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
    

    public AdminController() {
        
        this.cityService = new CityService();
        this.stationService = new StationService();
        this.driverService = new DriverService();
        this.cityLineService = new CityLineService();
        this.busService = new BusService();
        this.carrierService = new CarrierService();
        this.intercityLineService = new IntercityLineService();
        
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
    
}
