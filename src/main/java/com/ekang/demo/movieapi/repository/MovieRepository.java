package com.ekang.demo.movieapi.repository;

import com.ekang.demo.movieapi.entity.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findAllByOrderById();

//    @Query(value = "SELECT mv FROM Movie mv WHERE mv.title = :title")
    List<Movie> findAllByTitleContainingIgnoreCaseOrderById(String infix);
}
