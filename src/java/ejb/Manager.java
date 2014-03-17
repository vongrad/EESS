/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.Elective;
import dummy.DataControllerImp;
import dummy.IDataController;
import dummy.IElective;
import javax.ejb.Stateless;

/**
 *
 * @author adamv_000
 */
@Stateless
public class Manager implements ManagerLocal {

    private DataControllerImp<IElective> electivesController;
    private DataControllerImp<IElective> firstRoundElectivesController;
    private DataControllerImp<IElective> secondRoundElectivesController;

    public Manager() {
        electivesController = new DataControllerImp<>();
        firstRoundElectivesController = new DataControllerImp<>();
        secondRoundElectivesController = new DataControllerImp<>();
    }

    @Override
    public void addElective(Elective elective) {
        electivesController.setElement(elective);
    }

    @Override
    public IDataController<IElective> getElectivesDataController() {
        return electivesController;
    }

    @Override
    public IDataController<IElective> getElectivesController(int round) {
        switch(round){
            case 1:
                return firstRoundElectivesController;
            case 2:
                return secondRoundElectivesController;
            default:
                throw new IllegalArgumentException("There is no election round matching your criteria!");
        }
    }
    

}
