package com.osfglobal.hybris.emarsys.services.exceptions;

public class EmarsysSubscriptionDoesntExistException extends EmarsysServiceException {
    public EmarsysSubscriptionDoesntExistException(String message) {
        super(message);
    }

    public EmarsysSubscriptionDoesntExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmarsysSubscriptionDoesntExistException(Throwable cause) {
        super(cause);
    }

    public EmarsysSubscriptionDoesntExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
