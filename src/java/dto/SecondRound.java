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
public class SecondRound{

    private ElectiveSecond firstPriority1;
    private ElectiveSecond firstPriority2;
    private ElectiveSecond secondPriority1;
    private ElectiveSecond secondPriority2;
    private Student student;

    public SecondRound(ElectiveSecond firstPriority1, ElectiveSecond firstPriority2, ElectiveSecond secondPriority1, ElectiveSecond secondPriority2, Student student) {
        this.firstPriority1 = firstPriority1;
        this.firstPriority2 = firstPriority2;
        this.secondPriority1 = secondPriority1;
        this.secondPriority2 = secondPriority2;
        this.student = student;
    }

    public ElectiveSecond getFirstPriority1() {
        return firstPriority1;
    }

    public ElectiveSecond getFirstPriority2() {
        return firstPriority2;
    }

    public ElectiveSecond getSecondPriority1() {
        return secondPriority1;
    }

    public ElectiveSecond getSecondPriority2() {
        return secondPriority2;
    }

    public Student getStudent() {
        return student;
    }
}
