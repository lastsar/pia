
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
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
    
    private IntercityLine editIntercityLine;
    private IntercityLine newIntercityLine;
    private List<IntercityLine> allIntercityLines;
    
    private Service<IntercityLine> service;
    
    
    public IntercityLineService(){
        
        this.service = new Service<>();
        
        this.editIntercityLine = new IntercityLine();
        this.newIntercityLine = new IntercityLine();
        this.allIntercityLines = service.getAll("from IntercityLine");
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
    
    public List<IntercityLine> getByExample(IntercityLine example){
        return service.getByExample(example);
    }
    
}
