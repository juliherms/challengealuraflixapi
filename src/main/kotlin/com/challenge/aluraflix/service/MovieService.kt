package com.challenge.aluraflix.service

import com.challenge.aluraflix.converter.MovieDTOConverter
import com.challenge.aluraflix.domain.Movie
import com.challenge.aluraflix.dto.MovieDTO
import com.challenge.aluraflix.repository.CategoryRepository
import com.challenge.aluraflix.repository.MovieRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

/**
 * This class responsible to implements business logic from movies
 */
@Service
class MovieService(
    val movieRepository: MovieRepository,
    val categoryRepository: CategoryRepository,
    val movieDTOConverter: MovieDTOConverter
    ) {

    /**
     * Method responsible to create movie
     */
    fun create(movieDTO: MovieDTO) {
        val movie: Movie = movieDTOConverter.map(movieDTO);

        //business role - when category for movie is null...apply free category
        if(movie.category == null){
            movie.category = categoryRepository.findById(1L).get();
        }

        this.movieRepository.save(movie);
    }

    /**
     * Method responsible to list all movies
     */
    fun getAll(start: Int, size: Int): List<Movie> {
        val pages: Pageable = PageRequest.of(start,size, Sort.by("title").ascending())
        return this.movieRepository.findAll(pages).toList()
    }

    /**
     * Method responsible to get movie by id
     */
    fun getById(id: Long): Movie? = this.movieRepository.findById(id).orElseGet(null)

    /**
     * Method responsible to remove movie
     */
    fun remove (id: Long) = this.movieRepository.deleteById(id)

    /**
     * Method responsible to update movie
     */
    fun update(id: Long, movie:Movie) = this.movieRepository.save(movie)
}


