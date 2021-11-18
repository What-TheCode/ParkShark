package com.example.parkshark.exceptions.handler;

import com.example.parkshark.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerAdvisor {
    private final Logger logger = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ExceptionHandler
    public void handleInvalidEmailException(InvalidEmailException exception, HttpServletResponse response) throws IOException{
        logger.error("Invalid Email given: " + exception.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler
    public void handleInvalidIdException(InvalidIdException exception, HttpServletResponse response) throws IOException{
        logger.error("Invalid Id given: " + exception.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler
    public void handleInvalidIdException(InvalidTelephoneException exception, HttpServletResponse response) throws IOException{
        logger.error("Invalid Telephone given: " + exception.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler
    public void handleMemberDoesNotExistException(MemberDoesNotExistException exception, HttpServletResponse response) throws IOException{
        logger.error("Member does not exist: " + exception.getMessage());
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler
    public void handleMembershipDoesNotExistException(MembershipDoesNotExistException exception, HttpServletResponse response) throws IOException{
        logger.error("Membership does not exist: " + exception.getMessage());
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler
    public void handleParkinglotDoesNotExistException(ParkinglotDoesNotExistException exception, HttpServletResponse response) throws IOException{
        logger.error("Parkinglot does not exist: "+ exception.getMessage());
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler
    public void handlePersonDoesNotExistException(PersonDoesNotExistException exception, HttpServletResponse response) throws IOException{
        logger.error("Person does not exist: "+ exception.getMessage());
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

}
