/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy;

import dto.Elective;
import dto.ElectiveFirst;
import dto.ElectiveSecond;
import dto.FirstRound;
import dto.Student;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author adamv_000
 */
public class DataControllerImp implements IDataController {

    private ArrayList<Elective> proposedElectives;
    private ArrayList<ElectiveFirst> firstRoundEle;
    private ArrayList<ElectiveSecond> secondRoundEle;
    private ArrayList<FirstRound> firstRoundVote;
    private ArrayList<Student> students;
    private ArrayList<FirstRound> firstRoundList;

    public DataControllerImp() {
        this.firstRoundEle = new ArrayList<>();
        this.secondRoundEle = new ArrayList<>();
        this.students = new ArrayList<>();
        this.proposedElectives = new ArrayList<>();
        this.firstRoundVote = new ArrayList<>();
        this.firstRoundList=new ArrayList<>();
    }
    @Override
    public ArrayList<ElectiveFirst> getFirstRound() {
        return firstRoundEle;
    }

    @Override
    public ArrayList<ElectiveSecond> getSecondRound() {
        return secondRoundEle;
    }

    @Override
    public boolean setFirsttRndEle(ElectiveFirst element) {
        return firstRoundEle.add(element);
    }

    @Override
    public boolean setSecondRndEle(ElectiveSecond element) {
        return secondRoundEle.add(element);
    }

    @Override
    public ElectiveFirst getFirstRndEle(int index) {
        return firstRoundEle.get(index);
    }

    @Override
    public ElectiveSecond getSecondRndEle(int index) {
        return secondRoundEle.get(index);
    }

    @Override
    public int getFirstRndSize() {
        return firstRoundEle.size();
    }

    @Override
    public int getSecondRndSize() {
        return secondRoundEle.size();
    }

    @Override
    public ElectiveFirst getLastFirstRndEle() {
        if (!firstRoundEle.isEmpty()) {
            return firstRoundEle.get(getFirstRndSize() - 1);
        }
        return null;
    }

    @Override
    public ElectiveSecond getLastSecondRndEle() {
        if (!secondRoundEle.isEmpty()) {
            return secondRoundEle.get(getSecondRndSize() - 1);
        }
        return null;
    }

    @Override
    public void generateFirstRndEle() {
        firstRoundEle = GenerateDummyData.generateFirstRndEle();
    }

    @Override
    public void generateSecondRndEle() {
        secondRoundEle = GenerateDummyData.generateSecondRndEle();
    }

    @Override
    public void generateProposedEle() {
        proposedElectives = GenerateDummyData.generateProposedEle();
    }

    @Override
    public void generateFirstRoundVote() {
        firstRoundVote = GenerateDummyData.generateFirstRoundVote();
    }

    @Override
    public Collection<Student> getStudents() {

        if (students.isEmpty()) {
            generateStudents();
        }
        return students;
    }

    private void generateStudents() {
        students = GenerateDummyData.generateStudents();
    }

    @Override
    public Collection<Elective> getProposedElectives() {
        return proposedElectives;
    }

    @Override
    public Collection<FirstRound> getFirstRoundVote() {
        return firstRoundVote;
    }

    @Override
    public int getFirstRoundVoteSize() {
        return firstRoundVote.size();
    }

    @Override
    public FirstRound getLastFirstRoundVote() {
        if (!firstRoundVote.isEmpty()) {
            return firstRoundVote.get(firstRoundVote.size() - 1);
        }
        return null;
    }
 public ArrayList<FirstRound> getFirstRoundList(ArrayList<Student> students, ArrayList<ElectiveFirst> electives){
     if(firstRoundList.isEmpty())
         generateFirstRoundList(students,electives);
     return firstRoundList;
 }
 private void generateFirstRoundList(ArrayList<Student> students, ArrayList<ElectiveFirst> electives){
     firstRoundList=GenerateDummyData.generateFirstRoundList(students, electives);
 }

}
