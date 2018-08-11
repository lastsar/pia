
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.City;
import model.CityLine;
import model.Driver;
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
@ManagedBean(name="AdminCityLineController")
@SessionScoped
public class AdminCityLineController {
    
    private SessionFactory sessionFactory = new SessionFactory();
    
    private CityLine cityLine;
    private List<CityLine> allCityLines;
    
    public AdminCityLineController(){
        this.cityLine = new CityLine();
        
        Session session = sessionFactory.getSession();
        
        String hql = "from CityLine";
        Query query = session.createQuery(hql);
        allCityLines = query.list();
        
        session.close();
    }

    public CityLine getCityLine() {
        return cityLine;
    }

    public void setCityLine(CityLine cityLine) {
        this.cityLine = cityLine;
    }

    public List<CityLine> getAllCityLines() {
        return allCityLines;
    }

    public void setAllCityLines(List<CityLine> allCityLines) {
        this.allCityLines = allCityLines;
    }

    public void edit(CityLine cityLine){
        this.cityLine = cityLine;
        cityLine.setEditable(true);
    }
    
    public void cancelEdit(CityLine cityLine){
        this.cityLine = new CityLine();
    }
    
    public void update(CityLine cityLine){
        this.cityLine.setLineNumber(cityLine.getLineNumber());
        this.cityLine.setDepartureTime(cityLine.getDepartureTime());
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.update(cityLine);
        session.getTransaction().commit();
        session.close();
        allCityLines.set(allCityLines.indexOf(cityLine), cityLine);
        cityLine.setEditable(false);
    }
    
    public void delete(CityLine cityLine){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.delete(cityLine);
        session.getTransaction().commit();
        session.close();
        allCityLines.remove(cityLine);
    }
    
    public void save(){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.save(cityLine);
        session.getTransaction().commit();
        session.close();
        allCityLines.add(cityLine);
    }
    
    public String addCity(City city){
        this.cityLine.setCity(city);
        return "AdminCityLines";
    }
    
    public String addDepartureStation(Station station){
        this.cityLine.setDepartureStation(station);
        return "AdminCityLines";
    }
    
    public String addInterStation(Station station){
        this.cityLine.getInterStations().add(station);
        return "AdminCityLines";
    }
    
    public String addArrivalStation(Station station){
        this.cityLine.setArrivalStation(station);
        return "AdminCityLines";
    }
    
    public String addDriver(Driver driver){
        this.cityLine.getDrivers().add(driver);
        return "AdminCityLines";
    }
    
}
