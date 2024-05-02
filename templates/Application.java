package $PACKAGE_NAME$;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("$PACKAGE_NAME$.*")
public class $CLASS_NAME$Application {

	public static void main(String[] args) {
		SpringApplication.run($CLASS_NAME$Application.class, args);
	}

}
