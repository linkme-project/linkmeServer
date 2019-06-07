package com.nakkunakku.linkme.util;

public class LinkMeException extends Exception{
    private static final long serialVersionUID = 1L;
    private String errorCode;
    
    public LinkMeException(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }

}
