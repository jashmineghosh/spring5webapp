package guru.springframework.spring5webapp.controllers;

import guru.springframework.misc.GreetingService;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectedController {
//    @Autowired // it is optional for constructor
    private final GreetingService greetingService;

    public ConstructorInjectedController(
//            @Qualifier("constructorGreetingService") //gets primary marked bean, if this is disabled
                    GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
