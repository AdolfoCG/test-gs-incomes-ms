package com.adolfo.test.gs.incomes.dto;

import com.adolfo.test.gs.incomes.entities.Empleado;

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
    private Empleado empleado;
}
