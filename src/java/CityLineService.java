
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import model.CityLine;

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
    
    public void filterCityLines(){
        
        this.cityLines = this.cityLines.stream().filter((line) -> {
            Integer lineNumber = line.getLineNumber();
            Date departureTime = line.getDepartureTime();
            String departureStationName = line.getDepartureStation().getName();
            List<String> interstationNames = line.getInterStations().stream().map((s)->(s.getName())).collect(Collectors.toList());
            String arrivalStationName = line.getArrivalStation().getName();
            
            Integer fLineNumber = this.filter.getLineNumber();
            String fDepartureStationName = this.filter.getDepartureStationName();
            String fIntercityStationName = this.filter.getInterstationName();
            String fArrivalStationName = this.filter.getArrivalStationName();
            
            return      (fLineNumber==null || fLineNumber.equals(lineNumber))
                    &&  (fDepartureStationName==null || fDepartureStationName.equals(departureStationName))
                    &&  (fIntercityStationName==null || interstationNames.contains(fIntercityStationName))
                    &&  (fArrivalStationName==null || fArrivalStationName.equals(arrivalStationName));
        }).collect(Collectors.toList());
        
    }
    
}
