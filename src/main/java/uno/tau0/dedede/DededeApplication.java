package uno.tau0.dedede;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uno.tau0.dedede.view.Model;
import uno.tau0.dedede.view.ViewManager;
import uno.tau0.dedede.view.ViewModo;

@SpringBootApplication(scanBasePackages = "uno.tau0.dedede")
public class DededeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DededeApplication.class, args);
	}

    @Bean
    CommandLineRunner runner(Model model, org.springframework.context.ApplicationContext applicationContext) {
        return (args) -> {
            additionalTests(model);
            ViewManager viewManager = new ViewManager(model, applicationContext);
            viewManager.switchView(new ViewModo());
        };
    }

    private void additionalTests(Model model) {
        // 1+2 Native
        model.books.findByCatalogBookIsbn("50").forEach(System.out::println);
        var book = model.books.findByCatalogBookIsbn("50").getFirst();
        // Namy query
        model.commodates.findByUserId(5L).forEach(System.out::println);
        model.commodates.findByBookId(book.getId()).forEach(System.out::println);
        // JPA Query
        model.commodates.findByBookIdWhereReturnedIsFalse(1L).forEach(System.out::println);
        model.commodates.findByUserIdAndBookId(5L, book.getId()).forEach(System.out::println);
    }
}
