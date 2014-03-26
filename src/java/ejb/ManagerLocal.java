/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.ElectiveDTO;

import dto.ElectiveFirstDTO;

import dto.ElectiveSecondDTO;

import dto.FirstRoundDTO;

import dto.SecondRoundDTO;

import dto.StudentDTO;
import dummy.IDataController;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author adamv_000
 */
@Local
public interface ManagerLocal {

    public void addFirstRndEle(ElectiveFirstDTO elective);

    public void addSecondRndEle(ElectiveSecondDTO elective);
    //done
    public boolean addSecondRndStudentChoice(SecondRoundDTO secondRound);

    public Collection<ElectiveFirstDTO> getFirstRound();

    public Collection<ElectiveSecondDTO> getSecondRound();
//implemented in DB Manager
    public Collection<ElectiveDTO> getProposedElectives();

    public Collection<FirstRoundDTO> getFirstRoundList();
// implemented in DB Manager
    public Collection<StudentDTO> getStudents();

    public ElectiveFirstDTO getFirstRndEle(int index);

    public ElectiveSecondDTO getSecondRndEle(int index);

    public IDataController getDataController();

}
