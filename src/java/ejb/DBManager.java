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
import dto.FirstVoteDTO;
import dto.SecondVoteDTO;
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

//    //Returns all the electives proposed by students and teachears!
//    @Override
//    public Collection<ElectiveDTO> getProposedElectives() {
//        ArrayList< ElectiveDTO> electiveDTOs = new ArrayList<>();
//        Query query = entityManager.createNamedQuery("Elective.findAll");
//        List<Elective> electives = query.getResultList();
//        for (Elective e : electives) {
//            if (e.getProposed().equals("0")) {
//                electiveDTOs.add(new ElectiveDTO(e.getElectiveId(), e.getTitle(), e.getDescription(), e.getCreationDate(), e.getProposed()));
//            }
//        }
//        return electiveDTOs;
//    }
    //Returns electives that has been approved by the head of program to go for the first round
    @Override
    public Collection<ElectiveFirstDTO> getFirstRndElectives() {

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
    public boolean addElective(ElectiveDTO e) {

        Elective el = new Elective(e.getElectiveID(), e.getTitle(), e.getDescription(), new Date(), e.getProposed());

        try {
            entityManager.persist(el);
        } catch (EntityExistsException ex) {
            ex.printStackTrace();
            return false;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return false;
        } catch (TransactionRequiredException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addSecondRndStudentChoice(SecondVoteDTO secondVote) {
        try {
            Elective e1, e2, e3, e4;

            e1 = findElectiveById(secondVote.getFirstPriority1().getElectiveID());
            e2 = findElectiveById(secondVote.getFirstPriority2().getElectiveID());
            e3 = findElectiveById(secondVote.getSecondPriority1().getElectiveID());
            e4 = findElectiveById(secondVote.getSecondPriority2().getElectiveID());

            Student st = findStudentById(secondVote.getStudent().getCpr());
            SecondRoundVote frv = new SecondRoundVote(st.getCpr(), st, e1, e2, e3, e4);

            entityManager.persist(frv);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addFirstRndStudentChoice(FirstVoteDTO firstVote) {
        try {
            Elective e1, e2, e3, e4;

            e1 = findElectiveById(firstVote.getFirstPriority1().getElectiveID());
            e2 = findElectiveById(firstVote.getFirstPriority2().getElectiveID());
            e3 = findElectiveById(firstVote.getSecondPriority1().getElectiveID());
            e4 = findElectiveById(firstVote.getSecondPriority2().getElectiveID());

            Student st = findStudentById(firstVote.getStudent().getCpr());
            FirstRoundVote frv = new FirstRoundVote(st.getCpr(), st, e1, e2, e3, e4);

            entityManager.persist(frv);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Elective findElectiveById(int electiveId) {
        return entityManager.find(Elective.class, electiveId);
    }

    public Student findStudentById(String CPR) {
        return entityManager.find(Student.class, CPR);
    }

    public void persist(Object object) {
        entityManager.persist(object);
    }

    @Override
    public Collection<SecondVoteDTO> getSecondRoundVote() {
        return VoteAssembler.assembleSecondVote(entityManager.createNamedQuery("SecondRoundVote.findAll").getResultList());
    }

    @Override
    public Collection<FirstVoteDTO> getFirstRoundVote() {
        return VoteAssembler.assembleFirstVote(entityManager.createNamedQuery("FirstRoundVote.findAll").getResultList());
    }

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

    //returns true if elective exists in the database
    @Override
    public boolean isElective(int id) {
        try {
            return entityManager.find(Elective.class, id) != null;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeElective(int electiveId) {

        try {
            Elective elective = entityManager.find(Elective.class, electiveId);

            if (elective != null) {
                entityManager.remove(elective);
                entityManager.flush();

                return true;
            }
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return false;
        } catch (TransactionRequiredException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public void restoreVoteTables() {
        Query query1 = entityManager.createQuery("DELETE * FROM FIRST_ROUND_VOTE");
        Query query2 = entityManager.createQuery("DELETE * FROM SECOND_ROUND_VOTE");
        
        query1.executeUpdate();
        query2.executeUpdate();
    }

}
