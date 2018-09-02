
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.City;
import model.CityLine;
import model.Station;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */

public class CityLineService {
    
    private FilterCityLine filter;
    
    private CityLine exampleCityLine;
    private CityLine editCityLine;
    private CityLine newCityLine;
    private List<CityLine> cityLines;
    private List<CityLine> allCityLines;
    
    private Service<CityLine> service;
    
    
    public CityLineService(){
        
        this.service = new Service<>();
        
        this.exampleCityLine = new CityLine();
        this.editCityLine = new CityLine();
        this.newCityLine = new CityLine();
        this.cityLines = new ArrayList();
        this.allCityLines = service.getAll("from CityLine");
        this.filter = new FilterCityLine();
    }

    public FilterCityLine getFilter() {
        return filter;
    }

    public void setFilter(FilterCityLine filter) {
        this.filter = filter;
    }

    public CityLine getExampleCityLine() {
        return exampleCityLine;
    }

    public void setExampleCityLine(CityLine exampleCityLine) {
        this.exampleCityLine = exampleCityLine;
    }

    public CityLine getEditCityLine() {
        return editCityLine;
    }

    public void setEditCityLine(CityLine editCityLine) {
        this.editCityLine = editCityLine;
    }

    public CityLine getNewCityLine() {
        return newCityLine;
    }

    public void setNewCityLine(CityLine newCityLine) {
        this.newCityLine = newCityLine;
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
    
    public void edit(CityLine cityLine){
        this.editCityLine.setEditable(false);
        this.editCityLine = cityLine;
        this.editCityLine.setEditable(true);
    }
    
    public void update(){
        this.service.update(this.editCityLine);
        this.editCityLine.setEditable(false);
        this.editCityLine = new CityLine();
    }

    public void delete(CityLine cityLine){
        this.service.delete(cityLine, this.allCityLines);
    }
    
    public void save(){
        this.service.save(this.newCityLine, this.allCityLines);
        this.newCityLine = new CityLine();
    }
    
    public void setByExample(){
        this.cityLines = service.getByExample(this.exampleCityLine);
    }
    
    public void getByCity(City city){
        cityLines = new ArrayList<>();
        for(CityLine line:allCityLines){
            if(line.getCity().getName().equals(city.getName())){
                cityLines.add(line);
            }
        }
    }
    
    private Boolean containsInterstation(CityLine line, String interstationName){
        
        for(Station interstation: line.getInterStations()){
            if(interstationName.equals(interstation.getName())){
                return true;
            }
        }
        return false;
    }
    
    public void filterCityLines(){
        this.cityLines = new ArrayList<>();
        for(CityLine line:this.allCityLines){
            if(     (filter.getLineNumber()==null || filter.getLineNumber().equals(line.getLineNumber()) )
                    &&
                    (filter.getDepartureStationName().equals("") || filter.getDepartureStationName().equals(line.getDepartureStation().getName()) )
                    &&
                    (filter.getArrivalStationName().equals("") || filter.getArrivalStationName().equals(line.getArrivalStation().getName()) )
                    &&
                    (filter.getInterstationName().equals("") || containsInterstation(line, filter.getInterstationName()) )
                ){
                
                this.cityLines.add(line);
                
            }
        }
        
    }
    
}
