package com.pocsma.problemdetail.app.exception;

public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 7932234140178286638L;

	public BadRequestException(String message) {
        super(message);
    }
}