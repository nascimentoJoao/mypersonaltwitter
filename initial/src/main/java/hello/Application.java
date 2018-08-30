package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserMessageRepository repository) {

        return (args) -> {
			// save a couple of customers
			repository.save(new UserMessage("Vinicius", "estou trost n tenho rede #trost"));
			repository.save(new UserMessage("Joao", "@vinicius acontece migs"));
			repository.save(new UserMessage("Bolsominion", "melhor jair se acostumando #bolsomito2018"));
			repository.save(new UserMessage("Vinicius", "@bolsominion migs......................... . . . . ."));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (UserMessage customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			/*repository.findById(1L)
				.ifPresent(customer -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});*/

			// fetch customers by last name
			//log.info("Customer found with findByLastName('Bauer'):");
			//log.info("--------------------------------------------");
			//repository.findByLastName("Bauer").forEach(bauer -> {
			//	log.info(bauer.toString());
			//});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}

    
}