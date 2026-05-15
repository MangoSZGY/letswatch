package hu.letswatch;

import hu.letswatch.controller.MovieController;
import hu.letswatch.model.Movie;
import hu.letswatch.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** Movie Controller unit tests for let$watch. */
@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean // @MockBean HELYETT
    private MovieRepository movieRepository;

    @Test
    public void testGetMovies() throws Exception {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setGenre("Sci-Fi");

        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie));

        mockMvc.perform(get("/api/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Inception"));
    }
}