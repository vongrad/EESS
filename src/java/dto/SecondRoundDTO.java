/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

/**
 *
 * @author adamv_000
 */
public class SecondRoundDTO{

    private ElectiveSecondDTO firstPriority1;
    private ElectiveSecondDTO firstPriority2;
    private ElectiveSecondDTO secondPriority1;
    private ElectiveSecondDTO secondPriority2;
    private StudentDTO student;

    public SecondRoundDTO(ElectiveSecondDTO firstPriority1, ElectiveSecondDTO firstPriority2, ElectiveSecondDTO secondPriority1, ElectiveSecondDTO secondPriority2, StudentDTO student) {
        this.firstPriority1 = firstPriority1;
        this.firstPriority2 = firstPriority2;
        this.secondPriority1 = secondPriority1;
        this.secondPriority2 = secondPriority2;
        this.student = student;
    }

    public ElectiveSecondDTO getFirstPriority1() {
        return firstPriority1;
    }

    public ElectiveSecondDTO getFirstPriority2() {
        return firstPriority2;
    }

    public ElectiveSecondDTO getSecondPriority1() {
        return secondPriority1;
    }

    public ElectiveSecondDTO getSecondPriority2() {
        return secondPriority2;
    }

    public StudentDTO getStudent() {
        return student;
    }
}
