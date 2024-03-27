package com.bluehogusa.bluehog.controllers;

import org.springframework.http.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/main")
@CrossOrigin(origins = "*")
public class mainController {

    @GetMapping("")
    public ResponseEntity<?> test() {
        return new ResponseEntity<String>("test work", HttpStatus.OK);
    }

}
