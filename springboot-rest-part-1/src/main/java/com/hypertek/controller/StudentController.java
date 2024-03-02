package com.hypertek.controller;

import com.hypertek.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class StudentController {
    @GetMapping("/student")
    public ResponseEntity< Student> getStudent(){
        Student student = new Student(01,"John","Smith");
        return ResponseEntity.ok().header("custom","ramesh").body(student);
    }
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(02,"Smith","John"));
        students.add(new Student(03,"Jason","Mike"));
        students.add(new Student(04,"Demitry","Deluca"));
        students.add(new Student(05,"Jawad","John"));
        return ResponseEntity.ok(students);
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentPathVariable(@PathVariable int id){
        Student student=  new Student(id,"Ramish","Neisan");
        return ResponseEntity.ok(student);
    }
    @GetMapping("/studentPram/query")
    public ResponseEntity<Student> getStudentRequestPram(@RequestParam int id){
        Student student = new Student(id,"Heather","washington");
        return ResponseEntity.ok(student);
    }
    @PostMapping("/student/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> postStudent(@RequestBody Student student){
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    @PutMapping("/student/{id}/update")
    public ResponseEntity<Student> putStudent(@RequestBody Student student,@PathVariable int id){
        Student student1 = new Student();
        student1.setId(id);
        student1.setFirstname(student.getFirstname());
        student1.setLastname(student.getLastname());
        return ResponseEntity.ok(student1);
    }
    @DeleteMapping("/student/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        return ResponseEntity.ok("Student deleted successfully");
    }
}
