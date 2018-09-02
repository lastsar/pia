
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import model.CityLine;
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

public class IntercityLineService {
    
    
    private FilterIntercityLine filter;
    
    private IntercityLine exampleIntercityLine;
    private IntercityLine editIntercityLine;
    private IntercityLine newIntercityLine;
    private List<IntercityLine> intercityLines;
    private List<IntercityLine> allIntercityLines;
    
    private Service<IntercityLine> service;
    
    
    public IntercityLineService(){
        this.filter = new FilterIntercityLine();
        
        
        this.service = new Service<>();
        
        this.exampleIntercityLine = new IntercityLine();
        this.editIntercityLine = new IntercityLine();
        this.newIntercityLine = new IntercityLine();
        this.intercityLines = new ArrayList<>();
        this.allIntercityLines = service.getAll("from IntercityLine");
    }

    public FilterIntercityLine getFilter() {
        return filter;
    }

    public void setFilter(FilterIntercityLine filter) {
        this.filter = filter;
    }


    public IntercityLine getExampleIntercityLine() {
        return exampleIntercityLine;
    }

    public void setExampleIntercityLine(IntercityLine exampleIntercityLine) {
        this.exampleIntercityLine = exampleIntercityLine;
    }

    public List<IntercityLine> getIntercityLines() {
        return intercityLines;
    }

    public void setIntercityLines(List<IntercityLine> intercityLines) {
        this.intercityLines = intercityLines;
    }

    public IntercityLine getEditIntercityLine() {
        return editIntercityLine;
    }

    public void setEditIntercityLine(IntercityLine editIntercityLine) {
        this.editIntercityLine = editIntercityLine;
    }

    public IntercityLine getNewIntercityLine() {
        return newIntercityLine;
    }

    public void setNewIntercityLine(IntercityLine newIntercityLine) {
        this.newIntercityLine = newIntercityLine;
    }

    public List<IntercityLine> getAllIntercityLines() {
        return allIntercityLines;
    }

    public void setAllIntercityLines(List<IntercityLine> allIntercityLines) {
        this.allIntercityLines = allIntercityLines;
    }
    
    public void edit(IntercityLine intercityLine){
        this.editIntercityLine.setEditable(false);
        this.editIntercityLine = intercityLine;
        this.editIntercityLine.setEditable(true);
    }
    
    public void update(){
        this.service.update(this.editIntercityLine);
        this.editIntercityLine.setEditable(false);
        this.editIntercityLine = new IntercityLine();
    }

    public void delete(IntercityLine intercityLine){
        this.service.delete(intercityLine, this.allIntercityLines);
    }
    
    public void save(){
        this.service.save(this.newIntercityLine, this.allIntercityLines);
        this.newIntercityLine = new IntercityLine();
    }
    
    public void setByExample(){
        this.intercityLines = service.getByExample(this.exampleIntercityLine);
    }
    
    
    public void filterIntercityLines(){
                
        this.intercityLines = new ArrayList<>();
        
        for(IntercityLine line: this.allIntercityLines){
            
            String carrierName = line.getCarrier().getName();
            String departureCity = line.getDepartureCity().getName();
            List<String> intercityNames = line.getInterCities().stream().map((city)->(city.getName())).collect(Collectors.toList());
            String arrivalCityName = line.getArrivalCity().getName();
            Date deartureDateAndTime = line.getDepartureDateAndTime();
            Date arrivalDateAndTime = line.getArrivalDateAndTime();
            
            String fCarrierName = this.filter.getCarrierName();
            String fDepartureCityName = this.filter.getDepartureCityName();
            String fIntercityName = this.filter.getIntercityName();
            String fArrivalCityName = this.filter.getArrivalCityName();
            Date fDepartureDateAndTime = this.filter.getDepartureDateAndTime();
            Date fArrivalDateAndTime = this.filter.getArrivalDateAndTime();
            
            
            
            
            if(      (fCarrierName.equals("") || fCarrierName.equals(carrierName))
                    &&  (fDepartureCityName.equals("") || fDepartureCityName.equals(departureCity))
                    &&  (fIntercityName.equals("") || intercityNames.contains(fIntercityName))
                    &&  (fArrivalCityName.equals("") || fArrivalCityName.equals(arrivalCityName))
                    &&  (fDepartureDateAndTime==null || fDepartureDateAndTime.equals(deartureDateAndTime))
                    &&  (fArrivalDateAndTime==null || fArrivalDateAndTime.equals(arrivalDateAndTime))
            ){
                this.intercityLines.add(line);
            }
        }
    }
    
}
