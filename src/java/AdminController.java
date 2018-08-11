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
    
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();


    private City city;
    private List<City> cities;
    private List<City> allCities;
    private Station station;
    private List<Station> stations;
    private List<Station> allStations;
    private Bus bus;
    private List<Bus> busses;
    private List<Bus> allBusses;
    private Carrier carrier;
    private List<Carrier> carriers;
    private List<Carrier> allCarriers;
    private Driver driver;
    private List<Driver> drivers;
    private List<Driver> allDrivers;
    private CityLine cityLine;
    private List<CityLine> cityLines;
    private List<CityLine> allCityLines;
    private IntercityLine intercityLine;
    private List<IntercityLine> intercityLines;
    private List<IntercityLine> allIntercityLines;
    
    public AdminController(){
        
        Session session = SESSION_FACTORY.openSession();
        
        
        String hql = null;
        Query query = null;
        
        hql = "from City";
        query = session.createQuery(hql);
        allCities = query.list();
        
        hql = "from Station";
        query = session.createQuery(hql);
        allStations = query.list();
        
        hql = "from Bus";
        query = session.createQuery(hql);
        allBusses= query.list();
        
        hql = "from Driver";
        query = session.createQuery(hql);
        allDrivers = query.list();
       
        hql = "from Carrier";
        query = session.createQuery(hql);
        allCarriers = query.list();
        
        hql = "from CityLine";
        query = session.createQuery(hql);
        allCityLines = query.list();
        
        hql = "from IntercityLines";
        query = session.createQuery(hql);
        allIntercityLines = query.list();
        
        
        session.close();
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    public void edit(City city){
        city.setEditable(true);
    }
    
    public void save(City city){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        session.update(city);
        session.getTransaction().commit();
        session.close();
        allCities.add(allCities.indexOf(city), city);
        city.setEditable(false);
    }
    
    public void cancelEdit(City city){
        city.setEditable(false);
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getAllCities() {
        return allCities;
    }

    public void setAllCities(List<City> allCities) {
        this.allCities = allCities;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Station> getAllStations() {
        return allStations;
    }

    public void setAllStations(List<Station> allStations) {
        this.allStations = allStations;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public List<Bus> getBusses() {
        return busses;
    }

    public void setBusses(List<Bus> busses) {
        this.busses = busses;
    }

    public List<Bus> getAllBusses() {
        return allBusses;
    }

    public void setAllBusses(List<Bus> allBusses) {
        this.allBusses = allBusses;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public List<Carrier> getCarriers() {
        return carriers;
    }

    public void setCarriers(List<Carrier> carriers) {
        this.carriers = carriers;
    }

    public List<Carrier> getAllCarriers() {
        return allCarriers;
    }

    public void setAllCarriers(List<Carrier> allCarriers) {
        this.allCarriers = allCarriers;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Driver> getAllDrivers() {
        return allDrivers;
    }

    public void setAllDrivers(List<Driver> allDrivers) {
        this.allDrivers = allDrivers;
    }

    public CityLine getCityLine() {
        return cityLine;
    }

    public void setCityLine(CityLine cityLine) {
        this.cityLine = cityLine;
    }

    public List<CityLine> getCityLines() {
        return cityLines;
    }

    public void setCityLines(List<CityLine> cityLines) {
        this.cityLines = cityLines;
    }

    public List<CityLine> getAllCityLines() {
        return allCityLines;
    }

    public void setAllCityLines(List<CityLine> allCityLines) {
        this.allCityLines = allCityLines;
    }

    public IntercityLine getIntercityLine() {
        return intercityLine;
    }

    public void setIntercityLine(IntercityLine intercityLine) {
        this.intercityLine = intercityLine;
    }

    public List<IntercityLine> getIntercityLines() {
        return intercityLines;
    }

    public void setIntercityLines(List<IntercityLine> intercityLines) {
        this.intercityLines = intercityLines;
    }

    public List<IntercityLine> getAllIntercityLines() {
        return allIntercityLines;
    }

    public void setAllIntercityLines(List<IntercityLine> allIntercityLines) {
        this.allIntercityLines = allIntercityLines;
    }

    
}
