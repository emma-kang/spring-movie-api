package com.ekang.demo.movieapi.model;

import com.ekang.demo.movieapi.entity.Movie;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieDto {
    private Integer id;

    @NotEmpty
    private String title;
    private String description;
    private String release_year;
    private String duration;
    private Double rating;

    public static MovieDto createInstance(Movie movie) {
        MovieDto movieDto = new MovieDto();
        if (movie == null)
            return movieDto;

        movieDto.id = movie.getId();
        movieDto.title = movie.getTitle();
        movieDto.description = movie.getDescription();
        movieDto.release_year = movie.getRelease_year();
        movieDto.duration = movie.getDuration();
        movieDto.rating = movie.getRating();

        return movieDto;
    }
}
