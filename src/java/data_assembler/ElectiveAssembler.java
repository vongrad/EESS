/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_assembler;

import dto.ElectiveDTO;
import dto.ElectiveSecondDTO;
import entities.Elective;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author adamv_000
 */
public class ElectiveAssembler {

    public static ElectiveDTO assembleElectiveDTO(Elective e) {
        return new ElectiveDTO(e.getElectiveId(), e.getTitle(), e.getDescription(), e.getCreationDate(), e.getProposed());
    }

    public static Collection<ElectiveDTO> assembleElectiveDTO(Collection<Elective> es) {
        Collection<ElectiveDTO> electives = new ArrayList<>();

        for (Elective elective : es) {
            System.out.println("Id: " + elective.getElectiveId());
            electives.add(assembleElectiveDTO(elective));
        }
        return electives;
    }
}
