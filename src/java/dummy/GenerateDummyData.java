/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dummy;

import dto.Elective;
import dto.ElectiveSecond;
import dto.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author adamv_000
 */
public class GenerateDummyData {
    public static ArrayList<Student> generateStudents(){
ArrayList<Student> students= new ArrayList<>();
Student s1= new Student("Jack","Black","0123-456789");
Student s2= new Student("Adolf","Ray","0123-456712");
Student s3= new Student("O'Really","Jack","0423-456789");
Student s4= new Student("Leo", "Nary","0123-456289");
Student s5= new Student("Jhon Aron", "Var","0123-456703");
Student s6= new Student("Lop", "Roy","0123-451239");
students.add(s1);
students.add(s2);
students.add(s3);
students.add(s4);
students.add(s5);
students.add(s6);
return students;
}
    public static ArrayList<Elective> generateFirstRndEle(){
        ArrayList<Elective> secondRound = new ArrayList<>();
        Elective el1 = new Elective("C#", "Torban learning C#", new Date());
        Elective el2 = new Elective("Python", "Here you learn the basics of Python.", new Date());
        Elective el3 = new Elective("Android", "Here you learn how to develop mobile apps.", new Date());
        Elective el4 = new Elective("SW Design", "Here you learn the beauty of code.", new Date());
        Elective el5 = new Elective("Games", "Here you learn how to write/use basic game engines.", new Date());
        Elective el6 = new Elective("Databases", "Here you learn how to persistently store bulks of data.", new Date());
        Elective el7 = new Elective("Test drived development", "Tests first guys!", new Date());
        Elective el8 = new Elective("Modern Func languages", "Here you learn recursions etc..", new Date());
        secondRound.add(el1);
        secondRound.add(el2);
        secondRound.add(el3);
        secondRound.add(el4);
        secondRound.add(el5);
        secondRound.add(el6);
        secondRound.add(el7);
        secondRound.add(el8);
        return secondRound;
    }
    
    public static ArrayList<ElectiveSecond> generateSecondRndEle(){
        ArrayList<ElectiveSecond> secondRound = new ArrayList<>();
        ElectiveSecond el1 = new ElectiveSecond("C#", "Torban learning C#", new Date(), "A");
        ElectiveSecond el2 = new ElectiveSecond("SW Design", "Here you learn the beauty of code.", new Date(), "A");
        ElectiveSecond el3 = new ElectiveSecond("Android", "Here you learn how to develop mobile apps.", new Date(), "B");
        ElectiveSecond el4 = new ElectiveSecond("Games", "Here you learn how to write/use basic game engines.", new Date(), "B");
        ElectiveSecond el5 = new ElectiveSecond("Python", "Here you learn the basics of Python.", new Date(), "B");
        secondRound.add(el1);
        secondRound.add(el2);
        secondRound.add(el3);
        secondRound.add(el4);
        secondRound.add(el5);
        return secondRound;
    }
}
