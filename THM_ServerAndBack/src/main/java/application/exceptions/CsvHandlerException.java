package application.exceptions;

/**
 * @author Noah Ruben
 * @created 27.03.2018
 *
 */
@SuppressWarnings("serial")
public class CsvHandlerException extends Exception{

	/**
	 * @param message
	 */
	public CsvHandlerException(String message){
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CsvHandlerException(String message, Throwable cause){
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CsvHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param cause
	 */
	public CsvHandlerException(Throwable cause){
		super(cause);
	}

}
