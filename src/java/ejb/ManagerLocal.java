/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import dto.Elective;
import dto.ElectiveSecond;
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
    public void addFirstRndEle(Elective elective);
    public void addSecondRndEle(ElectiveSecond elective);
    public Collection<Elective> getFirstRound();
    public Collection<ElectiveSecond> getSecondRound();
    public Elective getFirstRndEle(int index);
    public ElectiveSecond getSecondRndEle(int index);
    public IDataController getDataController();
    Collection<Student> getStudents();
}
