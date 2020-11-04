package com.henry.security.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final static List<Student> STUDENT_LIST = List.of(
            new Student(UUID.fromString("48354305-91d5-4ba2-bbba-d13bee89369e"), "Tom Stanly"),
            new Student(UUID.fromString("6900055f-4fd3-4527-b1db-e934b305efba"), "Maria Jolie")
    );

    @GetMapping
    public List<Student> getStudents() {
        return STUDENT_LIST;
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") UUID studentId) {
        return STUDENT_LIST.stream()
                .filter(student -> studentId.equals(student.getId()))
                .findFirst()
                .orElseThrow();
    }
}
