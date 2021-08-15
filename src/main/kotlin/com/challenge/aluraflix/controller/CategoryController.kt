package com.challenge.aluraflix.controller

import com.challenge.aluraflix.domain.Category
import com.challenge.aluraflix.domain.Movie
import com.challenge.aluraflix.dto.CategoryDTO
import com.challenge.aluraflix.exceptions.MovieNotFoundException
import com.challenge.aluraflix.service.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * This class responsible to provide categories endpoint
 */
@RestController
@RequestMapping(value = ["/categories"])
class CategoryController  (val categoryService: CategoryService) {

    /**
     * create categories
     */
    @PostMapping()
    fun create (@RequestBody categoryDTO: CategoryDTO): ResponseEntity<Unit> {
        categoryService.create(categoryDTO)
        return ResponseEntity(Unit, HttpStatus.CREATED)
    }

    /**
     * Find categories by id
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Category?> {
        var category = categoryService.getById(id) ?: throw MovieNotFoundException("category ${id} not found")
        return ResponseEntity(category,HttpStatus.OK)
    }

    @GetMapping("/{id}/movies/")
    fun getMoviesByCategory(@PathVariable id: Long): ResponseEntity<List<Movie>> {

        var list = categoryService.getMoviesByCategory(id)
        val status = if(list.isEmpty()) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(list,status)
    }

    /**
     * delete categories
     */
    fun delete (@PathVariable id: Long): ResponseEntity<Unit> {

        var status = HttpStatus.NOT_FOUND

        if(categoryService.getById(id) != null){
            status = HttpStatus.ACCEPTED
            this.categoryService.remove(id)
        }

        return ResponseEntity(Unit,status)
    }

    /**
     * Update categories
     */
    @PutMapping("/{id}")
    fun update (@PathVariable id: Long, @RequestBody category: Category): ResponseEntity<Unit> {

        var status = HttpStatus.NOT_FOUND

        if(categoryService.getById(id) != null){
            categoryService.update(id,category)
            status = HttpStatus.ACCEPTED
        }

        return ResponseEntity(Unit,status)
    }

    /**
     * List all paginated categories
     */
    @GetMapping("")
    fun getAll(@RequestParam(required = false, defaultValue = "0") start: Int,
               @RequestParam(required = false, defaultValue = "10") size: Int ): ResponseEntity<List<Category>> {

        val list = this.categoryService.getAll(start,size)
        val status = if(list.isEmpty()) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(list,status)
    }

}
