package com.challenge.aluraflix.repository

import com.challenge.aluraflix.domain.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * This class responsible to access movie domain
 */
@Repository
interface CategoryRepository : JpaRepository<Category, Long>