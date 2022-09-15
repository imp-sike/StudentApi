package com.sugar.studentapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sugar.studentapi.exception.ResourceNotFoundException;
import com.sugar.studentapi.modal.Student;
import com.sugar.studentapi.repository.StudentRepsoitory;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private StudentRepsoitory studentRepsoitory;

    // get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepsoitory.findAll();
    }

    // create student
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentRepsoitory.save(student);
    }

    // get student by id
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentRepsoitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("student not exist with given id"));
        return ResponseEntity.ok(student);
    }

    // delete student by id
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) {
        Student student = studentRepsoitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("student not exist with given id"));
        studentRepsoitory.delete(student);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    // update student by id
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentTemp) {
        Student student = studentRepsoitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("student not exist with given id"));

        student.setFirstName(studentTemp.getFirstName());
        student.setLastName(studentTemp.getLastName());
        student.setEmailId(studentTemp.getEmailId());

        Student updatedStudent =  studentRepsoitory.save(student);
        return ResponseEntity.ok(updatedStudent);
    }
}
