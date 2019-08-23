package com.meles.workAccount.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY
import lombok.Builder
import java.math.BigDecimal

@Builder
@JsonInclude(NON_EMPTY)
data class TributeDTO(
        val name: String,
        val value: BigDecimal
)