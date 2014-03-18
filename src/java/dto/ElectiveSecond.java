/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author adamv_000
 */
public class ElectiveSecond extends Elective {

    private String pool;

    public ElectiveSecond(String Title, String Details, Date year, String pool) {
        super(Title, Details, year);
        this.pool = pool;
    }
}
