package tr.gov.egm.library.exceptions.service;

public class CRUDException extends Exception {

	private static final long serialVersionUID = 4404637182660443850L;

	public CRUDException(String mesaj, Throwable e) {
		super(mesaj, e);
	}
	
}