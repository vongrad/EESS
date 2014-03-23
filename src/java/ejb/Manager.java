package ejb;

import dto.ElectiveDTO;
import dto.ElectiveFirstDTO;
import dto.ElectiveSecondDTO;
import dto.FirstRoundDTO;
import dto.SecondRoundDTO;
import dto.StudentDTO;
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
    public void addFirstRndEle(ElectiveFirstDTO elective) {
        dataController.setFirsttRndEle(elective);
    }

    @Override
    public void addSecondRndEle(ElectiveSecondDTO elective) {
        dataController.setSecondRndEle(elective);
    }

    @Override
    public Collection<ElectiveFirstDTO> getFirstRound() {
        return dataController.getFirstRound();
    }

    @Override
    public Collection<ElectiveSecondDTO> getSecondRound() {
        return dataController.getSecondRound();
    }

    @Override
    public ElectiveFirstDTO getFirstRndEle(int index) {
        return dataController.getFirstRndEle(index);
    }

    @Override
    public ElectiveSecondDTO getSecondRndEle(int index) {
        return dataController.getSecondRndEle(index);
    }

    @Override
    public IDataController getDataController() {
        return dataController;
    }

    @Override
    public Collection<StudentDTO> getStudents() {
        return dataController.getStudents();
    }

    @Override
    public Collection<ElectiveDTO> getProposedElectives() {
        return dataController.getProposedElectives();
    }

    @Override
    public Collection<FirstRoundDTO> getFirstRoundList() {
        return dataController.getFirstRoundList((ArrayList<StudentDTO>) this.getStudents(), (ArrayList<ElectiveDTO>) this.getProposedElectives());
    }

    @Override
    public boolean addSecondRndStudentChoice(SecondRoundDTO secondRound) {
        return dataController.setSecondRndStudentChoice(secondRound);
    }
}