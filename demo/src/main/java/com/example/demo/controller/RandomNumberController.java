package com.example.demo.controller;

import org.springframework.http.ResponseEntity;

public interface RandomNumberController {
    ResponseEntity<Long> getRandomNumber();
}
