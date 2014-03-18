package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.corba.se.spi.orb.DataCollector;
import dto.Elective;
import dto.ElectiveFirst;
import dto.ElectiveSecond;
import dto.FirstRound;
import dto.Student;
import dummy.IDataController;
import ejb.Manager;
import ejb.ManagerLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

    ManagerLocal manager;

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

        final ElectiveFirst elective = new ElectiveFirst("Game Development", "Here you learn how to develop the best game engines!", new Date(2014, 03, 07), 1, 5);

//        context.checking(new Expectations(){{
//            oneOf(dataController).getFirstRndSize();
//            will(returnValue(0));
//        }});
        assertEquals(dataController.getFirstRndSize(), 0);

//        context.checking(new Expectations(){{
//            oneOf(dataController).setFirsttRndEle(elective);
//            will(returnValue(true));
//        }});
        assertTrue(dataController.setFirsttRndEle(elective));

//        context.checking(new Expectations(){{
//            oneOf(dataController).getFirstRndSize();
//            will(returnValue(1));
//        }});
        assertEquals(dataController.getFirstRndSize(), 1);

//       context.checking(new Expectations(){{
//            oneOf(dataController).getLastFirstRndEle();
//            will(returnValue(elective));
//        }}); 
        assertEquals(dataController.getLastFirstRndEle(), elective);
    }

    @Test
    public void getFirstRoundEle() {

        Mockery context = new JUnit4Mockery();

        //final IDataController dataController = context.mock(IDataController.class);
        final IDataController dataController = manager.getDataController();
        final ElectiveFirst el8 = new ElectiveFirst("Modern Func languages", "Here you learn recursions etc..", new Date(), 2, 0);
        final ElectiveFirst el1 = new ElectiveFirst("C#", "Torban learning C#", new Date(), 1, 1);

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
        assertNotSame(el1, dataController.getLastFirstRndEle());

//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getLastFirstRndEle();
//                will(returnValue(el8));
//            }
//        });
        assertEquals(el8.getTitle(), dataController.getLastFirstRndEle().getTitle());
        assertEquals(el8.getDescription(), dataController.getLastFirstRndEle().getDescription());
        assertEquals(el8.getCountFirstpriority(), dataController.getLastFirstRndEle().getCountFirstpriority());
        assertEquals(el8.getCountSecondPriority(), dataController.getLastFirstRndEle().getCountSecondPriority());
    }

    @Test
    public void getFirstRoundVote() {

        Mockery context = new JUnit4Mockery();

        //final IDataController dataController = context.mock(IDataController.class);
        IDataController dataController = manager.getDataController();

        ElectiveFirst el1 = new ElectiveFirst("C#", "Torban learning C#", new Date(), 1, 1);
        ElectiveFirst el4 = new ElectiveFirst("SW Design", "Here you learn the beauty of code.", new Date(), 2, 1);
        ElectiveFirst el7 = new ElectiveFirst("Test drived development", "Tests first guys!", new Date(), 0, 2);
        ElectiveFirst el8 = new ElectiveFirst("Modern Func languages", "Here you learn recursions etc..", new Date(), 2, 0);

        Student s2 = new Student("Adolf", "Ray", "0123-456712");

        final FirstRound fr4 = new FirstRound(s2, el8, el4, el1, el7);

//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getFirstRoundVoteSize();
//                will(returnValue(0));
//            }
//        });
        assertEquals(0, dataController.getFirstRoundVoteSize());

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

        assertEquals(4, dataController.getFirstRoundVoteSize());

//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getLastFirstRoundVote();
//                will(returnValue(fr4));
//            }
//        });
        assertNotNull(dataController.getLastFirstRoundVote());

//        context.checking(new Expectations() {
//            {
//                oneOf(dataController).getLastFirstRoundVote();
//                will(returnValue(fr4));
//            }
//        });
        assertEquals(fr4.getStudent().getCpr(), dataController.getLastFirstRoundVote().getStudent().getCpr());
        assertEquals(fr4.getFirstPriority1().getTitle(), dataController.getLastFirstRoundVote().getFirstPriority1().getTitle());
        assertEquals(fr4.getSecondPriority2().getTitle(), dataController.getLastFirstRoundVote().getSecondPriority2().getTitle());
    }

    @Test
    public void addSecondRndEle() {

        Mockery context = new JUnit4Mockery();

        //final IDataController dataController = context.mock(IDataController.class);
        final IDataController dataController = manager.getDataController();
        final ElectiveSecond el5 = new ElectiveSecond("Python", "Here you learn the basics of Python.", new Date(), "B");

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
        assertEquals(dataController.setSecondRndEle(el5), true);

//        context.checking(new Expectations(){{
//            oneOf(dataController).getSecondRndSize();
//            will(returnValue(6));
//        }});
        assertEquals(dataController.getSecondRndSize(), 6);

//        context.checking(new Expectations(){{
//            oneOf(dataController).getLastSecondRndEle();
//            will(returnValue(el5));
//        }});
        assertEquals(el5.getPool(), dataController.getLastSecondRndEle().getPool());

    }

    public void checkStudentsList() {
        assertEquals(manager.getStudents().size() >= 1, true);
    }

    @Test
    public void testCheckStudent() {
        Student s1 = new Student("Jack O'Really", "Vasile", "092383-12232");
        Student s2 = new Student("Jaac1k O'Really", "Va,sile", "309823-1234");
        Student s3 = new Student("Jaack O'Really", "Vasile", "09823-1238");
        Student s4 = new Student("Jaack O'Really", "Vasile", "a09823-1678");
        Student s5 = new Student("Jaack O'Really", "Vasile", "09823-1234");
        checkInvalidStudent(s1);
        checkInvalidStudent(s2);
        checkInvalidStudent(s3);
        checkInvalidStudent(s4);
        checkInvalidStudent(s5);
        Collection<Student> students = manager.getStudents();
        for (Student s : students) {
            checkStudent(s);
        }
    }

    public void checkStudent(Student s) {
        String checkFirstName = "[A-Z][a-zA-Z']{1}[a-zA-Z, ]{0,30}";
        String checkLastName = "[A-Z][a-zA-Z']{1}[a-zA-Z, ]{0,15}";
        String checkCpr = "[0-9]{6}-[0-9]{4}";
        assertEquals(s.getFirstName().matches(checkFirstName), true);
        assertEquals(s.getLastName().matches(checkLastName), true);
        assertEquals(s.getCpr().matches(checkCpr), true);
    }

    public void checkInvalidStudent(Student s) {
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
        Collection<Student> studentss = manager.getStudents();
        Collection<ElectiveFirst> electives = manager.getFirstRound();
        Collection<FirstRound> firstRoundList = manager.getFirstRoundList();
        for (FirstRound frs : firstRoundList) {
            checkFirstVoteUnique(frs);
        }
    }

    public void checkFirstVoteUnique(FirstRound fr) {
        assertEquals(fr.getFirstPriority1() != fr.getFirstPriority2() && fr.getFirstPriority1() != fr.getSecondPriority1() && fr.getFirstPriority1() != fr.getSecondPriority2(), true);
        assertEquals((fr.getFirstPriority2() != fr.getSecondPriority1() && fr.getFirstPriority2() != fr.getSecondPriority2()), true);
        assertEquals((fr.getSecondPriority1() != fr.getSecondPriority2()), true);
    }

    public void checkStudent(FirstRound fr, Collection<Student> students) {
        boolean bol = false;
        String firstName = fr.getStudent().getFirstName();
        String lastName= fr.getStudent().getLastName();
        String cpr=fr.getStudent().getCpr();
        for (Student st : students) {
            if (st.getCpr().equals(cpr)&&st.getFirstName().equals(firstName)&&st.getLastName().equals(lastName)) {
                bol = true;
            }

        }
        assertEquals(bol, true);
    }
}
