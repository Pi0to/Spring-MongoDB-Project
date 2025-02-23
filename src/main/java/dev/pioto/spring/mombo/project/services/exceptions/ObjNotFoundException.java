package dev.pioto.spring.mombo.project.services.exceptions;

public class ObjNotFoundException extends RuntimeException{


    public ObjNotFoundException() {
        super("object not found");
    }

    public ObjNotFoundException(String message) {
        super(message);
    }
}
