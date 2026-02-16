package uno.tau0.dedede.domain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uno.tau0.dedede.repository.CatalogBookRepository;

@SpringBootApplication
public class DededeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DededeApplication.class, args);
	}

    @Bean
    CommandLineRunner runner(CatalogBookRepository repository) {
        return args -> {
            System.out.println("EMPEZANDOOO");

            repository.findById("9887273878787").ifPresent(cb -> {
                System.out.println("Encontrado catalog " + cb.getIsbn());
                cb.books.forEach(b -> System.out.println(b.getID()));
            });
        };
    }
}
