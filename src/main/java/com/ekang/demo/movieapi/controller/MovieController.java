package com.ekang.demo.movieapi.controller;

import com.ekang.demo.movieapi.model.MovieDto;
import com.ekang.demo.movieapi.service.MovieService;
import com.ekang.demo.movieapi.util.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@Slf4j
@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final MessageUtils messageUtils;

    @GetMapping("/all")
    public ResponseEntity<?> getAllMovies() {
        try {
            return ResponseEntity.ok(movieService.getAllMovies());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    // need to fix
    @GetMapping("/search")
    public ResponseEntity<?> getMovieByTitle(@RequestParam String title) {
        try {
            return ResponseEntity.ok(movieService.getMovieByTitle(title));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(movieService.getMovieById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/new-movie")
    public ResponseEntity<?> addNewMovie(@RequestBody MovieDto movieDto) {
        try {
            return ResponseEntity.ok(movieService.addNewMovie(movieDto));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping ("/update-movie")
    public ResponseEntity<?> updateMovie(@RequestBody MovieDto movieDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(messageUtils.get("server.binding.common.error"));
        }
        try {
            movieService.updateMovie(movieDto);
            return ResponseEntity.ok().body(messageUtils.get("server.response.success"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id) {
        try {
             Boolean result = movieService.deleteMovie(id);
             if (result) return ResponseEntity.ok().body(messageUtils.get("server.response.success"));
             return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
