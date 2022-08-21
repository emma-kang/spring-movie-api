package com.ekang.demo.movieapi.service;

import com.ekang.demo.movieapi.model.MovieDto;
import com.ekang.demo.movieapi.repository.MovieRepository;
import com.ekang.demo.movieapi.entity.Movie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
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
        return movieRepository.findAllByTitleIsContaining(title);
    }

    @Transactional
    public Movie updateReactions(Integer id, Boolean isLike) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        MovieDto movieDto = MovieDto.createInstance(movie);

        movieDto.setLikeCount(isLike ? movieDto.getLikeCount()+1
                : (movieDto.getLikeCount() <= 0 ? 0 : movieDto.getLikeCount()-1));
        movieDto.setDislikeCount(isLike ? (movieDto.getDislikeCount() <= 0 ? 0 : movieDto.getDislikeCount()-1)
                : movieDto.getDislikeCount() +1);
        movie.updateMovie(movieDto);
        return movie;
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
