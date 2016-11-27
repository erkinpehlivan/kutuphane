package tr.gov.egm.library.exceptions.dao;

import tr.gov.egm.library.exceptions.service.CRUDException;

public class CreateException extends CRUDException {

	private static final long serialVersionUID = 8747351691613656663L;

	public CreateException(String mesaj, Throwable e) {
		super(mesaj, e);
	}

}