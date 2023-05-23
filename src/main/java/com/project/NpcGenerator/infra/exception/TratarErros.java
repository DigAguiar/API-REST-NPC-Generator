package com.project.NpcGenerator.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratarErros {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity tratarDuplicidade() {
        return ResponseEntity.badRequest().body("Nome já existe");
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity tratarVariavelINula () {
        return ResponseEntity.badRequest().body("Digite um ID valido");
    }

}
