package com.example.Day3.controllers;

import com.example.Day3.model.ResponseAPI;
import com.example.Day3.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student/")
public class StudentController {
    ArrayList<Student> array = new ArrayList<>();

    @GetMapping("")
    public ResponseEntity<ArrayList<Student>> getStudents(){
        return ResponseEntity.status(200).body(array);
    }

    @PostMapping("")
    public ResponseEntity addStudents(@RequestBody @Valid Student student, Errors errors){


        if (errors.hasErrors()){
           String message = errors.getFieldError().getDefaultMessage();
           ResponseAPI responseAPI = new ResponseAPI(message,400,errors.getFieldError().getDefaultMessage());
           return ResponseEntity.status(400).body(responseAPI);

       }
        array.add(student);
        return ResponseEntity.status(200).body("Student Added!");
    }
    @PutMapping("{index}")
    public ResponseEntity updateStudent(@PathVariable int index, @RequestBody Student student){
        array.set(index,student);
        return ResponseEntity.status(200).body("Student Updated!");
    }

    @DeleteMapping("{index}")
    public ResponseEntity deleteStudent(@PathVariable int index){
        array.remove(index);
        return ResponseEntity.status(200).body("Student Removed!");
    }






}
