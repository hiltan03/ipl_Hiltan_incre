package com.wecp.progressive.exception;

public class NoMatchesFoundException extends RuntimeException {
    public NoMatchesFoundException(String msg){
        super(msg);
    }
}