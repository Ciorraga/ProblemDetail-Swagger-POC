package com.pocsma.problemdetail.app.exception;

public class InternalServerErrorException extends RuntimeException {
    private static final long serialVersionUID = 6230224331680180374L;

	public InternalServerErrorException(String message) {
        super(message);
    }
}