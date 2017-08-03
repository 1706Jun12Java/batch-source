import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.revature.service.LibraryService;

@SpringBootApplication
@EnableJpaRepositories
public class Application {
	
	private LibraryService libraryService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
