
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.City;
import model.Station;
import model.Station;
import org.hibernate.Query;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */
@ManagedBean(name="AdminStationController")
@SessionScoped
public class AdminStationController {
    
    private SessionFactory sessionFactory = new SessionFactory();
    
    private Station station;
    private List<Station> allStations;
    
    public AdminStationController(){
        this.station = new Station();
        
        Session session = sessionFactory.getSession();
        
        String hql = "from Station";
        Query query = session.createQuery(hql);
        allStations = query.list();
        
        session.close();
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<Station> getAllStations() {
        return allStations;
    }

    public void setAllStations(List<Station> allStations) {
        this.allStations = allStations;
    }

    public void edit(Station station){
        this.station = station;
        station.setEditable(true);
    }
    
    public void cancelEdit(Station station){
        this.station = new Station();
    }
    
    public void update(Station station){
        this.station.setName(station.getName());
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.update(this.station);
        session.getTransaction().commit();
        session.close();
        allStations.set(allStations.indexOf(station), station);
        station.setEditable(false);
    }
    
    public void delete(Station station){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.delete(station);
        session.getTransaction().commit();
        session.close();
        allStations.remove(station);
    }
    
    public void save(){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.save(station);
        session.getTransaction().commit();
        session.close();
        allStations.add(station);
    }
    
    public String addCity(City city){
        this.station.setCity(city);
        return "AdminStations";
    }
    
}
