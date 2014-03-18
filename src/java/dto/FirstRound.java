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
public class FirstRound {

    private ElectiveFirst firstPriority1;
    private ElectiveFirst firstPriority2;
    private ElectiveFirst secondPriority1;
    private ElectiveFirst secondPriority2;
    private Student student;

    public FirstRound(Student student, ElectiveFirst firstPriority1, ElectiveFirst firstPriority2, ElectiveFirst secondPriority1, ElectiveFirst secondPriority2) {
        this.firstPriority1 = firstPriority1;
        this.firstPriority2 = firstPriority2;
        this.secondPriority1 = secondPriority1;
        this.secondPriority2 = secondPriority2;
        this.student = student;
    }

    public ElectiveFirst getFirstPriority1() {
        return firstPriority1;
    }

    public ElectiveFirst getFirstPriority2() {
        return firstPriority2;
    }

    public ElectiveFirst getSecondPriority1() {
        return secondPriority1;
    }

    public ElectiveFirst getSecondPriority2() {
        return secondPriority2;
    }

    public Student getStudent() {
        return student;
    }
}
