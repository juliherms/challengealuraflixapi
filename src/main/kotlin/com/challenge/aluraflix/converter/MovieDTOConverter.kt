package com.challenge.aluraflix.converter

import com.challenge.aluraflix.domain.Movie
import com.challenge.aluraflix.dto.MovieDTO
import org.springframework.stereotype.Component


/**
 * This class responsible to implements MovieDTO to Movie
 */
@Component
class MovieDTOConverter: Mapper<MovieDTO, Movie> {

    override fun map(movieDTO: MovieDTO): Movie{
        return Movie(
            title = movieDTO.title,
            description =  movieDTO.description,
            url = movieDTO.url)
    }
}