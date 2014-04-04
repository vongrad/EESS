/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy;

import dto.ElectiveDTO;
import dto.ElectiveFirstDTO;
import dto.ElectiveSecondDTO;
import dto.FirstVoteDTO;
import dto.SecondVoteDTO;
import dto.StudentDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author adamv_000
 */
public class GenerateDummyData {

    public static ArrayList<StudentDTO> generateStudents() {
        ArrayList<StudentDTO> students = new ArrayList<>();
        StudentDTO s1 = new StudentDTO("Bjarke", "Carlsen", "014323-4123");
        StudentDTO s2 = new StudentDTO("Emil", "Christiansen", "044323-4123");
        StudentDTO s3 = new StudentDTO("Jesper", "Dahl", "120423-4561");
        StudentDTO s4 = new StudentDTO("Kenn", "Jacobsen", "123131-2342");
        StudentDTO s5 = new StudentDTO("Aske", "Rode", "123431-4312");
        StudentDTO s6 = new StudentDTO("Thor", "Kristen", "124312-1234");
        StudentDTO s7 = new StudentDTO("Patrick", "Larsen", "432232-2398");
        StudentDTO s8 = new StudentDTO("Johan", "Leu", "014398-4563");
        StudentDTO s9 = new StudentDTO("Jesper", "Olsen", "764323-4519");
        StudentDTO s10 = new StudentDTO("Martin", "Olgenkjær", "014323-4563");
        StudentDTO s11 = new StudentDTO("Henrik", "Stavnem", "014323-4519");
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);
        students.add(s9);
        students.add(s10);
        students.add(s11);

        return students;
    }

    public static ArrayList<FirstVoteDTO> generateFirstRoundList(ArrayList<StudentDTO> students, ArrayList<ElectiveDTO> electives) {
        ArrayList<FirstVoteDTO> firstVotes = new ArrayList<>();

        FirstVoteDTO fr1 = new FirstVoteDTO(students.get(0), electives.get(3), electives.get(2), electives.get(1), electives.get(4));
        FirstVoteDTO fr2 = new FirstVoteDTO(students.get(8), electives.get(3), electives.get(0), electives.get(2), electives.get(1));
        FirstVoteDTO fr3 = new FirstVoteDTO(students.get(9), electives.get(7), electives.get(3), electives.get(5), electives.get(6));
        FirstVoteDTO fr4 = new FirstVoteDTO(students.get(10), electives.get(1), electives.get(7), electives.get(3), electives.get(6));
        firstVotes.add(fr1);
        firstVotes.add(fr2);
        firstVotes.add(fr3);
        firstVotes.add(fr4);

        return firstVotes;

    }

    public static ArrayList<ElectiveDTO> generateProposedEle() {
        ArrayList<ElectiveDTO> proposedElectives = new ArrayList<>();
        ElectiveDTO el1 = new ElectiveDTO("C#", "Torban learning C#", new Date(), "1");
        ElectiveDTO el2 = new ElectiveDTO("Python", "Here you learn the basics of Python.", new Date(), "1");
        ElectiveDTO el3 = new ElectiveDTO("Android", "Here you learn how to develop mobile apps.", new Date(), "1");
        ElectiveDTO el4 = new ElectiveDTO("SW Design", "Here you learn the beauty of code.", new Date(), "1");
        ElectiveDTO el5 = new ElectiveDTO("Games", "Here you learn how to write/use basic game engines.", new Date(), "1");
        ElectiveDTO el6 = new ElectiveDTO("Databases", "Here you learn how to persistently store bulks of data.", new Date(), "1");
        ElectiveDTO el7 = new ElectiveDTO("Test drived development", "Tests first guys!", new Date(), "1");
        ElectiveDTO el8 = new ElectiveDTO("Modern Func languages", "Here you learn recursions etc..", new Date(), "1");
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

    public static ArrayList<FirstVoteDTO> generateFirstRoundVote() {

        ArrayList<FirstVoteDTO> firstRound = new ArrayList<>();
//
//        ElectiveFirstDTO el1 = new ElectiveFirstDTO("C#", "Torban learning C#", new Date(), 1, 1);
//        ElectiveFirstDTO el2 = new ElectiveFirstDTO("Python", "Here you learn the basics of Python.", new Date(), 1, 1);
//        ElectiveFirstDTO el3 = new ElectiveFirstDTO("Android", "Here you learn how to develop mobile apps.", new Date(), 1, 1);
//        ElectiveFirstDTO el4 = new ElectiveFirstDTO("SW Design", "Here you learn the beauty of code.", new Date(), 2, 1);
//        ElectiveFirstDTO el5 = new ElectiveFirstDTO("Games", "Here you learn how to write/use basic game engines.", new Date(), 1, 0);
//        ElectiveFirstDTO el6 = new ElectiveFirstDTO("Databases", "Here you learn how to persistently store bulks of data.", new Date(), 0, 2);
//        ElectiveFirstDTO el7 = new ElectiveFirstDTO("Test drived development", "Tests first guys!", new Date(), 0, 2);
//        ElectiveFirstDTO el8 = new ElectiveFirstDTO("Modern Func languages", "Here you learn recursions etc..", new Date(), 2, 0);
//
//        StudentDTO s1 = new StudentDTO("Jack", "Black", "0123-456789");
//        StudentDTO s2 = new StudentDTO("Adolf", "Ray", "0123-456712");
//        StudentDTO s3 = new StudentDTO("O'Really", "Jack", "0423-456789");
//        StudentDTO s4 = new StudentDTO("Leo", "Nary", "0123-456289");
//        StudentDTO s5 = new StudentDTO("Jhon Aron", "Var", "0123-456703");
//        StudentDTO s6 = new StudentDTO("Lop", "Roy", "0123-451239");
//
//        FirstRoundDTO fr1 = new FirstRoundDTO(s1, el1, el4, el3, el2);
//        FirstRoundDTO fr2 = new FirstRoundDTO(s2, el8, el4, el6, el7);
//        FirstRoundDTO fr3 = new FirstRoundDTO(s3, el3, el5, el1, el6);
//        FirstRoundDTO fr4 = new FirstRoundDTO(s2, el8, el4, el1, el7);
//
//        firstRound.add(fr1);
//        firstRound.add(fr2);
//        firstRound.add(fr3);
//        firstRound.add(fr4);

        return firstRound;

    }

    public static ArrayList<SecondVoteDTO> generateSecondRoundVote() {

        ArrayList<SecondVoteDTO> secondRound = new ArrayList<>();

        ElectiveSecondDTO el1 = new ElectiveSecondDTO(1,"C#", "Torban learning C#", new Date(), "1", "A");
        ElectiveSecondDTO el2 = new ElectiveSecondDTO(2,"SW Design", "Here you learn the beauty of code.", new Date(), "1", "A");
        ElectiveSecondDTO el3 = new ElectiveSecondDTO(3,"Android", "Here you learn how to develop mobile apps.", new Date(), "1", "B");
        ElectiveSecondDTO el4 = new ElectiveSecondDTO(4,"Games", "Here you learn how to write/use basic game engines.", new Date(), "1", "B");
        ElectiveSecondDTO el5 = new ElectiveSecondDTO(5,"Python", "Here you learn the basics of Python.", new Date(), "1", "B");

        StudentDTO s1 = new StudentDTO("Jack", "Black", "0123-456789");
        StudentDTO s2 = new StudentDTO("Adolf", "Ray", "0123-456712");
        StudentDTO s3 = new StudentDTO("O'Really", "Jack", "0423-456789");
        StudentDTO s4 = new StudentDTO("Leo", "Nary", "0123-456289");
        StudentDTO s5 = new StudentDTO("Jhon Aron", "Var", "0123-456703");
        StudentDTO s6 = new StudentDTO("Lop", "Roy", "0123-451239");

        SecondVoteDTO fr1 = new SecondVoteDTO(el1, el2, el3, el2, s5);
        SecondVoteDTO fr2 = new SecondVoteDTO(null, null, null, null, s1);

        secondRound.add(fr1);
        secondRound.add(fr2);

        return secondRound;
    }

    public static ArrayList<ElectiveFirstDTO> generateFirstRndEle() {
        ArrayList<ElectiveFirstDTO> secondRound = new ArrayList<>();
        ElectiveFirstDTO el1 = new ElectiveFirstDTO(1,"C#", "Torban learning C#", new Date(), "1", 1, 1);
        ElectiveFirstDTO el2 = new ElectiveFirstDTO(2,"Python", "Here you learn the basics of Python.", new Date(), "1", 1, 1);
        ElectiveFirstDTO el3 = new ElectiveFirstDTO(3,"Android", "Here you learn how to develop mobile apps.", new Date(), "1", 1, 1);
        ElectiveFirstDTO el4 = new ElectiveFirstDTO(4,"SW Design", "Here you learn the beauty of code.", new Date(), "1", 2, 1);
        ElectiveFirstDTO el5 = new ElectiveFirstDTO(5,"Games", "Here you learn how to write/use basic game engines.", new Date(), "1", 1, 0);
        ElectiveFirstDTO el6 = new ElectiveFirstDTO(6,"Databases", "Here you learn how to persistently store bulks of data.", new Date(), "1", 0, 2);
        ElectiveFirstDTO el7 = new ElectiveFirstDTO(7,"Test drived development", "Tests first guys!", new Date(), "1", 0, 2);
        ElectiveFirstDTO el8 = new ElectiveFirstDTO(8,"Modern Func languages", "Here you learn recursions etc..", new Date(), "1", 2, 0);
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

    public static ArrayList<ElectiveSecondDTO> generateSecondRndEle() {
        ArrayList<ElectiveSecondDTO> secondRound = new ArrayList<>();
        ElectiveSecondDTO el1 = new ElectiveSecondDTO(1,"C#", "Torban learning C#", new Date(), "1", "A");
        ElectiveSecondDTO el2 = new ElectiveSecondDTO(2,"SW Design", "Here you learn the beauty of code.", new Date(), "1", "A");
        ElectiveSecondDTO el3 = new ElectiveSecondDTO(3,"Android", "Here you learn how to develop mobile apps.", new Date(), "1", "B");
        ElectiveSecondDTO el4 = new ElectiveSecondDTO(4,"Games", "Here you learn how to write/use basic game engines.", new Date(), "1", "B");
        ElectiveSecondDTO el5 = new ElectiveSecondDTO(5,"Python", "Here you learn the basics of Python.", new Date(), "1", "B");
        secondRound.add(el1);
        secondRound.add(el2);
        secondRound.add(el3);
        secondRound.add(el4);
        secondRound.add(el5);
        return secondRound;
    }
}
