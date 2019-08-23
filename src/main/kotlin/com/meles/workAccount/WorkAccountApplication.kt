package com.meles.workAccount

import com.meles.workAccount.config.InssConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableConfigurationProperties(InssConfig::class)
class WorkAccountApplication

fun main(args: Array<String>) {
	runApplication<WorkAccountApplication>(*args)
}
