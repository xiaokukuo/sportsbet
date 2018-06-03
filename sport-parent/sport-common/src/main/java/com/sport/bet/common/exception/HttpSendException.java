package com.sport.bet.common.exception;

public class HttpSendException extends Exception {

	private static final long serialVersionUID = 6995373263928714163L;
	
	public HttpSendException() {
        super();
    }
	
	public HttpSendException(String message) {
        super(message);
    }
	
	public HttpSendException(String message, Throwable cause) {
        super(message, cause);
    }
	 
	public HttpSendException(Throwable cause) {
        super(cause);
    }

}
