/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lazar
 */
@Entity
public class TicketOffer implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String status;
    private String duration;
    private Integer price;
    private transient Boolean editable;
    
    public TicketOffer() {
        this.editable = false;
    }

    public TicketOffer(String status, String duration, Integer price) {
        this.status = status;
        this.duration = duration;
        this.price = price;
        this.editable = false;
    }
    
    

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
