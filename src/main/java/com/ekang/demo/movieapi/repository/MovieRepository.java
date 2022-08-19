package com.ekang.demo.movieapi.repository;

import com.ekang.demo.movieapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findAllByOrderById();

    @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
    List<Movie> findByTitleKeyword(String title);

}
