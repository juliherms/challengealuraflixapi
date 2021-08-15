package com.challenge.aluraflix.repository

import com.challenge.aluraflix.domain.Category
import com.challenge.aluraflix.domain.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * This class responsible to access movie domain
 */
@Repository
interface MovieRepository : JpaRepository<Movie, Long> {

    fun findByCategory(category:Category): List<Movie>

}