package guru.springframework.misc;

import guru.springframework.spring5webapp.repositories.EnglishGreetingRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
//@Profile({"EN","default"})

//@Service("i18NService")
public class i18nEnglishGreetingService implements GreetingService {

    private final EnglishGreetingRepository englishGreetingRepository;

    public i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return this.englishGreetingRepository.getGreetingRepo();
    }

//    @Override
//    public String sayGreeting() {
//        return "Hello World - EN";
//    }

}
