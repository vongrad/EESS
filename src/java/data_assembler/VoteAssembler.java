/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_assembler;

import dto.ElectiveSecondDTO;
import dto.SecondRoundDTO;
import entities.Elective;
import entities.SecondRoundVote;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author adamv_000
 */
public class VoteAssembler {

    public static ElectiveSecondDTO assembleEleSecond(Elective elective) {
        return new ElectiveSecondDTO(elective.getElectiveID(), elective.getTitle(), elective.getDescription(), elective.getCreationDate(), elective.getProposed(), elective.getPool());
    }

    public static Collection<SecondRoundDTO> assembleElectiveSecond(Collection<SecondRoundVote> electives) {
        Collection<SecondRoundDTO> secondRoundDTO = new ArrayList<>();

        for (SecondRoundVote secondRoundVote : electives) {
            secondRoundDTO.add(new SecondRoundDTO(assembleEleSecond(secondRoundVote.getFirstPriority1()),
                    assembleEleSecond(secondRoundVote.getFirstPriority2()), assembleEleSecond(secondRoundVote.getSecondPriority1()),
                    assembleEleSecond(secondRoundVote.getSecondPriority2()), StudentAssembler.assembleStudent(secondRoundVote.getStudent())));
        }
        return secondRoundDTO;
    }
}
