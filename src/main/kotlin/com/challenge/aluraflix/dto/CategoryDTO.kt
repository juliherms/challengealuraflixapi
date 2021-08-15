package com.challenge.aluraflix.dto

import javax.validation.constraints.NotEmpty

/**
 * This class responsible to transfer object data
 */
data class CategoryDTO (

    val id: Long? = null,
    @get:NotEmpty(message = "title is not empty")
    val title:String,
    @get:NotEmpty(message = "color is not empty")
    val color:String
)
