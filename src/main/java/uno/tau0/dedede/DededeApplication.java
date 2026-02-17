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
            ViewManager viewManager = new ViewManager(model, applicationContext);
            viewManager.switchView(new ViewModo());
        };
    }
}
