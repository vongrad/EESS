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
import entities.Elective;
import entities.ElectiveSecond;
import entities.FirstRoundVote;
import entities.SecondRoundVote;
import entities.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Stefan
 */
@Stateless
public class DBManager implements DBManagerRemote {
    
    @PersistenceContext(unitName = "EESS_BackEndPU")
    private EntityManager entityManager;

    @Override
    public void addThings() {
        ManagerLocal manager = new Manager();
        // Collection<ElectiveDTO> els = manager.getProposedElectives();
        //  ElectiveSecond els = new ElectiveSecond("lala","sdasda",new Date(),"A");
//        for (ElectiveDTO e : els) {
//            
//           Elective el= new Elective(e.getTitle(),e.getDetails(),e.getDate());
//
//       // entityManager.persist(el);
//        }
    }

    @Override
    public Collection<StudentDTO> getStudents() {
        ArrayList< StudentDTO> studentDTOs = new ArrayList<>();
        Query query = entityManager.createNamedQuery("Student.findAll");
        List<Student> students = query.getResultList();
        for (Student s : students) {
            studentDTOs.add(new StudentDTO(s.getFirstName(), s.getLastName(), s.getCpr()));
        }
        return studentDTOs;
    }

    //Returns all the electives proposed by students and teachears!
    @Override
    public Collection<ElectiveDTO> getProposedElectives() {
        ArrayList< ElectiveDTO> electiveDTOs = new ArrayList<>();
        Query query = entityManager.createNamedQuery("Elective.findAll");
        List<Elective> electives = query.getResultList();
        for (Elective e : electives) {
            electiveDTOs.add(new ElectiveDTO(e.getTitle(), e.getDiscription(), e.getCreationDate()));
        }
        return electiveDTOs;
    }

    //Returns electives that has been approved by the head of program to go for the first round
    @Override
    public Collection<ElectiveFirstDTO> getFirstElectives() {

        ArrayList<ElectiveFirstDTO> electiveDTOs = new ArrayList<>();
        Query query = entityManager.createNamedQuery("Elective.findByProposed");
        query.setParameter("proposed", "1");
        List<Elective> electives = query.getResultList();
        
        int firstPriorityCount;
        int secondPriorityCount;

        for (Elective e : electives) {
            firstPriorityCount = (int) entityManager.createQuery("select FIRST_PRIORITY_1, FIRST_PRIORITY_2, count(*) from CPHSP12.FIRST_ROUND_VOTE WHERE FIRST_PRIORITY_1 = '" + e.getElectiveID() + "' AND FIRST_PRIORITY_2 = '" + e.getElectiveID() + "' GROUP BY FIRST_PRIORITY_1, FIRST_PRIORITY_2;").getSingleResult();
            secondPriorityCount = (int) entityManager.createQuery("select SECOND_PRIORITY_1, SECOND_PRIORITY_2, count(*) from CPHSP12.FIRST_ROUND_VOTE WHERE SECOND_PRIORITY_1 = '" + e.getElectiveID() + "' AND SECOND_PRIORITY_2 = '" + e.getElectiveID() + "' GROUP BY SECOND_PRIORITY_1, SECOND_PRIORITY_2;").getSingleResult();
            electiveDTOs.add(new ElectiveFirstDTO(e.getTitle(), e.getDiscription(), e.getCreationDate(), e.getProposed(), firstPriorityCount, secondPriorityCount));
        }
        
        for (ElectiveFirstDTO elective : electiveDTOs) {
            System.out.println("Title: " + elective.getTitle() + "FPC: " + elective.getCountFirstpriority() + "SPC: " + elective.getCountSecondPriority());
        }
        return electiveDTOs;
    }

    @Override
    public void addFirstRndEle(ElectiveFirstDTO e) {

    }

    @Override
    public boolean addSecondRndStudentChoice(SecondRoundDTO s) {
        try {
            Elective e1, e2, e3, e4;
            Query query = entityManager.createNamedQuery("Elective.findByTitle");
            query.setParameter("title", s.getFirstPriority1().getTitle());
            e1 = (Elective) query.getSingleResult();
            query.setParameter("title", s.getFirstPriority2().getTitle());
            e2 = (Elective) query.getSingleResult();
            query.setParameter("title", s.getSecondPriority1().getTitle());
            e3 = (Elective) query.getSingleResult();
            query.setParameter("title", s.getSecondPriority2().getTitle());
            e4 = (Elective) query.getSingleResult();
            query = entityManager.createNamedQuery("Student.findByCpr");
            query.setParameter("cpr", s.getStudent().getCpr());
            Student st = (Student) query.getSingleResult();
            SecondRoundVote frv = new SecondRoundVote(st.getCpr(), st, e1, e2, e3, e4);

            entityManager.persist(frv);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addFirstRndStudentChoice(FirstRoundDTO f) {
        try {
            Elective e1, e2, e3, e4;
            Query query = entityManager.createNamedQuery("Elective.findByTitle");
            query.setParameter("title", f.getFirstPriority1().getTitle());
            e1 = (Elective) query.getSingleResult();
            query.setParameter("title", f.getFirstPriority2().getTitle());
            e2 = (Elective) query.getSingleResult();
            query.setParameter("title", f.getSecondPriority1().getTitle());
            e3 = (Elective) query.getSingleResult();
            query.setParameter("title", f.getSecondPriority2().getTitle());
            e4 = (Elective) query.getSingleResult();
            query = entityManager.createNamedQuery("Student.findByCpr");
            query.setParameter("cpr", f.getStudent().getCpr());
            Student st = (Student) query.getSingleResult();
            FirstRoundVote frv = new FirstRoundVote(st.getCpr(), st, e1, e2, e3, e4);

            entityManager.persist(frv);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void persist(Object object) {
        entityManager.persist(object);
    }

}
