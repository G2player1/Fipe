package Enos.projectsApi.Fipe;

import Enos.projectsApi.Fipe.exceptions.CantGetDataException;
import Enos.projectsApi.Fipe.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			Main main = new Main();
			main.showMenu();
		} catch (CantGetDataException e){
			System.out.println(e.getMessage());
		}
	}
}
