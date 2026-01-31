package tn.esprit.msjobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.msjobs.Entities.Jobs;
import tn.esprit.msjobs.Repositories.IJobRepository;

@SpringBootApplication
public class MsJobsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsJobsApplication.class, args);
    }

    @Autowired
    private IJobRepository jobRepository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {

            jobRepository.save(new Jobs(true,"Service Financier"));
            jobRepository.save(new Jobs(false,"Service Info" ));
            jobRepository.save(new Jobs(false,"Service RH"));

            jobRepository.findAll().forEach(System.out::println);
        };
    }

}




