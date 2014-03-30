/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author adamv_000
 */
public class ElectiveDTO implements Serializable{
    private int electiveID;
    private String title;
    private String description;
    private Date date;
    private String proposed;

    public ElectiveDTO() {
    }
// for when Object is in the DB
    public ElectiveDTO(int electiveID, String title, String description, Date date, String proposed) {
        this.electiveID = electiveID;
        this.title = title;
        this.description = description;
        this.date = date;
        this.proposed = proposed;
    }
// for when Object is not in the DB
    public ElectiveDTO(String title, String description, Date date, String proposed) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.proposed = proposed;
    }

    public ElectiveDTO(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public int getElectiveId() {
        return electiveID;
    }
   

 
    public Date getDate() {
        return date;
    }

    public String getDetails() {
        return description;
    }
    public void setDetails(String Details) {
        this.description = Details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProposed() {
        return proposed;
    }

    @Override
    public String toString() {
        return "ElectiveDTO{" + "title=" + title + ", description=" + description + ", date=" + date + '}';
    }
    
}
