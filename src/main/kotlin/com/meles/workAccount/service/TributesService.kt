package com.meles.workAccount.service

import com.meles.workAccount.config.InssConfig
import com.meles.workAccount.config.IrrfConfig
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
@RequiredArgsConstructor
class TributesService(private val inssConfig: InssConfig,
                      private val irrfConfig: IrrfConfig) {

    fun calculateInss(salary: BigDecimal): BigDecimal = this.inssConfig.values.stream()
            .filter {inss -> salary <= inss.salary }
            .map {inss -> salary.multiply(inss.percent).setScale(2, RoundingMode.HALF_EVEN) }.findFirst()
            .orElseGet {this.inssConfig.high.setScale(2, RoundingMode.HALF_EVEN) }

    fun calculateIrrf(salary: BigDecimal): BigDecimal {
        return if (salary >= this.irrfConfig.low) {
            this.irrfConfig.values.stream()
                    .filter {irrf -> salary <= irrf.salary }
                    .map {irrf -> salary.multiply(irrf.percent).subtract(irrf.subtract).setScale(2, BigDecimal.ROUND_HALF_EVEN) }.findFirst()
                    .orElseGet {salary.multiply(this.irrfConfig.high).subtract(this.irrfConfig.subtract).setScale(2, BigDecimal.ROUND_HALF_EVEN)}
        } else {
            BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_EVEN)
        }
    }
}