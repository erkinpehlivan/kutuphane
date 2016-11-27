package tr.gov.egm.library.exceptions.service;

import tr.gov.egm.library.exceptions.dao.CRUDException;

public class ReadException extends CRUDException {

	private static final long serialVersionUID = 8855014879775769386L;

	public ReadException(String mesaj, Throwable e) {
		super(mesaj, e);
	}

}