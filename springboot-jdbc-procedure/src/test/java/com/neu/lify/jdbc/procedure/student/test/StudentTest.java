package com.neu.lify.jdbc.procedure.student.test;

import com.neu.lify.jdbc.procedure.ProcedureApplicationTests;
import com.neu.lify.jdbc.procedure.student.entity.Student;
import com.neu.lify.jdbc.procedure.student.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Component
public class StudentTest extends ProcedureApplicationTests {

    @Autowired
    private StudentService studentService;

    @Test
    public void a_save() {
        Student stu = new Student();
        stu.setName("杨");
        stu.setScore(89);
        stu.setUpdatetime(new Date());

        int row = studentService.insertStudent(stu);

        Assert.assertNotEquals(-1, row);
    }

    @Test
    public void b_query() {
        List<Student> studentList = studentService.getStudentList();

        Assert.assertTrue(studentList.size() > 0);
    }

    @Test
    public void c_update() {
        List<Student> studentList = studentService.getStudentList();
        Assert.assertTrue(studentList.size() > 0);

        Student stu = studentList.get(studentList.size() - 1);

        String name = "牛";
        Assert.assertNotEquals(name, stu.getName());

        stu.setName(name);

        studentService.updateStudent(stu);

        Student afterUpdate = studentService.getStudent(stu.getId());

        Assert.assertEquals(name, afterUpdate.getName());

    }

    @Test
    public void d_delete() {
        List<Student> studentList = studentService.getStudentList();
        Assert.assertTrue(studentList.size() > 0);

        Student stu = studentList.get(studentList.size() - 1);
        Integer id = stu.getId();

        int result = studentService.deleteStudent(id);

        Assert.assertTrue(result > -1);

        Student afterDelete = studentService.getStudent(id);

        Assert.assertNull(afterDelete);
    }
}

