package com.example.prub.Service

import com.example.prub.Model.CanchaView
import com.example.prub.Model.HoraView
import com.example.prub.Model.Jugador
import com.example.prub.Repository.CanchaViewRepository
import com.example.prub.Repository.HoraViewRepository
import com.example.prub.Repository.JugadorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class JugadorService {
    @Autowired
    lateinit var jugadorRepository: JugadorRepository

    @Autowired
    lateinit var horaViewRepository: HoraViewRepository

    @Autowired
    lateinit var canchaViewRepository: CanchaViewRepository

    fun list ():List<Jugador>{
        return jugadorRepository.findAll()
    }
    fun getByid (id:Long?): Jugador? {
        return jugadorRepository.findById(id)
    }

    fun listHoraView (): List<HoraView>{
        return horaViewRepository.findAll()
    }

    fun listCanchaView (): List<CanchaView>{
        return canchaViewRepository.findAll()
    }

    fun save ( jugador: Jugador):Jugador{
        try {
            jugador.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")
            jugador.hora?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")
            jugador.cancha?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")


        }
        catch (ex:Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
        return jugadorRepository.save(jugador)
    }


}