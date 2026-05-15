package hu.letswatch.config;

import hu.letswatch.model.Movie;
import hu.letswatch.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(MovieRepository repository) {
        return args -> {
            repository.save(new Movie(null, "Shrek", "Andrew Adamson", 2001,
                    "Egy morcos ogre kalandjai, aki meg akarja menteni a mocsara nyugalmát.",
                    "https://m.media-amazon.com/images/M/MV5BOGJjMzZmM2UtNjVjYi00ZDEwLThjMTMtNWU2NjgxOWVlY2QyXkEyXkFqcGc@._V1_.jpg",
                    new ArrayList<>()));

            repository.save(new Movie(null, "Inception", "Christopher Nolan", 2010,
                    "Tolvajok, akik álmokon keresztül lopnak titkokat.",
                    "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg",
                    new ArrayList<>()));

            System.out.println("--- Adatbázis frissítve poszterekkel! ---");
        };
    }
}