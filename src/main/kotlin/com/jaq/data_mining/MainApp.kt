package com.jaq.data_mining

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DataMiningUsingSpringAndSeleniumApplication

fun main(args: Array<String>) {
	runApplication<DataMiningUsingSpringAndSeleniumApplication>(*args)
}

@RestController
class Mining{

}