/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import com.sun.corba.se.spi.orb.DataCollector;
import dto.Elective;
import dummy.IDataController;
import dummy.IElective;
import javax.ejb.Local;

/**
 *
 * @author adamv_000
 */
@Local
public interface ManagerLocal {
    public void addElective(Elective elective);
    public IDataController<IElective> getElectivesDataController();
    public IDataController<IElective> getElectivesController(int round);
}
