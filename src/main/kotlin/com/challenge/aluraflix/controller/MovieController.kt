package com.challenge.aluraflix.controller

import com.challenge.aluraflix.domain.Movie
import com.challenge.aluraflix.dto.MovieDTO
import com.challenge.aluraflix.exceptions.MovieNotFoundException
import com.challenge.aluraflix.repository.MovieRepository
import com.challenge.aluraflix.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * This class responsible to provide movies endpoint
 */
@RestController
@RequestMapping(value = ["/movies"])
class MovieController (val movieService: MovieService) {

    /**
     * create movies
     */
    @PostMapping()
    fun create (@RequestBody movieDTO: MovieDTO): ResponseEntity<Unit> {
        movieService.create(movieDTO)
        return ResponseEntity(Unit,HttpStatus.CREATED)
    }

    /**
     * Find movies by id
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Movie?> {
        var movie = movieService.getById(id) ?: throw MovieNotFoundException("movie ${id} not found")
        return ResponseEntity(movie,HttpStatus.OK)
    }

    /**
     * delete movies
     */
    fun delete (@PathVariable id: Long): ResponseEntity<Unit> {

        var status = HttpStatus.NOT_FOUND

        if(movieService.getById(id) != null){
            status = HttpStatus.ACCEPTED
            this.movieService.remove(id)
        }

        return ResponseEntity(Unit,status)
    }

    /**
     * Update movies
     */
    @PutMapping("/{id}")
    fun update (@PathVariable id: Long, @RequestBody movie: Movie): ResponseEntity<Unit> {

        var status = HttpStatus.NOT_FOUND

        if(movieService.getById(id) != null){
            movieService.update(id,movie)
            status = HttpStatus.ACCEPTED
        }

        return ResponseEntity(Unit,status)
    }

    /**
     * List all paginated movies
     */
    @GetMapping("")
    fun getAll(@RequestParam(required = false, defaultValue = "0") start: Int,
               @RequestParam(required = false, defaultValue = "10") size: Int ): ResponseEntity<List<Movie>> {

        val list = this.movieService.getAll(start,size)
        val status = if(list.isEmpty()) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(list,status)
    }

}