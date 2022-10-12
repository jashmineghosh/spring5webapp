package guru.springframework.misc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Profile("ES")
@Service("i18NService")
public class i18nSpanishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - ES";
    }
}
