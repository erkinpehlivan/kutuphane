package tr.gov.egm.library.exceptions.service;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 7641785265425252938L;

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}