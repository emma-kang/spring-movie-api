package com.ekang.demo.movieapi.repository;

import com.ekang.demo.movieapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findAllByOrderById();

    List<Movie> findAllByTitleIsContaining(String title);
}
