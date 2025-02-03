package com.adolfo.test.gs.incomes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class IncomesDto {
    @NotNull
    @Positive
    private Float monto;

    @NotNull
    @NotBlank
    private String empleado;
}
