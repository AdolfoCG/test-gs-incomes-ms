package com.adolfo.test.gs.incomes.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adolfo.test.gs.incomes.dto.IncomesDto;

@Service
public interface IncomesService {
    public ResponseEntity<?> newIncome(IncomesDto income);
}
