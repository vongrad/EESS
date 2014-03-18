/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import dummy.IFirstRound;

/**
 *
 * @author Stefan
 */
public class FirstRound implements IFirstRound{
    private String firstPriority1,firstPriority2,secondPriority1,secondPriority2;

    public FirstRound(String firstPriority1, String firstPriority2, String secondPriority1, String secondPriority2) {
        this.firstPriority1 = firstPriority1;
        this.firstPriority2 = firstPriority2;
        this.secondPriority1 = secondPriority1;
        this.secondPriority2 = secondPriority2;
    }

    public String getFirstPriority1() {
        return firstPriority1;
    }

    public String getFirstPriority2() {
        return firstPriority2;
    }

    public String getSecondPriority1() {
        return secondPriority1;
    }

    public String getSecondPriority2() {
        return secondPriority2;
    }
    
    
}
