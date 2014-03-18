/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.Elective;
import dto.ElectiveSecond;
import dto.Student;
import dummy.DataControllerImp;
import dummy.IDataController;
import java.util.Collection;
import javax.ejb.Stateless;

/**
 *
 * @author adamv_000
 */
@Stateless
public class Manager implements ManagerLocal {

    private IDataController dataController;

    public Manager() {
        dataController = new DataControllerImp();
    }

    @Override
    public void addFirstRndEle(Elective elective) {
        dataController.setFirsttRndEle(elective);
    }

    @Override
    public void addSecondRndEle(ElectiveSecond elective) {
        dataController.setSecondRndEle(elective);
    }

    @Override
    public Collection<Elective> getFirstRound() {
        return dataController.getFirstRound();
    }

    @Override
    public Collection<ElectiveSecond> getSecondRound() {
        return dataController.getSecondRound();
    }

    @Override
    public Elective getFirstRndEle(int index) {
        return dataController.getFirstRndEle(index);
    }

    @Override
    public ElectiveSecond getSecondRndEle(int index) {
        return dataController.getSecondRndEle(index);
    }

    @Override
    public IDataController getDataController() {
        return dataController;
    }

    @Override
    public Collection<Student> getStudents() {
    return dataController.getStudents();
    }
}
