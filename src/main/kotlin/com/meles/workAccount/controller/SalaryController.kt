package com.meles.workAccount.controller

import com.meles.workAccount.dto.SalaryResultDTO
import com.meles.workAccount.service.SalaryService
import lombok.RequiredArgsConstructor
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import javax.validation.Valid

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/salary")
class SalaryController(private val salaryService: SalaryService) {

    @GetMapping
    fun getSalary(@Valid @RequestParam(value = "salary") salary: BigDecimal): ResponseEntity<SalaryResultDTO> =
        ResponseEntity.ok(this.salaryService.calculateSalary(salary.setScale(2, BigDecimal.ROUND_HALF_EVEN)))
}