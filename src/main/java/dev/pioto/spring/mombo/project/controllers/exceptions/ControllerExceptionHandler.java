package dev.pioto.spring.mombo.project.controllers.exceptions;


import dev.pioto.spring.mombo.project.services.exceptions.ObjNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends RuntimeException {

    @ExceptionHandler(ObjNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err = new StandartError(System.currentTimeMillis(),
                status.value(),
                "Não Encontrado",
                e.getMessage(),
                request.getRequestURI());


        return ResponseEntity.status(status).body(err);
    }


}
