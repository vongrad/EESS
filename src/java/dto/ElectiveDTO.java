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

    private String title;
    private String description;
    private  Date date;
    public ElectiveDTO(String Title, String Details, Date year) {
        this.title = Title;
        this.description = Details;
        this.date=year;
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

    @Override
    public String toString() {
        return "ElectiveDTO{" + "title=" + title + ", description=" + description + ", date=" + date + '}';
    }
    
}
