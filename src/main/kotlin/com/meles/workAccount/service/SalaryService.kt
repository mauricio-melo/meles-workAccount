package com.meles.workAccount.service

import com.meles.workAccount.constant.Tributes
import com.meles.workAccount.dto.SalaryResultDTO
import com.meles.workAccount.dto.TributeDTO
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
@RequiredArgsConstructor
class SalaryService(private val tributesService: TributesService) {

    fun calculateSalary(salary: BigDecimal): SalaryResultDTO {
        val inss = TributeDTO(Tributes.INSS, this.tributesService.calculateInss(salary))
        val irrf = TributeDTO(Tributes.IRRF, this.tributesService.calculateIrrf(salary.subtract(inss.value)))
        return SalaryResultDTO(salary, listOf(inss, irrf), this.calculateLiquidSalary(salary, listOf(inss.value, irrf.value), ArrayList()))
    }

    fun calculateLiquidSalary(salary: BigDecimal, discounts: List<BigDecimal>, additions: List<BigDecimal>): BigDecimal =
            salary.subtract(discounts.stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO))
                    .add(additions.stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO))
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN)
}