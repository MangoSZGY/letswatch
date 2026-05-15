package hu.letswatch.config;

import hu.letswatch.model.Movie;
import hu.letswatch.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(MovieRepository repository) {
        return args -> {
            // Itt adjuk hozzá a kezdő adatokat
            repository.save(new Movie(null, "Shrek", "Andrew Adamson", 2001, null));
            repository.save(new Movie(null, "Inception", "Christopher Nolan", 2010, null));
            repository.save(new Movie(null, "Interstellar", "Christopher Nolan", 2014, null));

            System.out.println("--- Adatbázis sikeresen feltöltve teszt adatokkal! ---");
        };
    }
}