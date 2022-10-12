package guru.springframework.spring5webapp.controllers;

import guru.springframework.misc.ConstructorGreetingService;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetterInjectedControllerTest  {

    SetterInjectedController controller;
    @BeforeEach
    void setUp()  {
        controller = new SetterInjectedController();
        controller.setGreetingService(new ConstructorGreetingService());
    }

    @Test
    public void testGetGreeting() {
        controller.getGreeting();
    }
}