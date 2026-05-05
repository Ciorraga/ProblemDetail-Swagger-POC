package com.pocsma.problemdetail.app.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pocsma.problemdetail.app.exception.BadRequestException;
import com.pocsma.problemdetail.app.exception.InternalServerErrorException;
import com.pocsma.problemdetail.app.exception.NotFoundException;
import com.pocsma.problemdetail.app.exception.UnauthorizedException;

@ControllerAdvice
public class ProblemDetailExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ProblemDetail handleBadRequestException(BadRequestException ex) {
        return createProblemDetail(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFoundException(NotFoundException ex) {
        return createProblemDetail(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ProblemDetail handleUnauthorizedException(UnauthorizedException ex) {
        return createProblemDetail(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ProblemDetail handleInternalServerErrorException(InternalServerErrorException ex) {
        return createProblemDetail(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception ex) {
        return createProblemDetail(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ProblemDetail createProblemDetail(String detail, HttpStatus status) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, detail);
        problemDetail.setTitle(status.getReasonPhrase());
        problemDetail.setType(null);
        return problemDetail;
    }
}
