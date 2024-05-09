package com.pocsma.problemdetail.app.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pocsma.problemdetail.app.exception.BadRequestException;
import com.pocsma.problemdetail.app.exception.InternalServerErrorException;
import com.pocsma.problemdetail.app.exception.NotFoundException;
import com.pocsma.problemdetail.app.exception.UnauthorizedException;
import com.pocsma.problemdetail.app.model.ProblemDetail;

@ControllerAdvice
public class ProblemDetailExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ProblemDetail> handleBadRequestException(BadRequestException ex) {
        return createProblemDetailResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ProblemDetail> handleNotFoundException(NotFoundException ex) {
        return createProblemDetailResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ProblemDetail> handleUnauthorizedException(UnauthorizedException ex) {
        return createProblemDetailResponseEntity(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ProblemDetail> handleInternalServerErrorException(InternalServerErrorException ex) {
        return createProblemDetailResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleException(Exception ex) {
        return createProblemDetailResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ProblemDetail> createProblemDetailResponseEntity(String detail, HttpStatus status) {
        ProblemDetail problemDetail = ProblemDetail.builder()
        		.title(status.getReasonPhrase())
        		.detail(detail)
        		.status(status.value())
        		.build();

        return new ResponseEntity<>(problemDetail, status);
    }
}