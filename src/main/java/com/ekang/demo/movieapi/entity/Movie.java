package com.ekang.demo.movieapi.entity;

import com.ekang.demo.movieapi.model.MovieDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private String description;

    @Column(length=4)
    private String release_year;

    @Column(length = 10)
    private String duration;

    @Column
    private Double rating;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime create_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    public static Movie createInstance(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.title = movieDto.getTitle();
        movie.description = movieDto.getDescription();
        movie.release_year = movieDto.getRelease_year();
        movie.duration = movieDto.getDuration();
        movie.rating = movieDto.getRating();
        return movie;
    }

    public void updateMovie(MovieDto movieDto) {
        title = movieDto.getTitle();
        description = movieDto.getDescription();
        release_year = movieDto.getRelease_year();
        rating = movieDto.getRating();
    }

}
