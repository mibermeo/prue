package com.example.prub.Repository

import com.example.prub.Model.Jugador
import org.springframework.data.jpa.repository.JpaRepository

interface JugadorRepository: JpaRepository<Jugador, Long>{
    fun findById(id: Long?): Jugador
}