package com.osfglobal.hybris.emarsys.services.exceptions;

public class EmarsysServiceException extends RuntimeException {
    public EmarsysServiceException(String message) {
        super(message);
    }

    public EmarsysServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmarsysServiceException(Throwable cause) {
        super(cause);
    }

    public EmarsysServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
