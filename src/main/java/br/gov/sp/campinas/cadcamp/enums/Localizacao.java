package br.gov.sp.campinas.cadcamp.enums;

public enum Localizacao {

	URBANA(83L),
	RURAL(84L);

	private long code;
	
	private Localizacao(long code) {
		this.code = code;
	}
	
	public long getCode() {
		return code;
	}
}
