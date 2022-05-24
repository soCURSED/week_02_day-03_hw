package com.example.Day3.controllers;


import com.example.Day3.model.Buy;
import com.example.Day3.model.Park;
import com.example.Day3.model.ResponseAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/park/")

public class ParkController {

    ArrayList<Park> array = new ArrayList<>();

    @GetMapping("")
    public ResponseEntity<ArrayList<Park>> getPark() {
        return ResponseEntity.status(200).body(array);
    }

    // Adding
    @PostMapping("")
    public ResponseEntity addPark(@RequestBody @Valid Park park, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            ResponseAPI responseAPI = new ResponseAPI(message, 400, errors.getFieldError().getDefaultMessage());
            return ResponseEntity.status(400).body(responseAPI);

        }
        array.add(park);
        return ResponseEntity.status(200).body("Added Successfully!");

    }

    @PutMapping("{index}")
    public ResponseEntity updatePark(@PathVariable Integer index, @RequestBody @Valid Park park) {
        array.set(index, park);

        return ResponseEntity.status(200).body("Updated Successfully!");


    }

    @DeleteMapping("{index}")
    public ResponseEntity deletePark(@PathVariable Integer index) {
        array.remove(index);
        return ResponseEntity.status(200).body("Deleted Successfully!");
    }


    // localhost:8080/api/v1/park/buy/10/60
    // 10 is the rideID in json - 60 is amount
    @PutMapping("buy/{id}/{amount}")
    public ResponseEntity checkTicket(@PathVariable Integer id, @PathVariable Integer amount
            , Park park,Errors errors) {

        for (Park x : array) {
            if (x.getRideID().equals(id)) {


                if (x.getTickets() == 0 || amount >= x.getPrice()) {
                    return ResponseEntity.status(400).body("No enough money to buy ticket!");
                }
                x.setTickets(x.getTickets() - 1);
                return ResponseEntity.status(200).body("Ticket purchased!");

            }

        }

        return ResponseEntity.status(200).body("Error!");
    }
}
