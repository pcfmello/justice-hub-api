package com.justicehub.api.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String email) {
        super("Já existe um usuário com esse e-mail: " + email);
    }
}
