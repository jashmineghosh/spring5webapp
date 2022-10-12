package guru.springframework.spring5webapp.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {
    @Override
    public String getGreetingRepo() {
        return "Hello there!- repositories";
    }
}
