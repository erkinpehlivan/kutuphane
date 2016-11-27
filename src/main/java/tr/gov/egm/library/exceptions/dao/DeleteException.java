package tr.gov.egm.library.exceptions.dao;

import tr.gov.egm.library.exceptions.service.CRUDException;

public class DeleteException extends CRUDException {

	private static final long serialVersionUID = -8119624682710756920L;

	public DeleteException(String mesaj, Throwable e) {
		super(mesaj, e);
	}

}