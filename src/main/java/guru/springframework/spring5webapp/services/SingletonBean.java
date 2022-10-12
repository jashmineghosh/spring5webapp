package guru.springframework.spring5webapp.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class SingletonBean {
    public SingletonBean() {
        System.out.println("creating singleton bean!");
    }
    public String getMyScope(){
        return "my scope is Singleton";
    }
}
