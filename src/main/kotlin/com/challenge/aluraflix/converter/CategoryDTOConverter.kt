package com.challenge.aluraflix.converter

import com.challenge.aluraflix.domain.Category
import com.challenge.aluraflix.dto.CategoryDTO
import org.springframework.stereotype.Component

/**
 * This class responsible to implements MovieDTO to Movie
 */
@Component
class CategoryDTOConverter: Mapper<CategoryDTO, Category> {

    override fun map(categoryDTO: CategoryDTO): Category {
        return Category(
            title = categoryDTO.title,
            color =  categoryDTO.color)
    }
}