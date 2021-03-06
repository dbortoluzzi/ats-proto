package eu.dbortoluzzi.atms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AtmServiceApplication {

	@Autowired
	private AtmDataSeeder atmDataSeeder;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(AtmServiceApplication.class, args);
		
		AtmServiceApplication app =
				context.getBean(AtmServiceApplication.class);
		app.init();
	}
	
	public void init() {
		atmDataSeeder.seedIfEmpty();
	}
}
