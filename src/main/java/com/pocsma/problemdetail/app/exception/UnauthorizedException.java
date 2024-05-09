package com.pocsma.problemdetail.app.exception;

public class UnauthorizedException extends RuntimeException {
    private static final long serialVersionUID = -8852013604193930285L;

	public UnauthorizedException(String message) {
        super(message);
    }
}