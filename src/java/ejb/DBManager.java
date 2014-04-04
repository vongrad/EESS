/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import data_assembler.ElectiveAssembler;
import data_assembler.VoteAssembler;
import dto.ElectiveDTO;
import dto.ElectiveFirstDTO;
import dto.ElectiveSecondDTO;
import dto.FirstRoundDTO;
import dto.SecondRoundDTO;
import dto.StudentDTO;
import dto.StudentElectiveDTO;
import dummy.IDataController;
import entities.Elective;
import entities.FirstRoundVote;
import entities.SecondRoundVote;
import entities.Student;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;

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

        for (ElectiveDTO s : els) {
            System.out.println(1);
            Elective el = new Elective(s.getTitle(), s.getDescription(), s.getDate(), "" + s.getProposed());

            entityManager.persist(el);
        }
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
            if (e.getProposed().equals("0")) {
                electiveDTOs.add(new ElectiveDTO(e.getElectiveId(), e.getTitle(), e.getDescription(), e.getCreationDate(), e.getProposed()));
            }
        }
        return electiveDTOs;
    }

    //Returns electives that has been approved by the head of program to go for the first round
    @Override
    public Collection<ElectiveFirstDTO> getFirstElectives() {

        ArrayList<ElectiveFirstDTO> electiveDTOs = new ArrayList<>();
        Query query = entityManager.createNamedQuery("Elective.findByProposed");
        Query q1, q2;
        query.setParameter("proposed", "1");
        List<Elective> electives = query.getResultList();

        int firstPriorityCount;
        int secondPriorityCount;

        for (Elective e : electives) {
            if (e.getPool() == null) {
                q1 = entityManager.createNamedQuery("FirstRoundVote.count_priority1");
                q1.setParameter("elective", e);
                firstPriorityCount = Integer.parseInt(q1.getSingleResult().toString());

                q2 = entityManager.createNamedQuery("FirstRoundVote.count_priority2");
                q2.setParameter("elective", e);
                secondPriorityCount = Integer.parseInt(q2.getSingleResult().toString());
                electiveDTOs.add(new ElectiveFirstDTO(e.getElectiveId(), e.getTitle(), e.getDescription(), e.getCreationDate(), e.getProposed(), firstPriorityCount, secondPriorityCount));
            }
        }
        return electiveDTOs;
    }

    @Override
    public void addFirstRndEle(ElectiveFirstDTO e) {
        Elective el = new Elective(e.getElectiveID(), e.getTitle(), e.getDescription(), e.getDate(), e.getProposed());
        entityManager.merge(el);
    }

    //INCREDIBLY terrible design
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

    //INCREDIBLY terrible design
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

    @Override
    public Collection<SecondRoundDTO> getSecondRoundVote() {
        return VoteAssembler.assembleElectiveSecond(entityManager.createNamedQuery("SecondRoundVote.findAll").getResultList());
    }

    //STEFAN!N!N!N!
    @Override
    public boolean setTaughtElectives(int[] electiveId) {

        //entityManager.getTransaction().begin();
        for (int i : electiveId) {
            Elective ele = entityManager.find(Elective.class, i);
            ele.setTaught((short) 1);
            try {
                entityManager.persist(ele);
            } catch (EntityExistsException e) {
                e.printStackTrace();
                return false;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return false;
            } catch (TransactionRequiredException e) {
                e.printStackTrace();
                return false;
            }
        }

//        try {
//            entityManager.getTransaction().commit();
//        } catch (RollbackException e) {
//            e.printStackTrace();
//            return false;
//        }
        return true;
    }

    @Override
    public boolean assignStudentElectives(Collection<StudentElectiveDTO> studentElective) {

        for (StudentElectiveDTO studentElectiveDTO : studentElective) {
            Student student = entityManager.find(Student.class, studentElectiveDTO.getCPR());
            Elective elective = entityManager.find(Elective.class, studentElectiveDTO.getElective_id());
            student.addElective(elective);
            elective.addStudent(student);
            entityManager.persist(elective);
            entityManager.persist(student);
        }

        return true;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public boolean isTaught(int electiveId) {

        try {
            Elective elective = entityManager.find(Elective.class, electiveId);
            return (elective != null && elective.getTaught() != null && elective.getTaught() == 1) ? true : false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean objectExistsInDb(Class c, Object id) {
        try {
            return entityManager.find(c, id) != null;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public boolean approveElective(int[] electiveIds) {
        try {
            for (int id : electiveIds) {
                Elective elective = entityManager.find(Elective.class, id);
                elective.setProposed("1");
                entityManager.persist(elective);
            }
        } catch (EntityExistsException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        } catch (TransactionRequiredException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public Collection<ElectiveDTO> getSuggestedElectives() {
        return ElectiveAssembler.assembleElectiveDTO(entityManager.createNamedQuery("Elective.findAll").getResultList());
    }

    @Override
    public boolean isApproved(int electiveId) {
        return entityManager.find(Elective.class, electiveId).getProposed().equals("1");
    }

    @Override
    public boolean isElective(int id) {
        try {
            return entityManager.find(Elective.class, id) != null;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
