package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dto.Elective;
import dto.FirstRound;
import dummy.IDataController;
import ejb.ManagerLocal;
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
        manager = lookupManagerLocal();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addFirstRndEle(){
        
//        Mockery context = new JUnit4Mockery();
        
 //       final IDataController electiveController = context.mock(IDataController.class);
        final IDataController electiveController = manager.getDataController();
        
        final Elective elective = new Elective("Game Development", "Here you learn how to develop the best game engines!", new Date(2014, 03, 07));
        
//        context.checking(new Expectations(){{
//            oneOf(electiveController).getFirstRndSize();
//            will(returnValue(0));
//        }});
        
        assertEquals(electiveController.getFirstRndSize(), 0);
        electiveController.setFirsttRndEle(elective);

//        context.checking(new Expectations(){{
//            oneOf(electiveController).setFirsttRndEle(elective);
//        }});
        
//        context.checking(new Expectations(){{
//            oneOf(electiveController).getFirstRndSize();
//            will(returnValue(1));
//        }});
        
        assertEquals(electiveController.getFirstRndSize(), 1);
 
//       context.checking(new Expectations(){{
//            oneOf(electiveController).getLastFirstRndEle();
//            will(returnValue(elective));
//        }}); 
        
        assertEquals(electiveController.getLastFirstRndEle(), elective);
    }
    
    @Test
    public void getElectives(int round){
        
        
    }

    @Test
    public void checkFristRoundVote(FirstRound fr)
    {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}


    private ManagerLocal lookupManagerLocal() {
        try {
            Context c = new InitialContext();
            return (ManagerLocal) c.lookup("java:global/EESS_BackEnd/Manager!ejb.ManagerLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
