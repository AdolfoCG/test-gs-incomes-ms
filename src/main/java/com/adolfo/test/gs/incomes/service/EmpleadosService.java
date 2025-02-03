package com.adolfo.test.gs.incomes.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmpleadosService {
    public ResponseEntity<?> saldo(Long id);
    public ResponseEntity<?> history(Long id);
}
