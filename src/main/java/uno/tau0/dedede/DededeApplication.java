package uno.tau0.dedede;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.NoSuchElementException;

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
