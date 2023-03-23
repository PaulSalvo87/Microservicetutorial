package com.tutorial.microservice.service;

import com.tutorial.microservice.entity.Tutorial;
import com.tutorial.microservice.repository.TutorialRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.when;

class TutorialServiceTest {

    @Mock
    TutorialRepository tutorialRepository;

    @InjectMocks
    TutorialService tutorialService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test01(){
        List<String> mockList= Mockito.mock(List.class);
        Mockito.when(mockList.size()).thenReturn(5);
        assertTrue(mockList.size()==5);
    }

    @Test
    void addTutorial() {
    }

    @Test
    void getAllTutorial() {
        Mockito.when(tutorialRepository.findAll()).thenReturn(getTutorial());
        var result= tutorialService.getAllTutorial();
        assertEquals(2,result.size());
    }

    @Test
    void getTutorialById() {
        String id="112";
        Mockito.when(tutorialRepository.findById(any())).thenReturn(Optional.of(getTutorialId()));
        var result= tutorialService.getTutorialById(id);
        assertEquals("Paul",result.get().getName());

        //return tutorialRepository.findById(idTutorial)

    }

    @Test
    void deleteTutorial() {
    }


    private Tutorial getTutorialId(){

        Tutorial tutorial01 = new Tutorial();
        tutorial01.setIdTutorial("112");
        tutorial01.setName("Paul");
        tutorial01.setDescription("Programador");

        return tutorial01;
    }
    private List<Tutorial> getTutorial(){

        List<Tutorial> lstTutorial = new ArrayList<>();
        Tutorial tutorial01 = new Tutorial();
        tutorial01.setIdTutorial("112");
        tutorial01.setName("Paul");
        tutorial01.setDescription("Programador");
        lstTutorial.add(tutorial01);

        Tutorial tutorial02 = new Tutorial();
        tutorial02.setIdTutorial("222");
        tutorial02.setName("PaulSalvo");
        tutorial02.setDescription("Programador2");
        lstTutorial.add(tutorial01);

        return lstTutorial;
    }
}