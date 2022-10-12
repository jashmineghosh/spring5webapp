package guru.springframework.spring5webapp.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("creating PrototypeBean bean!!!!!!!!!!!!");
    }
    public String getMyScope(){
        return "my scope is PrototypeBean";
    }
}
