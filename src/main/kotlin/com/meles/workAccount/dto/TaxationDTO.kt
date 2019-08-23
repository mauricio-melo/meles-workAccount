package com.meles.workAccount.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY
import lombok.Builder
import java.math.BigDecimal

@Builder
@JsonInclude(NON_EMPTY)
class TaxationDTO{
    lateinit var salary: BigDecimal
    lateinit var percent: BigDecimal
    var subtract: BigDecimal? = BigDecimal.ZERO
}