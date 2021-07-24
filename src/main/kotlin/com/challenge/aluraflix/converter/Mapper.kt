package com.challenge.aluraflix.converter

/**
 * Interface responsible to convert DTOs to Entity
 */
interface Mapper<T, U> {
    fun map(t: T): U
}