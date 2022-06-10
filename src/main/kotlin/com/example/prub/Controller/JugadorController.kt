package com.example.prub.Controller

import com.example.prub.Model.CanchaView
import com.example.prub.Model.HoraView
import com.example.prub.Model.Jugador
import com.example.prub.Service.JugadorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/jug")
class JugadorController {
    @Autowired
    lateinit var jugadorService: JugadorService

    @GetMapping
    fun list():List<Jugador>

    {
        return jugadorService.list()
    }

    @GetMapping("frequency/hora")
    fun ListHoraView (): List<HoraView>? {
        return jugadorService.listHoraView()
    }

    @GetMapping("frequency/cancha")
    fun ListCanchaView (): List<CanchaView>? {
        return jugadorService.listCanchaView()
    }
    @PostMapping
    fun save(@RequestBody jugador: Jugador): Jugador {
        return jugadorService.save(jugador)
    }
}