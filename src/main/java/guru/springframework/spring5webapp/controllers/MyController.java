package guru.springframework.spring5webapp.controllers;

import guru.springframework.misc.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        System.out.println("hello world from myController");
//        return "Hi Folks";
        return greetingService.sayGreeting();
    }
}
