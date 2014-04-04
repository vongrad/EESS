package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.corba.se.spi.orb.DataCollector;
import dto.ElectiveDTO;
import dto.ElectiveFirstDTO;
import dto.ElectiveSecondDTO;
import dto.FirstRoundDTO;
import dto.SecondRoundDTO;
import dto.StudentDTO;
import dto.StudentElectiveDTO;
import dummy.IDataController;
import ejb.DBManager;
import ejb.DBManagerRemote;
import ejb.Manager;
import ejb.ManagerLocal;
import entities.Elective;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.jmock.Expectations;
import static org.jmock.Expectations.returnValue;
import org.jmock.Mockery;
import org.jmock.api.Expectation;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan
 */
public class TestManager {

    DBManagerRemote dbm = lookupDBManagerRemote();

    ManagerLocal manager;

    private DBManagerRemote lookupDBManagerRemote() {
        try {
            Context c = new InitialContext();
            return (DBManagerRemote) c.lookup("java:global/EESS_BackEnd/DBManager!ejb.DBManagerRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Test
    public void NR() {
        ///DBManager dbm = new DBManager();

    }

    public TestManager() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        manager = new Manager();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void addFirstRndEle() {

        Mockery context = new JUnit4Mockery();

        //final IDataController dataController = context.mock(IDataController.class);
        final IDataController dataController = manager.getDataController();

//        final ElectiveFirstDTO elective = new ElectiveFirstDTO("Game Development", "Here you learn how to develop the best game engines!", new Date(2014, 03, 07), 1, 5);
//        context.checking(new Expectations(){{
//            oneOf(dataController).getFirstRndSize();
//            will(returnValue(0));
//        }});
        assertEquals(dataController.getFirstRndSize(), 0);

//        context.checking(new Expectations(){{
//            oneOf(dataController).setFirsttRndEle(elective);
//            will(returnValue(true));
//        }});
//        assertTrue(dataController.setFirsttRndEle(elective));
//        context.checking(new Expectations(){{
//            oneOf(dataController).getFirstRndSize();
//            will(returnValue(1));
//        }});
        assertEquals(dataController.getFirstRndSize(), 1);

//       context.checking(new Expectations(){{
//            oneOf(dataController).getLastFirstRndEle();
//            will(returnValue(elective));
//        }}); 
//        assertEquals(dataController.getLastFirstRndEle(), elective);
    }

    @Test
    public void getFirstRoundEle() {

        Mockery context = new JUnit4Mockery();

        //final IDataController dataController = context.mock(IDataController.class);
        final IDataController dataController = manager.getDataController();
        //    final ElectiveFirstDTO el8 = new ElectiveFirstDTO("Modern Func languages", "Here you learn recursions etc..", new Date(), 2, 0);
        //   final ElectiveFirstDTO el1 = new ElectiveFirstDTO("C#", "Torban learning C#", new Date(), 1, 1);

//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getFirstRndSize();
//                will(returnValue(0));
//            }
//        });
        assertEquals(0, dataController.getFirstRndSize());

//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).generateFirstRndEle();
//            }
//        });
//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getFirstRndSize();
//                will(returnValue(8));
//            }
//        });
        dataController.generateFirstRndEle();

        assertEquals(8, dataController.getFirstRndSize());

//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getLastFirstRndEle();
//                will(returnValue(el8));
//            }
//        });
//        assertNotSame(el1, dataController.getLastFirstRndEle());
//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getLastFirstRndEle();
//                will(returnValue(el8));
//            }
//        });
        //   assertEquals(el8.getTitle(), dataController.getLastFirstRndEle().getTitle());
        //   assertEquals(el8.getDescription(), dataController.getLastFirstRndEle().getDescription());
        //   assertEquals(el8.getCountFirstpriority(), dataController.getLastFirstRndEle().getCountFirstpriority());
        //  assertEquals(el8.getCountSecondPriority(), dataController.getLastFirstRndEle().getCountSecondPriority());
    }

    @Test
    public void getFirstRoundVote() {

        Mockery context = new JUnit4Mockery();

        //final IDataController dataController = context.mock(IDataController.class);
        IDataController dataController = manager.getDataController();

//        ElectiveFirstDTO el1 = new ElectiveFirstDTO("C#", "Torban learning C#", new Date(), 1, 1);
        //  ElectiveFirstDTO el4 = new ElectiveFirstDTO("SW Design", "Here you learn the beauty of code.", new Date(), 2, 1);
        //  ElectiveFirstDTO el7 = new ElectiveFirstDTO("Test drived development", "Tests first guys!", new Date(), 0, 2);
        //  ElectiveFirstDTO el8 = new ElectiveFirstDTO("Modern Func languages", "Here you learn recursions etc..", new Date(), 2, 0);
        StudentDTO s2 = new StudentDTO("Adolf", "Ray", "0123-456712");

        // final FirstRoundDTO fr4 = new FirstRoundDTO(s2, el8, el4, el1, el7);
//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getFirstRoundVoteSize();
//                will(returnValue(0));
//            }
//        });
        assertEquals(0, dataController.getFirstRndVoteSize());

//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getLastFirstRoundVote();
//                will(returnValue(null));
//            }
//        });
        assertNull(dataController.getLastFirstRoundVote());

//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).generateFirstRoundVote();
//            }
//        });
//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getFirstRoundVoteSize();
//                will(returnValue(4));
//            }
//        });
        dataController.generateFirstRoundVote();

//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getLastFirstRoundVote();
//                will(returnValue(fr4));
//            }
//        });
//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getLastFirstRoundVote();
//                will(returnValue(fr4));
//            }
//        });
//        assertEquals(fr4.getStudent().getCpr(), dataController.getLastFirstRoundVote().getStudent().getCpr());
//        assertEquals(fr4.getFirstPriority1().getTitle(), dataController.getLastFirstRoundVote().getFirstPriority1().getTitle());
//        assertEquals(fr4.getSecondPriority2().getTitle(), dataController.getLastFirstRoundVote().getSecondPriority2().getTitle());
//   
    }

    @Test
    public void addSecondRndEle() {

        Mockery context = new JUnit4Mockery();

        //final IDataController dataController = context.mock(IDataController.class);
        final IDataController dataController = manager.getDataController();
//        final ElectiveSecondDTO el5 = new ElectiveSecondDTO("Python", "Here you learn the basics of Python.", new Date(), "B");

//        context.checking(new Expectations(){{
//            oneOf(dataController).getSecondRndSize();
//            will(returnValue(0));
//        }});
        assertEquals(dataController.getSecondRndSize(), 0);

//        context.checking(new Expectations(){{
//            oneOf(dataController).generateSecondRndEle();
//        }});
//        context.checking(new Expectations(){{
//            oneOf(dataController).getSecondRndSize();
//            will(returnValue(5));
//        }});
        dataController.generateSecondRndEle();

        assertEquals(dataController.getSecondRndSize(), 5);

//        context.checking(new Expectations(){{
//            oneOf(dataController).setSecondRndEle(el5);
//            will(returnValue(true));
//        }});
//        assertEquals(dataController.setSecondRndEle(el5), true);
//        context.checking(new Expectations(){{
//            oneOf(dataController).getSecondRndSize();
//            will(returnValue(6));
//        }});
        assertEquals(dataController.getSecondRndSize(), 6);

//        context.checking(new Expectations(){{
//            oneOf(dataController).getLastSecondRndEle();
//            will(returnValue(el5));
//        }});
        //    assertEquals(el5.getPool(), dataController.getLastSecondRndEle().getPool());
    }

    @Test
    public void getSecondRndEle() {
        Mockery context = new JUnit4Mockery();

        //final IDataController dataController = context.mock(IDataController.class);
        final IDataController dataController = manager.getDataController();

//        final ElectiveSecondDTO el5 = new ElectiveSecondDTO("Python", "Here you learn the basics of Python.", new Date(), "B");
//        final ElectiveSecondDTO el1 = new ElectiveSecondDTO("C#", "Torban learning C#", new Date(), "A");
//        context.checking(new Expectations(){{
//            oneOf(dataController).getSecondRndSize();
//            will(returnValue(0));
//        }});
        assertEquals(dataController.getSecondRndSize(), 0);

//        context.checking(new Expectations(){{
//            oneOf(dataController).getLastSecondRndEle();
//            will(returnValue(null));
//        }});
        assertNull(dataController.getLastSecondRndEle());

//        context.checking(new Expectations(){{
//            oneOf(dataController).generateSecondRndEle();
//        }});
        dataController.generateSecondRndEle();

//        context.checking(new Expectations(){{
//            oneOf(dataController).getSecondRndSize();
//            will(returnValue(5));
//        }});
        assertEquals(dataController.getSecondRndSize(), 5);

//        context.checking(new Expectations(){{
//            oneOf(dataController).getLastSecondRndEle();
//            will(returnValue(el5));
//        }});
//        assertEquals(dataController.getLastSecondRndEle().getTitle(), el5.getTitle());
//        context.checking(new Expectations(){{
//            oneOf(dataController).getLastSecondRndEle();
//            will(returnValue(el5));
//        }});
        //    assertEquals(dataController.getLastSecondRndEle().getDescription(), el5.getDescription());
//        context.checking(new Expectations(){{
//            oneOf(dataController).getLastSecondRndEle();
//            will(returnValue(el5));
//        }});
        //     assertEquals(dataController.getLastSecondRndEle().getPool(), el5.getPool());
//        context.checking(new Expectations(){{
//            oneOf(dataController).getLastSecondRndEle();
//            will(returnValue(el5));
//        }});
        //    assertNotSame(dataController.getLastSecondRndEle().getTitle(), el1.getTitle());
//        context.checking(new Expectations(){{
//            oneOf(dataController).getLastSecondRndEle();
//            will(returnValue(el5));
//        }});
//        
        //    assertNotSame(dataController.getLastSecondRndEle().getDetails(), el1.getDetails());
    }

    @Test
    public void addSecondRndStudentChoice() {

        Mockery context = new JUnit4Mockery();

////        //final IDataController dataController = context.mock(IDataController.class);
////        final IDataController dataController = manager.getDataController();
////
//////        final StudentDTO s3 = new StudentDTO("O'Really", "Jack", "0423-456789");
//////        final ElectiveSecondDTO el2 = new ElectiveSecondDTO("SW Design", "Here you learn the beauty of code.", new Date(), "A");
//////        final ElectiveSecondDTO el3 = new ElectiveSecondDTO("Android", "Here you learn how to develop mobile apps.", new Date(), "B");
//////        final ElectiveSecondDTO el4 = new ElectiveSecondDTO("Games", "Here you learn how to write/use basic game engines.", new Date(), "B");
//////        final ElectiveSecondDTO el5 = new ElectiveSecondDTO("Python", "Here you learn the basics of Python.", new Date(), "B");
////        //   final SecondRoundDTO fr1 = new SecondRoundDTO(el4, el2, el3, el5, s3);
//////        context.checking(new Expectations(){{
//////            oneOf(dataController).getSecondRndVoteSize();
//////            will(returnValue(0));
//////        }});
////        assertEquals(dataController.getSecondRndVoteSize(), 0);
////
//////        context.checking(new Expectations(){{
//////            oneOf(dataController).generateSecondRndVote();
//////        }});
////        dataController.generateFirstRoundVote();
//////        context.checking(new Expectations(){{
//////            oneOf(dataController).getSecondRndVoteSize();
//////            will(returnValue(2));
//////        }});
////
////        assertEquals(dataController.getSecondRndVoteSize(), 2);
////
//////        context.checking(new Expectations(){{
//////            oneOf(dataController).setSecondRndStudentChoice(fr1);
//////            will(returnValue(true));
//////        }});
//////        assertTrue(dataController.setSecondRndStudentChoice(fr1));
//////        context.checking(new Expectations(){{
//////            oneOf(dataController).getLastSecondRoundVote();
//////            will(returnValue(fr1));
//////        }});
////        //       assertEquals(dataController.getLastSecondRoundVote().getStudent().getCpr(), fr1.getStudent().getCpr());
//////        context.checking(new Expectations(){{
//////            oneOf(dataController).getLastSecondRoundVote();
//////            will(returnValue(fr1));
//////        }});
////        //   assertEquals(dataController.getLastSecondRoundVote().getFirstPriority1().getTitle(), fr1.getFirstPriority1().getTitle());
//////        context.checking(new Expectations(){{
//////            oneOf(dataController).getLastSecondRoundVote();
//////            will(returnValue(fr1));
//////        }});
////        ///    assertEquals(dataController.getLastSecondRoundVote().getFirstPriority2().getTitle(), fr1.getFirstPriority2().getTitle());
//////        context.checking(new Expectations(){{
//////            oneOf(dataController).getLastSecondRoundVote();
//////            will(returnValue(fr1));
//////        }});
////        //  assertEquals(dataController.getLastSecondRoundVote().getSecondPriority1().getTitle(), fr1.getSecondPriority1().getTitle());
//////        context.checking(new Expectations(){{
//////            oneOf(dataController).getLastSecondRoundVote();
//////            will(returnValue(fr1));
//////        }});
////        //   assertEquals(dataController.getLastSecondRoundVote().getSecondPriority2().getTitle(), fr1.getSecondPriority2().getTitle());
////        //   assertNotSame(dataController.getSecondRndVote(0).getStudent().getCpr(), dataController.getLastSecondRoundVote().getStudent().getCpr());
   }

    public void checkStudentsList() {
        assertEquals(manager.getStudents().size() >= 1, true);
    }

    @Test
    public void testCheckStudent() {
        StudentDTO s1 = new StudentDTO("Jack O'Really", "Vasile", "092383-12232");
        StudentDTO s2 = new StudentDTO("Jaac1k O'Really", "Va,sile", "309823-1234");
        StudentDTO s3 = new StudentDTO("Jaack O'Really", "Vasile", "09823-1238");
        StudentDTO s4 = new StudentDTO("Jaack O'Really", "Vasile", "a09823-1678");
        StudentDTO s5 = new StudentDTO("Jaack O'Really", "Vasile", "09823-1234");
        checkInvalidStudent(s1);
        checkInvalidStudent(s2);
        checkInvalidStudent(s3);
        checkInvalidStudent(s4);
        checkInvalidStudent(s5);
        Collection<StudentDTO> students = manager.getStudents();
        for (StudentDTO s : students) {
            checkStudent(s);
        }
    }

    public void checkStudent(StudentDTO s) {
        String checkFirstName = "[A-ZæåÅÆØø][a-zA-Z'æåÅÆØø]{1}[a-zA-Z, æåÅÆØø]{0,30}";
        String checkLastName = "[A-ZæåÅÆØø][a-zA-Z'æåÅÆØø]{1}[a-zA-Z, æåÅÆØø]{0,15}";
        String checkCpr = "[0-9]{6}-[0-9]{4}";
        assertEquals(s.getFirstName().matches(checkFirstName), true);
        assertEquals(s.getLastName().matches(checkLastName), true);
        assertEquals(s.getCpr().matches(checkCpr), true);
    }

    public void checkInvalidStudent(StudentDTO s) {
        String checkFirstName = "[A-Z][a-zA-Z']{1}[a-zA-Z, ]{0,30}";
        String checkLastName = "[A-Z][a-zA-Z']{1}[a-zA-Z, ]{0,15}";
        String checkCpr = "[0-9]{6}-[0-9]{4}";
        boolean check1 = s.getLastName().matches(checkLastName);
        boolean check2 = s.getCpr().matches(checkCpr);
        boolean check3 = s.getFirstName().matches(checkFirstName);
        assertEquals((check1 && check2 && check3), false);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void checkFirstRoundList() {
        Collection<StudentDTO> students = manager.getStudents();
        Collection<ElectiveDTO> electives = manager.getProposedElectives();
        Collection<FirstRoundDTO> firstRoundList = manager.getFirstRoundList();
        for (FirstRoundDTO frs : firstRoundList) {
            checkFirstVoteUnique(frs);
            checkStudent(frs.getStudent(), students);
        }
    }

    public void checkFirstVoteUnique(FirstRoundDTO fr) {
        assertEquals(fr.getFirstPriority1() != fr.getFirstPriority2() && fr.getFirstPriority1() != fr.getSecondPriority1() && fr.getFirstPriority1() != fr.getSecondPriority2(), true);
        assertEquals((fr.getFirstPriority2() != fr.getSecondPriority1() && fr.getFirstPriority2() != fr.getSecondPriority2()), true);
        assertEquals((fr.getSecondPriority1() != fr.getSecondPriority2()), true);
    }

    public void checkStudent(StudentDTO student, Collection<StudentDTO> students) {
        boolean bol = false;
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        String cpr = student.getCpr();
        for (StudentDTO st : students) {
            if (st.getCpr().equals(cpr) && st.getFirstName().equals(firstName) && st.getLastName().equals(lastName)) {
                bol = true;
            }

        }
        assertEquals(bol, true);
    }

    @Test
    public void testSecondRoundVote() {
        Collection<SecondRoundDTO> secondRound = dbm.getSecondRoundVote();
    }

    @Test
    public void updateTaught() {

        int[] electiveTaughtIds = new int[]{54, 55, 53};
        int[] electiveNotTaughtIds = new int[]{51, 52, 56, 57, 58};
        int electiveNotExistId = 40;

        //returns true if ALL Elective has been updated
        boolean result = dbm.setTaughtElectives(electiveTaughtIds);
        assertTrue(result);

        //
        for (int id : electiveTaughtIds) {
            //returns true if Elective exists in the Database
            assertTrue(dbm.objectExistsInDb(Elective.class, id));
            //returns true if Elective has "taught" attribute set to true
            assertTrue(dbm.isTaught(id));
        }

        for (int id : electiveNotTaughtIds) {
            assertTrue(dbm.objectExistsInDb(Elective.class, id));
            assertFalse(dbm.isTaught(id));
        }

        assertFalse(dbm.objectExistsInDb(Elective.class, electiveNotExistId));
        assertFalse(dbm.isTaught(electiveNotExistId));
    }

    @Test
    public void addStudentEle() {
        Collection<StudentElectiveDTO> studentEle = new ArrayList<>();
        studentEle.add(new StudentElectiveDTO(55, "764323-4519"));
        studentEle.add(new StudentElectiveDTO(54, "764323-4519"));
        boolean result = dbm.assignStudentElectives(studentEle);
        assertEquals(true, result);
    }

    @Test
    public void getSuggestedElectives() {

        ArrayList<ElectiveDTO> electives = (ArrayList<ElectiveDTO>) dbm.getSuggestedElectives();

        ElectiveDTO expectedFirst = new ElectiveDTO(55, "Games", "Here you learn how to write/use basic game engines.", "1");
        ElectiveDTO expectedLast = new ElectiveDTO(57, "Test drived development", "Tests first guys!", "1");

        assertEquals(8, electives.size());
        assertEquals(expectedFirst.getElectiveID(), electives.get(0).getElectiveID());
        assertEquals(expectedFirst.getTitle(), electives.get(0).getTitle());
        assertEquals(expectedFirst.getDescription(), electives.get(0).getDescription());

        assertEquals(expectedLast.getElectiveID(), electives.get(electives.size() - 1).getElectiveID());
        assertEquals(expectedLast.getTitle(), electives.get(electives.size() - 1).getTitle());
        assertEquals(expectedLast.getDescription(), electives.get(electives.size() - 1).getDescription());
    }

    @Test
    public void approveElective() {

        int[] electiveApprovedIds = new int[]{54, 55, 53};
        int[] electiveNotApprovedIds = new int[]{51, 52, 56, 57, 58};
        int electiveNotExistId = 40;

        assertTrue(dbm.approveElective(electiveApprovedIds));

        for (int id : electiveApprovedIds) {
            assertTrue(dbm.isElective(id));
            assertTrue(dbm.isApproved(id));
        }

        for (int id : electiveNotApprovedIds) {
            assertTrue(dbm.isElective(id));
            assertFalse(dbm.isApproved(id));

        }
        assertFalse(dbm.isElective(electiveNotExistId));
    }

}
