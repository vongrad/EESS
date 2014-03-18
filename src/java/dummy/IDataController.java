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
public interface IDataController {

    public Collection<ElectiveFirst> getFirstRound();

    public Collection<ElectiveSecond> getSecondRound();

    public Collection<FirstRound> getFirstRoundVote();

    public boolean setFirsttRndEle(ElectiveFirst element);

    public boolean setSecondRndEle(ElectiveSecond element);

    public ElectiveFirst getFirstRndEle(int index);

    public ElectiveSecond getSecondRndEle(int index);

    public int getFirstRndSize();

    public int getSecondRndSize();

    public int getFirstRoundVoteSize();

    public ElectiveFirst getLastFirstRndEle();

    public ElectiveSecond getLastSecondRndEle();

    public FirstRound getLastFirstRoundVote();

    public void generateFirstRndEle();

    public void generateSecondRndEle();

    public void generateProposedEle();

    public void generateFirstRoundVote();

    public Collection<Elective> getProposedElectives();

    public Collection<Student> getStudents();

    public ArrayList<FirstRound> getFirstRoundList(ArrayList<Student> students, ArrayList<ElectiveFirst> electives);

}
