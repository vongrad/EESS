/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Stefan
 */
public class FirstRoundDTO {

    private ElectiveDTO firstPriority1;
    private ElectiveDTO firstPriority2;
    private ElectiveDTO secondPriority1;
    private ElectiveDTO secondPriority2;
    private StudentDTO student;

    public FirstRoundDTO(StudentDTO student,ElectiveDTO firstPriority1, ElectiveDTO firstPriority2, ElectiveDTO secondPriority1, ElectiveDTO secondPriority2) {
        this.firstPriority1 = firstPriority1;
        this.firstPriority2 = firstPriority2;
        this.secondPriority1 = secondPriority1;
        this.secondPriority2 = secondPriority2;
        this.student = student;
    }

    public ElectiveDTO getFirstPriority1() {
        return firstPriority1;
    }

    public ElectiveDTO getFirstPriority2() {
        return firstPriority2;
    }

    public ElectiveDTO getSecondPriority1() {
        return secondPriority1;
    }

    public ElectiveDTO getSecondPriority2() {
        return secondPriority2;
    }

  

    public StudentDTO getStudent() {
        return student;
    }
}
