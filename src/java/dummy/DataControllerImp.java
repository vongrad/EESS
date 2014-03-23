/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy;

import dto.ElectiveDTO;
import dto.ElectiveFirstDTO;
import dto.ElectiveSecondDTO;
import dto.FirstRoundDTO;
import dto.SecondRoundDTO;
import dto.StudentDTO;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author adamv_000
 */
public class DataControllerImp implements IDataController {

    private ArrayList<ElectiveDTO> proposedElectives;
    private ArrayList<ElectiveFirstDTO> firstRoundEle;
    private ArrayList<ElectiveSecondDTO> secondRoundEle;
    private ArrayList<FirstRoundDTO> firstRoundVote;
    private ArrayList<StudentDTO> students;
    private ArrayList<FirstRoundDTO> firstRound;
    private ArrayList<SecondRoundDTO> secondRound;

    public DataControllerImp() {
        this.firstRoundEle = new ArrayList<>();
        this.secondRoundEle = new ArrayList<>();
        this.students = new ArrayList<>();
        this.proposedElectives = new ArrayList<>();
        this.firstRoundVote = new ArrayList<>();
        this.firstRound = new ArrayList<>();
        this.secondRound = new ArrayList<>();
    }

    @Override
    public ArrayList<ElectiveFirstDTO> getFirstRound() {
        return firstRoundEle;
    }

    @Override
    public ArrayList<ElectiveSecondDTO> getSecondRound() {
        return secondRoundEle;
    }

    @Override
    public boolean setFirsttRndEle(ElectiveFirstDTO element) {
        return firstRoundEle.add(element);
    }

    @Override
    public boolean setSecondRndEle(ElectiveSecondDTO element) {
        return secondRoundEle.add(element);
    }

    @Override
    public ElectiveFirstDTO getFirstRndEle(int index) {
        return firstRoundEle.get(index);
    }

    @Override
    public ElectiveSecondDTO getSecondRndEle(int index) {
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
    public ElectiveFirstDTO getLastFirstRndEle() {
        if (!firstRoundEle.isEmpty()) {
            return firstRoundEle.get(getFirstRndSize() - 1);
        }
        return null;
    }

    @Override
    public ElectiveSecondDTO getLastSecondRndEle() {
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
    public Collection<StudentDTO> getStudents() {

        if (students.isEmpty()) {
            generateStudents();
        }
        return students;
    }

    private void generateStudents() {
        students = GenerateDummyData.generateStudents();
    }

    @Override
    public Collection<ElectiveDTO> getProposedElectives() {
       proposedElectives=GenerateDummyData.generateProposedEle();
        return proposedElectives;
    }

    @Override
    public Collection<FirstRoundDTO> getFirstRoundVote() {
        return firstRoundVote;
    }

    @Override
    public int getFirstRndVoteSize() {
        return firstRoundVote.size();
    }

    @Override
    public FirstRoundDTO getLastFirstRoundVote() {
        if (!firstRoundVote.isEmpty()) {
            return firstRoundVote.get(firstRoundVote.size() - 1);
        }
        return null;
    }

    public ArrayList<FirstRoundDTO> getFirstRoundList(ArrayList<StudentDTO> students, ArrayList<ElectiveDTO> electives) {
        if (firstRound.isEmpty()) {
            generateFirstRoundList(students, electives);
        }
        return firstRound;
    }

    private void generateFirstRoundList(ArrayList<StudentDTO> students, ArrayList<ElectiveDTO> electives) {
        firstRound = GenerateDummyData.generateFirstRoundList(students, electives);
    }

    @Override
    public void generateSecondRndVote() {
        secondRound = GenerateDummyData.generateSecondRoundVote();
    }

    @Override
    public SecondRoundDTO getSecondRndVote(int index) {
        return secondRound.get(index);
    }

    @Override
    public int getSecondRndVoteSize() {
        return secondRound.size();
    }

    @Override
    public SecondRoundDTO getLastSecondRoundVote() {
        if (!secondRound.isEmpty()) {
            return secondRound.get(secondRound.size() - 1);
        }
        return null;
    }

    @Override
    public boolean setSecondRndStudentChoice(SecondRoundDTO secondRound) {
        return this.secondRound.add(secondRound);
    }

}