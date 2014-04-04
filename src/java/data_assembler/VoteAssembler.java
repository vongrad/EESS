/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_assembler;

import dto.ElectiveFirstDTO;
import dto.ElectiveSecondDTO;
import dto.FirstVoteDTO;
import dto.SecondVoteDTO;
import entities.Elective;
import entities.FirstRoundVote;
import entities.SecondRoundVote;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author adamv_000
 */
public class VoteAssembler {

    public static FirstVoteDTO assembleFirstVote(FirstRoundVote firstRoundVote) {
        return new FirstVoteDTO(StudentAssembler.assembleStudent(firstRoundVote.getStudent()),
                ElectiveAssembler.assembleElectiveDTO(firstRoundVote.getFirstPriority1()),
                ElectiveAssembler.assembleElectiveDTO(firstRoundVote.getFirstPriority2()),
                ElectiveAssembler.assembleElectiveDTO(firstRoundVote.getSecondPriority1()),
                ElectiveAssembler.assembleElectiveDTO(firstRoundVote.getSecondPriority2()));
    }

    public static SecondVoteDTO assembleSecondVote(SecondRoundVote secondRoundVote) {
        return new SecondVoteDTO(ElectiveAssembler.assembleElectiveDTO(secondRoundVote.getFirstPriority1()),
                ElectiveAssembler.assembleElectiveDTO(secondRoundVote.getFirstPriority1()),
                ElectiveAssembler.assembleElectiveDTO(secondRoundVote.getSecondPriority1()),
                ElectiveAssembler.assembleElectiveDTO(secondRoundVote.getSecondPriority2()),
                StudentAssembler.assembleStudent(secondRoundVote.getStudent()));
    }

    public static Collection<FirstVoteDTO> assembleFirstVote(Collection<FirstRoundVote> electives) {
        Collection<FirstVoteDTO> firstVoteDTO = new ArrayList<>();

        for (FirstRoundVote firstRoundVote : electives) {
            firstVoteDTO.add(assembleFirstVote(firstRoundVote));
        }
        return firstVoteDTO;
    }

    public static Collection<SecondVoteDTO> assembleSecondVote(Collection<SecondRoundVote> electives) {
        Collection<SecondVoteDTO> secondVoteDTO = new ArrayList<>();

        for (SecondRoundVote secondRoundVote : electives) {
            secondVoteDTO.add(assembleSecondVote(secondRoundVote));
        }
        return secondVoteDTO;
    }
}
