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
public interface IDataController {

    public Collection<ElectiveFirstDTO> getFirstRound();

    public Collection<ElectiveSecondDTO> getSecondRound();

    public Collection<FirstRoundDTO> getFirstRoundVote();

    public boolean setFirsttRndEle(ElectiveFirstDTO element);

    public boolean setSecondRndStudentChoice(SecondRoundDTO secondRound);

    public boolean setSecondRndEle(ElectiveSecondDTO element);

    public ElectiveFirstDTO getFirstRndEle(int index);

    public ElectiveSecondDTO getSecondRndEle(int index);

    public SecondRoundDTO getSecondRndVote(int index);

    public int getFirstRndSize();

    public int getSecondRndSize();

    public int getFirstRndVoteSize();

    public int getSecondRndVoteSize();

    public ElectiveFirstDTO getLastFirstRndEle();

    public ElectiveSecondDTO getLastSecondRndEle();

    public FirstRoundDTO getLastFirstRoundVote();

    public SecondRoundDTO getLastSecondRoundVote();

    public void generateFirstRndEle();

    public void generateSecondRndEle();

    public void generateProposedEle();

    public void generateFirstRoundVote();

    public void generateSecondRndVote();

    public Collection<ElectiveDTO> getProposedElectives();

    public Collection<StudentDTO> getStudents();

    public ArrayList<FirstRoundDTO> getFirstRoundList(ArrayList<StudentDTO> students, ArrayList<ElectiveDTO> electives);
}
