package com.justicehub.api.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2880369903368736913L;

	public UserAlreadyExistsException(String email) {
        super("Já existe um usuário com esse e-mail: " + email);
    }
}
