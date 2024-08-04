package com.example.demo.controller.impl;

import com.example.demo.controller.RandomNumberController;
import com.example.modules.component.impl.RandomGeneratorComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rnd")
@ComponentScan(basePackageClasses = {RandomGeneratorComponent.class})
public class RandomNumberControllerImpl implements RandomNumberController {

    @Autowired
    private RandomGeneratorComponent randomGeneratorComponent;

    @GetMapping("/gr")
    @CrossOrigin(origins = "*")
    @Override
    public ResponseEntity<Long> getRandomNumber() {
        return ResponseEntity.of(Optional.of(randomGeneratorComponent.nextRandomInteger()));
    }
}
