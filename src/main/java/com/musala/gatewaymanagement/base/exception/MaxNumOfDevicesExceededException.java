package com.musala.gatewaymanagement.base.exception;

public class MaxNumOfDevicesExceededException extends RuntimeException {
    private String message;

    public MaxNumOfDevicesExceededException(String message) {
        super(message);
        this.message = message;
    }

    public MaxNumOfDevicesExceededException() {
    }
}
