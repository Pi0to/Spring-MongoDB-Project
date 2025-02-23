package dev.pioto.spring.mombo.project.controllers.exceptions;

public class StandartError extends RuntimeException {

    private Long timeStamp;
    private Integer Status;
    private String error;
    private String message;
    private String path;


    public StandartError(String message) {
        super(message);
    }

    public StandartError(Long timeStamp, Integer status, String error, String message, String path) {
        this.timeStamp = timeStamp;
        Status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
