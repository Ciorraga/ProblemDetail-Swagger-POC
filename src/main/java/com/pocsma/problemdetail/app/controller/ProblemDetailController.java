package com.pocsma.problemdetail.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocsma.problemdetail.app.exception.BadRequestException;
import com.pocsma.problemdetail.app.exception.InternalServerErrorException;
import com.pocsma.problemdetail.app.exception.NotFoundException;
import com.pocsma.problemdetail.app.exception.UnauthorizedException;

@RestController
public class ProblemDetailController {
	
	@GetMapping("/badRequest")
    public String badRequest() {
        throw new BadRequestException("Bad request exception");
    }

    @GetMapping("/notFound")
    public String notFound() {
        throw new NotFoundException("Not found exception");
    }

    @GetMapping("/unauthorized")
    public String unauthorized() {
        throw new UnauthorizedException("Unauthorized exception");
    }

    @GetMapping("/internalServerError")
    public String internalServerError() {
        throw new InternalServerErrorException("Internal server error exception");
    }
}
