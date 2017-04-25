/**
 * Created by Heart_Bool on 2017/4/17.
 */
package com.feng.web.schedule.exception;

/***
 * Description: 
 *
 * @AUTHOR: HEART_BOOL
 * @EMAIL: 18908069164@163.com
 * @DATE: 2017/4/17 23:03
 */
public class ServiceException extends Throwable {
    private static final long serialVersionUID = 8624944628363400977L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable cause,
                            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
