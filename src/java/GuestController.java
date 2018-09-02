
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.City;
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
        this.lines = this.allLines;
        this.mostRecentLines = new ArrayList<>();
    }
    
    public List<IntercityLine> getMostRecentLines(){
        Date currDate = new Date();
        mostRecentLines = new ArrayList<>();
        for(IntercityLine l:this.allLines){
            Date lineDate = l.getDepartureDateAndTime();
            if(lineDate.after(currDate)){
                mostRecentLines.add(l);
            }
        }
        return mostRecentLines;
    }
    
    public void setMostRecentLines(List<IntercityLine> mostRecentLines) {
        this.mostRecentLines = mostRecentLines;
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
    
    public void byCarrier(){
        lines = new ArrayList<>();
        for(IntercityLine line:allLines){
            if(carrierName.equals(line.getCarrier().getName())){
                lines.add(line);
            }
        }
    }
 
    public void byDepartureDateAndTime(){
        lines = new ArrayList<>();
        for(IntercityLine line:allLines){
            Date lineDate = line.getDepartureDateAndTime();
            if(lineDate.after(departureTimeAndDateFrom) && lineDate.before(departureTimeAndDateTo)){
                lines.add(line);
            }
        }
    } 
    
    private List<String> getCityNames(IntercityLine line){
            List<String> cityNames = new ArrayList<>();
            String departureCityName = line.getDepartureCity().getName();
            cityNames.add(departureCityName);
            for(City city:line.getInterCities()){
                cityNames.add(city.getName());
            }
            String arrivalCityName = line.getArrivalCity().getName();
            cityNames.add(arrivalCityName);
            return cityNames;
    }
    
    public void byPlaceOfDepartureAndArrival(){
        
        this.lines = new ArrayList<>();
        for(IntercityLine line: allLines){
            List<String> cityNames = this.getCityNames(line);
            Integer departureIndex = cityNames.indexOf(this.departureCityName);
            Integer arrivalIndex = cityNames.lastIndexOf(this.arrivalCityName);
            if (departureIndex>=0 && departureIndex<arrivalIndex) {
                this.lines.add(line);
            }
        }
        
    }
    
}
