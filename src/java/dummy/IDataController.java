/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy;

import dto.ElectiveDTO;
import dto.ElectiveFirstDTO;
import dto.ElectiveSecondDTO;
import dto.FirstVoteDTO;
import dto.SecondVoteDTO;
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

    public Collection<FirstVoteDTO> getFirstRoundVote();

    public boolean setFirsttRndEle(ElectiveFirstDTO element);

    public boolean setSecondRndStudentChoice(SecondVoteDTO secondRound);

    public boolean setSecondRndEle(ElectiveSecondDTO element);

    public ElectiveFirstDTO getFirstRndEle(int index);

    public ElectiveSecondDTO getSecondRndEle(int index);

    public SecondVoteDTO getSecondRndVote(int index);

    public int getFirstRndSize();

    public int getSecondRndSize();

    public int getFirstRndVoteSize();

    public int getSecondRndVoteSize();

    public ElectiveFirstDTO getLastFirstRndEle();

    public ElectiveSecondDTO getLastSecondRndEle();

    public FirstVoteDTO getLastFirstRoundVote();

    public SecondVoteDTO getLastSecondRoundVote();

    public void generateFirstRndEle();

    public void generateSecondRndEle();

    public void generateProposedEle();

    public void generateFirstRoundVote();

    public void generateSecondRndVote();

    public Collection<ElectiveDTO> getProposedElectives();

    public Collection<StudentDTO> getStudents();

    public ArrayList<FirstVoteDTO> getFirstRoundList(ArrayList<StudentDTO> students, ArrayList<ElectiveDTO> electives);
}
