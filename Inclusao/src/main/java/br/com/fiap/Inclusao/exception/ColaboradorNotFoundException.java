package br.com.fiap.Inclusao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ColaboradorNotFoundException extends RuntimeException {
    public ColaboradorNotFoundException(Long id) {
        super("Colaborador com id " + id + " não encontrado");
    }
}