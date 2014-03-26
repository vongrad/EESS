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
public class ElectiveFirstDTO extends ElectiveDTO {

    private int countFirstpriority;
    private int countSecondPriority;

    public ElectiveFirstDTO(String Title, String Details, Date year, String proposed, int countFirstPriority, int countSecondPriority) {
        super(Title, Details, year, proposed);
        this.countFirstpriority = countFirstPriority;
        this.countSecondPriority = countSecondPriority;
    }

    public int getCountFirstpriority() {
        return countFirstpriority;
    }

    public int getCountSecondPriority() {
        return countSecondPriority;
    }
}
