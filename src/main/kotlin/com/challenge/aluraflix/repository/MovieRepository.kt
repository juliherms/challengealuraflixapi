package com.challenge.aluraflix.repository

import com.challenge.aluraflix.domain.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * This class repsonsible to acess movie domain
 */
@Repository
interface MovieRepository : JpaRepository<Movie, Long>