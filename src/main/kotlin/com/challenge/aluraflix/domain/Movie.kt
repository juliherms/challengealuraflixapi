package com.challenge.aluraflix.domain

import javax.persistence.*

/**
 * this class responsible to represents movies
 */
@Entity(name = "tb_movie")
data class Movie (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:  Long? = null,
    val title:String = "",
    val description:String = "",
    val url:String = "",
    @Column(name = "id_category")
    val idCategory: Long? = null
) {
    override fun toString(): String {
        return "Movie(id=$id, title='$title', description='$description', url='$url', idCategory=$idCategory)"
    }

}