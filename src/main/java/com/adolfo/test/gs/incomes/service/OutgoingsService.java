package com.adolfo.test.gs.incomes.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adolfo.test.gs.incomes.dto.OutgoingsDto;

@Service
public interface OutgoingsService {
    public ResponseEntity<?> newOutgoings(OutgoingsDto outgoing);
}
