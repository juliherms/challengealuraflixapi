package com.challenge.aluraflix.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * this class responsible to represents movies
 */
@Entity(name = "tb_movie")
data class Movie (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long =0L,
    val title:String = "",
    val description:String = "",
    val url:String = ""
)