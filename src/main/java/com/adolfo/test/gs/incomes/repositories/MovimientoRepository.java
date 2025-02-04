package com.adolfo.test.gs.incomes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adolfo.test.gs.incomes.entities.Movimiento;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {
}
