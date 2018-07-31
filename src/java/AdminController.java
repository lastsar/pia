
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Address;
import model.Bus;
import model.Carrier;
import model.City;
import model.CityDriver;
import model.CityLine;
import model.CityStation;
import model.Driver;
import model.IntercityDrver;
import model.IntercityLine;
import model.IntercityStation;
import model.Line;
import model.Station;
import service.AdminService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */
@ManagedBean
@SessionScoped
public class AdminController {
    
    private AdminService adminService = new AdminService();
    
    public void addCity(){
        String name="Uzice";
        City city = new City(name);
    }
    
    public List<City> getAllCities(){
        List<City> cities = new ArrayList<>();
        //cities = adminService.getAllCities();
        return cities;
    }
    
    public void addCityStation(){
        City city = new City("Uzice");//get from session.get("user").getCity();
        
        String stationName = "StationName";
        Station station = new CityStation(city, stationName);
    }
    
    public List<Station> getAllCityStations(){
        List<Station> stations = new ArrayList();
        
        //stations = adminService.getAllCityStatios();
        
        return stations;
        
    }
    
    public void addCityDriver(){
        
        Driver driver = null;
        
        try {
            City city = new City("Uzice");//get from session.get("user").getCity();
            
            String firstName = "firstName";
            String lastName = "lastName";
            String sDateOfBirdth = "31/12/1998";
            Date dateOfBirdth=new SimpleDateFormat("dd/MM/yyyy").parse(sDateOfBirdth);
            String sDriverLincenseIssueDate = "31/12/1998";
            Date driverLincenseIssueDate=new SimpleDateFormat("dd/MM/yyyy").parse(sDriverLincenseIssueDate);
            
            driver = new CityDriver(city, firstName, lastName, dateOfBirdth, driverLincenseIssueDate);
            
        } catch (ParseException ex) {//invalid input
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public List<Driver> getAllCityDrivers(){
        List<Driver> drivers = new ArrayList<>();
        //drivers = adminService.getAllCityDrivers();
        return drivers;
    }
    
    
    public void addCityLine(){
        
        Line line = null;
        
        try {
            City city = new City("Uzice");//get from session.get("user").getCity();
            
            Integer lineNumber = 1;
            
            Integer departureStationId = 1; //id from input
            Station departureStation = new Station(city, "station0");//adminService.getStation(departureStationId);
            
            
            List<Station> interstations = new ArrayList<>();//foreach id adminService.getStation(id);
            Station station1 = new CityStation(city, "station1");
            Station station2 = new CityStation(city, "station2");
            Station station3 = new CityStation(city, "station3");
            
            //adminService.getStation(id)
            Station arrivalStation = new CityStation(city, "station4");
            
            
            String sDepartureTime = "16:48";
            Date departureTime=new SimpleDateFormat("h:m").parse(sDepartureTime);
            
            List<Driver> drivers = new ArrayList<>();//foreach id adminService.getDriver(id)
            
            line = new CityLine(lineNumber, departureTime, drivers, departureStation, interstations, arrivalStation);
            
            
            //connect line to stations
            departureStation.getLines().add(line);
            for(Station station : interstations){
                station.getLines().add(line);
            }
            arrivalStation.getLines().add(line);
            
            //connect line to drivers;
            for(Driver driver : drivers){
                driver.getLines().add(line);
            }
            
        } catch (ParseException ex) {//invalid input
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addIntercityStation(){
        City city = new City("Uzice");//get from session.get("user").getCity();
        
        String stationName = "StationName";
        Station station = new IntercityStation(city, stationName);
    }
    
    public List<Station> getAllIntercityStations(){
        List<Station> stations = new ArrayList();
        
        //stations =  adminService.getAllIntercityStations();
        
        return stations;
    }
    
    public void addCarrier(){
        String name = "Lasta";
        Address address = new Address("a", "b", "c");
        String phoneNumber = "123456778";
        Carrier carrier = new Carrier(name, address, phoneNumber);
    }
    
    public List<Carrier> getAllCarriers(){
        List<Carrier> carriers = new ArrayList<>();
        //carreirs = adminService.getAllCarriers();
        return carriers;
    }
    
    public void addBus(){
        
        //carrier's id is sent as input via json file when adding IntercityDriver
        Carrier carrier = new Carrier("a", new Address("a", "b", "c"), "123");//adminService.getCarrier(id);
        String brand = "mercedez";
        String model = "m5";
        Integer numberOfSeats = 55;
        
        Bus bus = new Bus(carrier, brand, model, numberOfSeats);
        
        carrier.getBusses().add(bus);
    }
    
    public void addIntercityDriver(){
        
        Driver driver = null;
        
        try {
            //carrier's id is sent as input via json file when adding IntercityDriver
            Carrier carrier = new Carrier("a", new Address("a", "b", "c"), "123");//adminService.getCarrier(id);
            
            String firstName = "firstName";
            String lastName = "lastName";
            String sDateOfBirdth = "31/12/1998";
            Date dateOfBirdth=new SimpleDateFormat("dd/MM/yyyy").parse(sDateOfBirdth);
            String sDriverLincenseIssueDate = "31/12/1998";
            Date driverLincenseIssueDate=new SimpleDateFormat("dd/MM/yyyy").parse(sDriverLincenseIssueDate);
            
            driver = new IntercityDrver(carrier, firstName, lastName, dateOfBirdth, driverLincenseIssueDate);
            
            carrier.getDrivers().add(driver);
            
        } catch (ParseException ex) {//invalid input
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addIntercityLine(){
        
        //carrier's id is sent as input via json file when adding IntercityDriver
        Carrier carrier = new Carrier("a", new Address("a", "b", "c"), "123");//adminService.getCarrier(id);
        
        Station departureStation = new IntercityStation(new City("Uzice"), "a");//by id
        
        List<Station> interstations = new ArrayList<>();//foreach id adminService.getStation(id);
        Station station1 = new IntercityStation(new City("Uzice"), "station1");
        interstations.add(station1);
        Station station2 = new IntercityStation(new City("Uzice"), "station2");
        interstations.add(station2);
        Station station3 = new IntercityStation(new City("Uzice"), "station3");
        interstations.add(station3);
        
        Station arrivalStation = new IntercityStation(new City("Uzice"), "a");//by id
        
        Line line = new IntercityLine(carrier, departureStation, interstations, arrivalStation);
        
        
        carrier.getLines().add(line);
        
        //connect line to stations
        departureStation.getLines().add(line);
        for(Station station : interstations){
            station.getLines().add(line);
        }
        arrivalStation.getLines().add(line);
        
    }
    
    
    public void setDepartureDateAndTime(){
        Integer lineId = 1;// from input
        Date date = new Date();//from input
        
        //get line by id form adminService and set departure date and time
    }
    
    public void setArrivalDateAndTime(){
        Integer lineId = 1;// from input
        Date date = new Date();//from input
        
        //get line by id form adminService and set arrival date and time
    }
    
    public void setBus(){
        Integer lineId = 1;// from input
        Integer busId = 2;
        
        //get bus by id from adminService
        //get line by id form adminService and set bus to line
        //set line to bus.getLines().add(line)
    }
    
    public void setDriver(){
        Integer lineId = 1;// from input
        Integer driverId = 2;
        
        //get driver by id from adminService
        //get line by id form adminService and set driver to line
        //set line to driver.getLines().add(line)
    }
    
    
    
}
