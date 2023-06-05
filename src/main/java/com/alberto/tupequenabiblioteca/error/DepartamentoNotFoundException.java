package com.alberto.tupequenabiblioteca.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartamentoNotFoundException extends RuntimeException {

  public DepartamentoNotFoundException(Long id) {
    super("No se puede encontrar el departamento con el ID: " + id);
  }

}
