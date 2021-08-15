package com.challenge.aluraflix.service

import com.challenge.aluraflix.converter.CategoryDTOConverter
import com.challenge.aluraflix.domain.Category
import com.challenge.aluraflix.dto.CategoryDTO
import com.challenge.aluraflix.repository.CategoryRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

/**
 * This class responsible to implements business logic from categories
 */
@Service
class CategoryService(
    val categoryRepository: CategoryRepository,
    val categoryDTOConverter: CategoryDTOConverter
    ) {

    /**
     * Method responsible to create category
     */
    fun create(categoryDTO: CategoryDTO) = this.categoryRepository.save(categoryDTOConverter.map(categoryDTO))

    /**
     * Method responsible to list all categories
     */
    fun getAll(start: Int, size: Int): List<Category> {
        val pages: Pageable = PageRequest.of(start,size, Sort.by("title").ascending())
        return this.categoryRepository.findAll(pages).toList()
    }

    /**
     * Method responsible to get category by id
     */
    fun getById(id: Long): Category? = this.categoryRepository.findById(id).orElseGet(null)

    /**
     * Method responsible to remove category
     */
    fun remove (id: Long) = this.categoryRepository.deleteById(id)

    /**
     * Method responsible to update category
     */
    fun update(id: Long, category: Category) = this.categoryRepository.save(category)

/*    fun getVideosCategorias(pageable: Pageable): Page<Category> {
        return agrupamentoVideosCategoriaRepository.findAll(paginacao)
    } */
}