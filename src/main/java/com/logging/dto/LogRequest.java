package com.logging.dto;

public class LogRequest {

    private String username;
    private String message;
    private String action;

    public LogRequest(){}

    public LogRequest(String username, String message, String action){
        this.username = username;
        this.message = message;
        this.action = action;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getAction(){
        return action;
    }
    public void setAction(String action){
        this.action = action;
    }
}
