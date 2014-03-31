/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author adamv_000
 */
public class StudentElectiveDTO implements Serializable{

    private int elective_id;
    private String CPR;

    public StudentElectiveDTO(int elective_id, String CPR) {
        this.elective_id = elective_id;
        this.CPR = CPR;
    }

    public int getElective_id() {
        return elective_id;
    }

    public void setElective_id(int elective_id) {
        this.elective_id = elective_id;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }
}
