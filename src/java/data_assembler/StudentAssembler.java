/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_assembler;

import dto.StudentDTO;
import entities.Student;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author adamv_000
 */
public class StudentAssembler {

    public static StudentDTO assembleStudent(Student student) {
        return new StudentDTO(student.getFirstName(), student.getLastName(), student.getCpr());
    }

    public static Collection<StudentDTO> assembleStudents(Collection<Student> students) {
        Collection<StudentDTO> studentsDTO = new ArrayList<>();

        for (Student s : students) {
            studentsDTO.add(assembleStudent(s));
        }
        return studentsDTO;
    }
}
