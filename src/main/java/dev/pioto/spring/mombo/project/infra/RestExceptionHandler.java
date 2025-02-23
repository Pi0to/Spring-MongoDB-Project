package dev.pioto.spring.mombo.project.infra;

import dev.pioto.spring.mombo.project.services.exceptions.ObjNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ObjNotFoundException.class)
    private ResponseEntity<RestStandartError> objectNotFoundHandler(ObjNotFoundException e){

        RestStandartError threatResponse = new RestStandartError(HttpStatus.NOT_FOUND,
                e.getMessage(),
                new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }


}
