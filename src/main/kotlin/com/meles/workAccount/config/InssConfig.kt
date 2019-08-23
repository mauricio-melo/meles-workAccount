package com.meles.workAccount.config

import com.meles.workAccount.dto.TaxationDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Configuration
@ConfigurationProperties("taxations.inss")
class InssConfig{
    lateinit var values: List<TaxationDTO>
    lateinit var high: BigDecimal
}