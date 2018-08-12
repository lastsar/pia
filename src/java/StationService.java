
import java.util.ArrayList;
import java.util.List;
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
public class StationService {
    
    private Station editStation;
    private Station newStation;
    private List<Station> allStations;
    
    private Service<Station> service;
    
    public StationService(){
        
        service = new Service<>();
        
        this.editStation = null;
        this.newStation = new Station();
        this.allStations = service.getAll("from Station");
        
    }

    public Station getEditStation() {
        return editStation;
    }

    public void setEditStation(Station editStation) {
        this.editStation = editStation;
    }

    public Station getNewStation() {
        return newStation;
    }

    public void setNewStation(Station newStation) {
        this.newStation = newStation;
    }

    public List<Station> getAllStations() {
        return allStations;
    }

    public void setAllStations(List<Station> allStations) {
        this.allStations = allStations;
    }

    public void edit(Station station){
        if(this.editStation != null){
            this.editStation.setEditable(false);
        }
        this.editStation = station;
        this.editStation.setEditable(true);
    }
    
    public void update(Station station){
        this.editStation.setName(station.getName());
        this.service.update(this.editStation, this.allStations);
        this.editStation.setEditable(false);
        this.editStation = null;
    }

    public void delete(Station station){
        this.service.delete(station, this.allStations);
    }
    
    public void save(){
        this.service.save(this.newStation, this.allStations);
        this.newStation = new Station();
    }
    
    
    
}
