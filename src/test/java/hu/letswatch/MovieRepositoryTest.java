package hu.letswatch;

import hu.letswatch.model.Movie;
import hu.letswatch.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/** Repository tests for let$watch. */
@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void testSaveAndFindMovie() {
        // 1. Előkészítés (Given)
        // Nem használunk paraméteres konstruktort, hogy ne legyen hiba
        Movie movie = new Movie();
        movie.setTitle("Interstellar");
        movie.setGenre("Sci-Fi");
        movie.setReleaseYear(2014);
        movie.setPlot("A team of explorers travel through a wormhole in space.");

        // 2. Végrehajtás (When)
        Movie savedMovie = movieRepository.save(movie);

        // 3. Ellenőrzés (Then)
        assertThat(savedMovie.getId()).isNotNull();
        assertThat(savedMovie.getTitle()).isEqualTo("Interstellar");
        assertThat(savedMovie.getGenre()).isEqualTo("Sci-Fi");
    }
}