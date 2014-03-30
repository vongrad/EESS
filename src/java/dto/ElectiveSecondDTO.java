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
public class ElectiveSecondDTO extends ElectiveDTO {

    private String pool;

    public ElectiveSecondDTO(Integer electiveId, String Title, String Details, Date year, String proposed, String pool) {
     super(electiveId,Title, Details, year, proposed);
         this.pool = pool;
        
    }

    public String getPool() {
        return pool;
    }

}
