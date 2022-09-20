package com.neu.lify.jdbc.procedure.student.services.impl;

import com.neu.lify.jdbc.procedure.student.dao.StudentDao;
import com.neu.lify.jdbc.procedure.student.entity.Student;
import com.neu.lify.jdbc.procedure.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public Student getStudent(Integer id) {
        return studentDao.getStudent(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int deleteStudent(Integer id) {
        return studentDao.deleteStudent(id);
    }
}
