package com.travel.agent;

import java.util.Arrays;

import com.travel.agent.model.Template;
import com.travel.agent.repository.TemplateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.travel.agent.model.Role;
import com.travel.agent.model.User;
import com.travel.agent.repository.UserRepository;
import com.travel.agent.service.UserService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner loadData(
            UserService userService,
            UserRepository userRepo,
            TemplateRepository templateRepository
    ) {
        return (args) -> {

            User existing = userRepo.findByEmail(Constants.ADMIN_EMAIL);
            if (existing == null) {
                //roleRepo.save(new Role("Admin"));
                //roleRepo.save(new Role("Contributor"));

                User user = new User(Constants.ADMIN_FULLNAME, Constants.ADMIN_EMAIL, Constants.ADMIN_PASSWORD,
                        Arrays.asList(new Role(Constants.ADMIN)));

                userService.saveAdmin(user);

                templateRepository.save(new Template(
                        "First Template Example",
                        "firstTemplate",
                        """
                             {
                                "title": "Title Example",
                                "first-paragraph": "Lorem Ipsum is simply dummy text of the printing and typesetting industry...",
                                "second-paragraph": "This is a second paragraph example"
                             }
                             """
                ));

                templateRepository.save(new Template(
                        "Second Template Example",
                        "firstTemplate",
                        """
                             {
                                "title": "Second Title Example",
                                "first-paragraph": "Another paragraph example ..."
                             }
                             """
                ));

                templateRepository.save(new Template(
                        "Third Template Example",
                        "firstTemplate",
                        """
                             {
                                "title": "Third Title Example"
                             }
                             """
                ));
            }
        };
    }

}
