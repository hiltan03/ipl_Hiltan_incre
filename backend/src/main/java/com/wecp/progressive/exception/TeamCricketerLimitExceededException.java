package com.wecp.progressive.exception;

public class TeamCricketerLimitExceededException extends RuntimeException {
    public TeamCricketerLimitExceededException(String msg){
        super(msg);
    }
}