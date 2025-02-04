package com.adolfo.test.gs.incomes.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adolfo.test.gs.incomes.dto.IncomesDto;
import com.adolfo.test.gs.incomes.entities.Empleado;
import com.adolfo.test.gs.incomes.entities.Movimiento;
import com.adolfo.test.gs.incomes.exception.RepositoryException;
import com.adolfo.test.gs.incomes.repositories.MovimientoRepository;
import com.adolfo.test.gs.incomes.service.IncomesService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class IncomesServiceImpl implements IncomesService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    @Transactional
    public ResponseEntity<?> newIncome(IncomesDto income) {
        Movimiento ingreso = new Movimiento();

        try {
            Empleado empleado = income.getEmpleado();
    
            ingreso.setTipoMovimiento(1);
            ingreso.setMonto(income.getMonto()); 
            ingreso.setFecha(new Date());
            ingreso.setEmpleado(empleado);
    
            return ResponseEntity.status(HttpStatus.CREATED).body(movimientoRepository.save(ingreso));
        } catch (RepositoryException e) {
            throw new RepositoryException("Error en base de datos: " + e);
        }
    }
}
