package com.osfglobal.hybris.emarsys.services.exceptions;

public class EmarsysClientAlreadySubscribedException extends EmarsysServiceException {
    public EmarsysClientAlreadySubscribedException(String message) {
        super(message);
    }

    public EmarsysClientAlreadySubscribedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmarsysClientAlreadySubscribedException(Throwable cause) {
        super(cause);
    }

    public EmarsysClientAlreadySubscribedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
