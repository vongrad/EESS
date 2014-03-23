/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import dto.StudentDTO;
import entities.Students;
import java.util.Collection;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

/**
 *
 * @author Stefan
 */
@Stateless
public class DBManager implements DBManagerRemote {

     @PersistenceContext(unitName = "EESS_BackEndPU")
    private  EntityManager em;

   public void addStudents()
   {
      ManagerLocal manager= new Manager();
       Collection<StudentDTO> students = manager.getStudents();
        for (StudentDTO s : students) {
           Students st= new Students(s.getFirstName(),s.getLastName(),s.getCpr());

           em.persist(st);
        }
}
}
