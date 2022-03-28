package com.example.friend.friend.Response;

public class Response {
    private String message;
    private Boolean status;

    public Response() {
    }

    public Response(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
