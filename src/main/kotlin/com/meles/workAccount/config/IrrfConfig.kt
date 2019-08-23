package com.meles.workAccount.config

import com.meles.workAccount.dto.TaxationDTO
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import java.math.BigDecimal

@Configuration
@ConfigurationProperties("taxations.irrf")
class IrrfConfig {
    lateinit var low: BigDecimal
    lateinit var values: List<TaxationDTO>
    lateinit var high: BigDecimal
    lateinit var subtract: BigDecimal
}