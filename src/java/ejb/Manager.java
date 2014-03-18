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
import dummy.DataControllerImp;
import dummy.IDataController;
import java.util.ArrayList;
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
    public void addFirstRndEle(ElectiveFirst elective) {
        dataController.setFirsttRndEle(elective);
    }

    @Override
    public void addSecondRndEle(ElectiveSecond elective) {
        dataController.setSecondRndEle(elective);
    }

    @Override
    public Collection<ElectiveFirst> getFirstRound() {
        return dataController.getFirstRound();
    }

    @Override
    public Collection<ElectiveSecond> getSecondRound() {
        return dataController.getSecondRound();
    }

    @Override
    public ElectiveFirst getFirstRndEle(int index) {
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

    @Override
    public Collection<Elective> getProposedElectives() {
        return dataController.getProposedElectives();
    }

    @Override
    public Collection<FirstRound> getFirstRoundList() {
        return dataController.getFirstRoundList((ArrayList<Student>)this.getStudents(),(ArrayList<ElectiveFirst>)this.getFirstRound());
    }
}
