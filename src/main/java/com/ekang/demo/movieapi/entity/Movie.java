package com.ekang.demo.movieapi.entity;

import com.ekang.demo.movieapi.model.MovieDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
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

    @Column(length=4, name="release_year")
    private String releaseYear;

    @Column(length = 10)
    private String duration;

    @Column
    private Double rating;

    @Column(name="like_count")
    private Integer likeCount;

    @Column(name="dislike_count")
    private Integer dislikeCount;

    @CreatedDate
    @Column(updatable = false, name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    public static Movie createInstance(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.title = movieDto.getTitle();
        movie.description = movieDto.getDescription();
        movie.releaseYear = movieDto.getReleaseYear();
        movie.duration = movieDto.getDuration();
        movie.rating = movieDto.getRating();
        return movie;
    }

    public void updateMovie(MovieDto movieDto) {
        title = movieDto.getTitle();
        description = movieDto.getDescription();
        releaseYear = movieDto.getReleaseYear();
        rating = movieDto.getRating();
        likeCount = movieDto.getLikeCount();
        dislikeCount = movieDto.getDislikeCount();
    }

//    @PrePersist
//    public void prePersist() {
//        this.likeCount = this.likeCount == null ? 0 : this.likeCount;
//        this.dislikeCount = this.dislikeCount == null ? 0 : this.dislikeCount;
//    }

}
