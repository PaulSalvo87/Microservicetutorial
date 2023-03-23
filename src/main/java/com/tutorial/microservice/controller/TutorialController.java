package com.tutorial.microservice.controller;


import com.tutorial.microservice.entity.Tutorial;
import com.tutorial.microservice.service.TutorialService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/tutorial/v1")
public class TutorialController {

    private static Logger logger = LoggerFactory.getLogger(TutorialController.class);

    @Autowired
    TutorialService tutorialService;


    @PostMapping
    public ResponseEntity<Tutorial> addTutorial(@RequestBody Tutorial tutorial){
        Tutorial addTutorial = tutorialService.addTutorial(tutorial);
        return ResponseEntity.ok(addTutorial);

    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> getAllTutorial(){
        List<Tutorial> lstTutorial= tutorialService.getAllTutorial();
        return ResponseEntity.ok(lstTutorial);
    }

    @Operation(summary = "Get Tutorial By Id")
    @GetMapping("/{idTutorial}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable String idTutorial){
        Optional<Tutorial> tutorial = tutorialService.getTutorialById(idTutorial);
        return new ResponseEntity<>(tutorial.get(), HttpStatus.OK);
    }

    @Operation(summary = "Delete Tutorial By Id")
    @DeleteMapping("/{idTutorial}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable String idTutorial){
        tutorialService.deleteTutorial(idTutorial);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
