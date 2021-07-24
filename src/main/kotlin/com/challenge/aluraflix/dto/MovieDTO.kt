package com.challenge.aluraflix.dto

import javax.validation.constraints.NotEmpty;

/**
 * This class responsible to transfer object data
 */
data class MovieDTO (

    val id: Long? = null,
    @get:NotEmpty(message = "title is not empty")
    val title:String,
    @get:NotEmpty(message = "description is not empty")
    val description:String,
    @get:NotEmpty(message = "url is not empty")
    val url:String
)