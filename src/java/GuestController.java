
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.IntercityLine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */
@ManagedBean(name="GuestController")
@SessionScoped
public class GuestController {
    
    private String carrierName;
    private Date departureTimeAndDateFrom;
    private Date departureTimeAndDateTo;
    private String departureCityName;
    private String arrivalCityName;
    
    private List<IntercityLine> allLines;
    private List<IntercityLine> lines;
    private List<IntercityLine> mostRecentLines;
    
    
    private IntercityLineService service;
    
    public GuestController(){
        this.service = new IntercityLineService();
        this.allLines = this.service.getAllIntercityLines();
        this.allLines.sort(Comparator.comparing(IntercityLine::getDepartureDateAndTime)); 
        this.lines = new ArrayList<>();
        this.mostRecentLines = this.allLines.subList(0, Math.min(10, this.allLines.size()));
    }
  

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public Date getDepartureTimeAndDateFrom() {
        return departureTimeAndDateFrom;
    }

    public void setDepartureTimeAndDateFrom(Date departureTimeAndDateFrom) {
        this.departureTimeAndDateFrom = departureTimeAndDateFrom;
    }

    public Date getDepartureTimeAndDateTo() {
        return departureTimeAndDateTo;
    }

    public void setDepartureTimeAndDateTo(Date departureTimeAndDateTo) {
        this.departureTimeAndDateTo = departureTimeAndDateTo;
    }

    public String getDepartureCityName() {
        return departureCityName;
    }

    public void setDepartureCityName(String departureCityName) {
        this.departureCityName = departureCityName;
    }

    public String getArrivalCityName() {
        return arrivalCityName;
    }

    public void setArrivalCityName(String arrivalCityName) {
        this.arrivalCityName = arrivalCityName;
    }

    public List<IntercityLine> getAllLines() {
        return allLines;
    }

    public void setAllLines(List<IntercityLine> allLines) {
        this.allLines = allLines;
    }

    public List<IntercityLine> getLines() {
        return lines;
    }

    public void setLines(List<IntercityLine> lines) {
        this.lines = lines;
    }

    public List<IntercityLine> getMostRecentLines() {
        return mostRecentLines;
    }

    public void setMostRecentLines(List<IntercityLine> mostRecentLines) {
        this.mostRecentLines = mostRecentLines;
    }
    
    
    public void byCarrier(){
        this.lines = this.allLines.stream()
                .filter(p -> p.getCarrier().getName().equals(this.carrierName))
                .collect(Collectors.toList());
    }
    
    public void byDepartureDateAndTime(){
        this.lines = this.allLines.stream()
                .filter(p -> (p.getDepartureDateAndTime().after(this.departureTimeAndDateFrom)) && p.getDepartureDateAndTime().before(this.departureTimeAndDateTo))
                .collect(Collectors.toList());
    } 
    
    private List<String> getCityNames(IntercityLine line){
            List<String> cityNames = new ArrayList<>();
            
            String departureCityName = line.getDepartureCity().getName();
            cityNames.add(departureCityName);
            
            line.getInterCities().forEach((city)->{
                cityNames.add(city.getName());
            });
            
            String arrivalCityName = line.getArrivalCity().getName();
            cityNames.add(arrivalCityName);
            
            return cityNames;
    }
    
    public void byPlaceOfDepartureAndArrival(){
        
        this.lines.clear();
        this.allLines.forEach((line) -> {
            List<String> cityNames = this.getCityNames(line);
            Integer departureIndex = cityNames.indexOf(this.departureCityName);
            Integer arrivalIndex = cityNames.lastIndexOf(this.arrivalCityName);
            if (departureIndex>=0 && departureIndex<arrivalIndex) {
                this.lines.add(line);
            }
        });
        
    }
    
}
