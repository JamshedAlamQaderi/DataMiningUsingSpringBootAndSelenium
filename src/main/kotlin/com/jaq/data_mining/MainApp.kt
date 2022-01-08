package com.jaq.data_mining

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class MainApp

fun main(args: Array<String>) {
    runApplication<MainApp>(*args)
}

@RestController
class HomeController {

    @GetMapping("", "/", "/**")
    fun getVueApp(): String {
        return "hello"
    }
}