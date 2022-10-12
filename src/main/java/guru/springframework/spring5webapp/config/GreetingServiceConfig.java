package guru.springframework.spring5webapp.config;

import guru.springframework.misc.ConstructorGreetingService;
import guru.springframework.misc.PropertyInjectedGreetingService;
import guru.springframework.misc.i18nEnglishGreetingService;
import guru.springframework.pets.PetService;
import guru.springframework.pets.PetServiceFactory;
import guru.springframework.spring5webapp.datasource.FakeDataSource;
import guru.springframework.spring5webapp.repositories.EnglishGreetingRepository;
import guru.springframework.spring5webapp.repositories.EnglishGreetingRepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")//this should be first line for property source data
//the above line and data source properties file is not needed in spring boot context
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {
    @Bean
//    FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
//                                  @Value("${guru.password}") String password,
//                                  @Value("${guru.jdbcurl}") String jdbcurl){
    FakeDataSource fakeDataSource(SfgConfiguration sfgConfiguration){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(sfgConfiguration.getUsername());
        fakeDataSource.setPassword(sfgConfiguration.getPassword());
        fakeDataSource.setJdbcurl(sfgConfiguration.getJdbcurl());
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

//    @Bean("constructorBean") //by default the method name is the bean name for spring, but we override the name as shown in ""
    //service anno is not needed in service module as we mentioned bean here
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){ //example of DI, this is dependency of below method
        return new EnglishGreetingRepositoryImpl();
    }
    @Bean("i18NService")
    guru.springframework.misc.i18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){
        return new i18nEnglishGreetingService(englishGreetingRepository);
    }
@Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
}
}
