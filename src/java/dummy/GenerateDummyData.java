/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy;

import dto.Elective;
import dto.ElectiveFirst;
import dto.ElectiveSecond;
import dto.FirstRound;
import dto.SecondRound;
import dto.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author adamv_000
 */
public class GenerateDummyData {

    public static ArrayList<Student> generateStudents() {
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student("Jack", "Black", "014323-4569");
        Student s2 = new Student("Adolf", "Ray", "012323-4567");
        Student s3 = new Student("O'Really", "Jack", "430423-4569");
        Student s4 = new Student("Leo", "Nary", "012123-4562");
        Student s5 = new Student("Jhon Aron", "Var", "014323-4563");
        Student s6 = new Student("Lop", "Roy", "014323-4519");
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        return students;
    }
//we send the ArrayLists so we would not have to hardcore the dumy data
    public static ArrayList<FirstRound> generateFirstRoundList( ArrayList<Student> students,ArrayList<ElectiveFirst> electives) {
        ArrayList<FirstRound> firstVotes = new ArrayList<>();
        FirstRound fr1;
        FirstRound fr2;
        FirstRound fr3;
        //just be sure we have enough electives, which to pick, and also that we have at least 1 student
    if (electives.size() >= 4&&students.size()>=1) {
         fr1 = new FirstRound(students.get(1),electives.get(1),electives.get(2),electives.get(3),electives.get(4));
       //just be sure that we have enough students
         if(electives.size() >= 4&&students.size()>=2)
         fr1 = new FirstRound(students.get(2),electives.get(1),electives.get(2),electives.get(3),electives.get(4));
          
    }
        return firstVotes;

    }

    public static ArrayList<Elective> generateProposedEle() {
        ArrayList<Elective> proposedElectives = new ArrayList<>();
        Elective el1 = new Elective("C#", "Torban learning C#", new Date());
        Elective el2 = new Elective("Python", "Here you learn the basics of Python.", new Date());
        Elective el3 = new Elective("Android", "Here you learn how to develop mobile apps.", new Date());
        Elective el4 = new Elective("SW Design", "Here you learn the beauty of code.", new Date());
        Elective el5 = new Elective("Games", "Here you learn how to write/use basic game engines.", new Date());
        Elective el6 = new Elective("Databases", "Here you learn how to persistently store bulks of data.", new Date());
        Elective el7 = new Elective("Test drived development", "Tests first guys!", new Date());
        Elective el8 = new Elective("Modern Func languages", "Here you learn recursions etc..", new Date());
        proposedElectives.add(el1);
        proposedElectives.add(el2);
        proposedElectives.add(el3);
        proposedElectives.add(el4);
        proposedElectives.add(el5);
        proposedElectives.add(el6);
        proposedElectives.add(el7);
        proposedElectives.add(el8);
        return proposedElectives;
    }

    public static ArrayList<FirstRound> generateFirstRoundVote() {

        ArrayList<FirstRound> firstRound = new ArrayList<>();

        ElectiveFirst el1 = new ElectiveFirst("C#", "Torban learning C#", new Date(), 1, 1);
        ElectiveFirst el2 = new ElectiveFirst("Python", "Here you learn the basics of Python.", new Date(), 1, 1);
        ElectiveFirst el3 = new ElectiveFirst("Android", "Here you learn how to develop mobile apps.", new Date(), 1, 1);
        ElectiveFirst el4 = new ElectiveFirst("SW Design", "Here you learn the beauty of code.", new Date(), 2, 1);
        ElectiveFirst el5 = new ElectiveFirst("Games", "Here you learn how to write/use basic game engines.", new Date(), 1, 0);
        ElectiveFirst el6 = new ElectiveFirst("Databases", "Here you learn how to persistently store bulks of data.", new Date(), 0, 2);
        ElectiveFirst el7 = new ElectiveFirst("Test drived development", "Tests first guys!", new Date(), 0, 2);
        ElectiveFirst el8 = new ElectiveFirst("Modern Func languages", "Here you learn recursions etc..", new Date(), 2, 0);

        Student s1 = new Student("Jack", "Black", "0123-456789");
        Student s2 = new Student("Adolf", "Ray", "0123-456712");
        Student s3 = new Student("O'Really", "Jack", "0423-456789");
        Student s4 = new Student("Leo", "Nary", "0123-456289");
        Student s5 = new Student("Jhon Aron", "Var", "0123-456703");
        Student s6 = new Student("Lop", "Roy", "0123-451239");

        FirstRound fr1 = new FirstRound(s1, el1, el4, el3, el2);
        FirstRound fr2 = new FirstRound(s2, el8, el4, el6, el7);
        FirstRound fr3 = new FirstRound(s3, el3, el5, el1, el6);
        FirstRound fr4 = new FirstRound(s2, el8, el4, el1, el7);

        firstRound.add(fr1);
        firstRound.add(fr2);
        firstRound.add(fr3);
        firstRound.add(fr4);

        return firstRound;
    }
    
    public static ArrayList<SecondRound> generateSecondRoundVote() {

        ArrayList<SecondRound> secondRound = new ArrayList<>();

        ElectiveSecond el1 = new ElectiveSecond("C#", "Torban learning C#", new Date(), "A");
        ElectiveSecond el2 = new ElectiveSecond("SW Design", "Here you learn the beauty of code.", new Date(), "A");
        ElectiveSecond el3 = new ElectiveSecond("Android", "Here you learn how to develop mobile apps.", new Date(), "B");
        ElectiveSecond el4 = new ElectiveSecond("Games", "Here you learn how to write/use basic game engines.", new Date(), "B");
        ElectiveSecond el5 = new ElectiveSecond("Python", "Here you learn the basics of Python.", new Date(), "B");

        Student s1 = new Student("Jack", "Black", "0123-456789");
        Student s2 = new Student("Adolf", "Ray", "0123-456712");
        Student s3 = new Student("O'Really", "Jack", "0423-456789");
        Student s4 = new Student("Leo", "Nary", "0123-456289");
        Student s5 = new Student("Jhon Aron", "Var", "0123-456703");
        Student s6 = new Student("Lop", "Roy", "0123-451239");

        SecondRound fr1 = new SecondRound(el1, el2, el3, el2, s5);
        SecondRound fr2 = new SecondRound(null, null, null, null, s1);


        secondRound.add(fr1);
        secondRound.add(fr2);
     
        return secondRound;
    }

    public static ArrayList<ElectiveFirst> generateFirstRndEle() {
        ArrayList<ElectiveFirst> secondRound = new ArrayList<>();
        ElectiveFirst el1 = new ElectiveFirst("C#", "Torban learning C#", new Date(), 1, 1);
        ElectiveFirst el2 = new ElectiveFirst("Python", "Here you learn the basics of Python.", new Date(), 1, 1);
        ElectiveFirst el3 = new ElectiveFirst("Android", "Here you learn how to develop mobile apps.", new Date(), 1, 1);
        ElectiveFirst el4 = new ElectiveFirst("SW Design", "Here you learn the beauty of code.", new Date(), 2, 1);
        ElectiveFirst el5 = new ElectiveFirst("Games", "Here you learn how to write/use basic game engines.", new Date(), 1, 0);
        ElectiveFirst el6 = new ElectiveFirst("Databases", "Here you learn how to persistently store bulks of data.", new Date(), 0, 2);
        ElectiveFirst el7 = new ElectiveFirst("Test drived development", "Tests first guys!", new Date(), 0, 2);
        ElectiveFirst el8 = new ElectiveFirst("Modern Func languages", "Here you learn recursions etc..", new Date(), 2, 0);
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

    public static ArrayList<ElectiveSecond> generateSecondRndEle() {
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
