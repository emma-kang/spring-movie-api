package com.ekang.demo.movieapi.service;

import com.ekang.demo.movieapi.model.MovieDto;
import com.ekang.demo.movieapi.repository.MovieRepository;
import com.ekang.demo.movieapi.entity.Movie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAllByOrderById();
    }

    public Optional<Movie> getMovieById(Integer id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getMovieByTitle(String title) {
        return movieRepository.findByTitleKeyword(title);
    }

    @Transactional
    public Integer addNewMovie(MovieDto movieDto) {
        Movie movie = Movie.createInstance(movieDto);
        Movie createdMovie = movieRepository.save(movie);
        return createdMovie.getId();
    }

    @Transactional
    public void updateMovie(MovieDto movieDto) {
        Movie movie = movieRepository.findById(movieDto.getId()).orElseThrow(null);
        movie.updateMovie(movieDto);
    }

    @Transactional
    public Boolean deleteMovie(Integer id) {
        movieRepository.deleteById(id);
        return true;
    }
}
