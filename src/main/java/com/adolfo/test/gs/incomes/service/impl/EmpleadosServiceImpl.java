package com.adolfo.test.gs.incomes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adolfo.test.gs.incomes.entities.Empleado;
import com.adolfo.test.gs.incomes.entities.Movimiento;
import com.adolfo.test.gs.incomes.exception.NotFoundException;
import com.adolfo.test.gs.incomes.repositories.EmpleadoRepository;
import com.adolfo.test.gs.incomes.repositories.MovimientoRepository;
import com.adolfo.test.gs.incomes.service.EmpleadosService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EmpleadosServiceImpl implements EmpleadosService {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public ResponseEntity<?> saldo(Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);

        if (empleado.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(empleado.get().getSaldoActual());
        } else {
            throw new NotFoundException("¡El empleado no existe!");
        }
    }

    @Override
    public ResponseEntity<?> history(Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);

        if (!empleado.isPresent()) {
            throw new NotFoundException("¡El empleado no existe!");
        }

        List<Movimiento> movimientos = movimientoRepository.findAllByIdEmpleado(empleado.get());

        if (movimientos.isEmpty()) {
            throw new NotFoundException("No se encontraron movimientos");
        }

        return ResponseEntity.status(HttpStatus.OK).body(movimientos);
    }

}
