package com.pocsma.problemdetail.app.exception;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 2509149271511102225L;

	public NotFoundException(String message) {
        super(message);
    }
}