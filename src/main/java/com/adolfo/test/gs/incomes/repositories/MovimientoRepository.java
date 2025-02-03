package com.adolfo.test.gs.incomes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adolfo.test.gs.incomes.entities.Empleado;
import com.adolfo.test.gs.incomes.entities.Movimiento;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {
    @Query("select m from Movimiento m where m.empleado=?1")
    List<Movimiento> findAllByIdEmpleado(Empleado empleado);
}
