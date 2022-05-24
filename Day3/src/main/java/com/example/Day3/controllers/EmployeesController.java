package com.example.Day3.controllers;


import com.example.Day3.model.Employees;
import com.example.Day3.model.ResponseAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RequestMapping("api/v1/employee/")
public class EmployeesController {

    ArrayList<Employees> array = new ArrayList<>();

    @GetMapping("")
    public ResponseEntity<ArrayList<Employees>> getEmp(){
        return ResponseEntity.status(200).body(array);
    }
    @PostMapping("")
    public ResponseEntity addEmp(@RequestBody @Valid Employees employees, Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            ResponseAPI responseAPI = new ResponseAPI(message,400,errors.getFieldError().getDefaultMessage());
            return ResponseEntity.status(400).body(responseAPI);

        }
        array.add(employees);

        return ResponseEntity.status(200).body(array);

    }

    @PutMapping("{index}")
    public ResponseEntity updateEmp(@PathVariable Integer index, @RequestBody @Valid Employees employees, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            ResponseAPI responseAPI = new ResponseAPI(message,400,errors.getFieldError().getDefaultMessage());
            return ResponseEntity.status(400).body(responseAPI);

        }
        array.set(index,employees);

        return ResponseEntity.status(200).body(array);

    }
    @DeleteMapping("{index}")
    public ResponseEntity deleteEmp(@PathVariable Integer index,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            ResponseAPI responseAPI = new ResponseAPI(message,400,errors.getFieldError().getDefaultMessage());
            return ResponseEntity.status(400).body(responseAPI);

        }
        array.remove(index);

        return ResponseEntity.status(200).body(array);

    }
}










