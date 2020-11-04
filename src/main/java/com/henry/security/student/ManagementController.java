package com.henry.security.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/management/api/v1/students")
public class ManagementController {
    private final static List<Student> STUDENT_LIST = List.of(
            new Student(UUID.fromString("48354305-91d5-4ba2-bbba-d13bee89369e"), "Tom Stanly"),
            new Student(UUID.fromString("6900055f-4fd3-4527-b1db-e934b305efba"), "Maria Jolie")
    );

    @GetMapping
    public List<Student> getAllStudents() {
        return STUDENT_LIST;
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student) {
        System.out.printf("registerStudent %s%n", student);
    }

    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable UUID studentId, @RequestBody Student student) {
        System.out.printf("updateStudent %s%n", student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable UUID studentId) {
        System.out.printf("deleteStudent %s%n", studentId);
    }
}
