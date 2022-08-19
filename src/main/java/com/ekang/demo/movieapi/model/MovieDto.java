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
    private String releaseYear;
    private String duration;
    private Double rating;
    private Integer likeCount;
    private Integer dislikeCount;

    public static MovieDto createInstance(Movie movie) {
        MovieDto movieDto = new MovieDto();
        if (movie == null)
            return movieDto;

        movieDto.id = movie.getId();
        movieDto.title = movie.getTitle();
        movieDto.description = movie.getDescription();
        movieDto.releaseYear = movie.getReleaseYear();
        movieDto.duration = movie.getDuration();
        movieDto.rating = movie.getRating();
        movieDto.likeCount = movie.getLikeCount();
        movieDto.dislikeCount = movie.getDislikeCount();

        return movieDto;
    }
}
