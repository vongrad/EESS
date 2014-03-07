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
public class Elective implements dummy.IElective {

    private String title;
    private String description;
    private Date year;

    public Elective(String Title, String Details, Date year) {
        this.title = Title;
        this.description = Details;
        this.year = year;
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

    @Override
    public void setTitle(String Title) {
        this.title = Title;
    }

    public Date getYear() {
        return year;
    }

    @Override
    public void setYear(Date year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
