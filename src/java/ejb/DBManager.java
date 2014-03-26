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
import entities.FirstRoundVote;
import entities.SecondRoundVote;
import entities.Student;
import java.util.ArrayList;
import java.util.Collection;
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
        Collection<ElectiveDTO> els = manager.getProposedElectives();
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

    @Override
    public Collection<ElectiveDTO> getProposedElectives() {
        ArrayList< ElectiveDTO> electiveDTOs = new ArrayList<>();
        Query query = entityManager.createNamedQuery("Elective.findAll");
        List<Elective> electives = query.getResultList();
        for (Elective e : electives) {
            if (e.getProposed() != null) {
                if (e.getProposed().equalsIgnoreCase("true")) {
                    electiveDTOs.add(new ElectiveDTO(e.getTitle(), e.getDiscription(), e.getCreationDate()));
                }
            }
        }
        return electiveDTOs;
    }

    @Override
    public Collection<ElectiveFirstDTO> getFirstElectives() {
        ArrayList< ElectiveFirstDTO> electiveDTOs = new ArrayList<>();
//        Query query = entityManager.createNamedQuery("Elective.findAll");
//        List<Elective> electives = query.getResultList();
//        int cfp;
//        int csp;
//        for (Elective e : electives) {
//            cfp= ((Number)entityManager.createNamedQuery("Elective.countFirstPriority").getSingleResult()).intValue();
//                    // e.setCountFirstPriority(countFirstPriority);
//                    //  electiveDTOs.add(new ElectiveFirstDTO(e.getTitle(), e.getDiscription(), e.getCreationDate()));
//        }
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

}
