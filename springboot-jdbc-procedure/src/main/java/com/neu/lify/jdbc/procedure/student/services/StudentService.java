package com.neu.lify.jdbc.procedure.student.services;

import com.neu.lify.jdbc.procedure.student.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList();

    int insertStudent(Student student);

    Student getStudent(Integer id);

    int updateStudent(Student student);

    int deleteStudent(Integer id);
}
