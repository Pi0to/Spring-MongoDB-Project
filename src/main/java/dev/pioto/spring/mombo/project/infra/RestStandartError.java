package dev.pioto.spring.mombo.project.infra;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class RestStandartError {

    private HttpStatus status;
    private String errorMessage;
    private Timestamp timestamp;

    public RestStandartError(HttpStatus status, String errorMessage, Timestamp timestamp) {
        this.status = status;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
