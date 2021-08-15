package com.challenge.aluraflix.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * this class responsible to represents categories
 */
@Entity(name = "tb_category")
data class Category (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:  Long? = null,
    val title:String = "",
    val color:String = "",
){
    override fun toString(): String {
        return "Category(id=$id, title='$title', color='$color')"
    }
}

