package guru.springframework.spring5webapp.controllers;

import guru.springframework.misc.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    @Qualifier("propertyInjectedGreetingService")
    @Autowired
    public GreetingService greetingService ;


    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
