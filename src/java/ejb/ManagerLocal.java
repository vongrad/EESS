/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.Elective;
import dto.ElectiveFirst;
import dto.ElectiveSecond;
import dto.FirstRound;
import dto.Student;
import dummy.IDataController;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author adamv_000
 */
@Local
public interface ManagerLocal {

    public void addFirstRndEle(ElectiveFirst elective);

    public void addSecondRndEle(ElectiveSecond elective);

    public Collection<ElectiveFirst> getFirstRound();

    public Collection<ElectiveSecond> getSecondRound();
    
    public Collection<Elective> getProposedElectives();
    
    public Collection<FirstRound> getFirstRoundList();

    public Collection<Student> getStudents();

    public ElectiveFirst getFirstRndEle(int index);

    public ElectiveSecond getSecondRndEle(int index);

    public IDataController getDataController();

}
