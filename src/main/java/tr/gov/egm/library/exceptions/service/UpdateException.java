package tr.gov.egm.library.exceptions.service;

import tr.gov.egm.library.exceptions.dao.CRUDException;

public class UpdateException extends CRUDException {

	private static final long serialVersionUID = -3050915282109418937L;

	public UpdateException(String mesaj, Throwable e) {
		super(mesaj, e);
	}

}