
import java.util.ArrayList;
import java.util.List;
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
    
    private CityLine editCityLine;
    private CityLine newCityLine;
    private List<CityLine> allCityLines;
    
    private Service<CityLine> service;
    
    
    public CityLineService(){
        
        this.service = new Service<>();
        
        this.editCityLine = null;
        this.newCityLine = new CityLine();
        this.allCityLines = service.getAll("from CityLine");
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

    public List<CityLine> getAllCityLines() {
        return allCityLines;
    }

    public void setAllCityLines(List<CityLine> allCityLines) {
        this.allCityLines = allCityLines;
    }
    
    public void edit(CityLine cityLine){
        if(this.editCityLine != null){
            this.editCityLine.setEditable(false);
        }
        this.editCityLine = cityLine;
        this.editCityLine.setEditable(true);
    }
    
    public void update(CityLine cityLine){
        this.editCityLine.setLineNumber(cityLine.getLineNumber());
        this.editCityLine.setDepartureTime(cityLine.getDepartureTime());
        this.service.update(this.editCityLine, this.allCityLines);
        this.editCityLine.setEditable(false);
        this.editCityLine = null;
    }

    public void delete(CityLine cityLine){
        this.service.delete(cityLine, this.allCityLines);
    }
    
    public void save(){
        this.service.save(this.newCityLine, this.allCityLines);
        this.newCityLine = new CityLine();
    }
    
}
