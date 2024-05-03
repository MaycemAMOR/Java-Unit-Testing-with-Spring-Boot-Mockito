package com.maytech.unittesting.unittesting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
// @ResponseStatus(code = HttpStatus.NOT_FOUND)  => pour bien spécifier le code de status NotFound '404
// de retour aprés chaque request quand la resource n'esiste pas
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}