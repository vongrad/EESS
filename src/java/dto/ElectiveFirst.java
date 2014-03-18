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
public class ElectiveFirst extends Elective {

    private int countFirstpriority;
    private int countSecondPriority;

    public ElectiveFirst(String Title, String Details, Date year, int countFirstPriority, int countSecondPriority) {
        super(Title, Details, year);
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
