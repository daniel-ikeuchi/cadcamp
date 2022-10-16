package br.gov.sp.campinas.cadcamp.enums;

public enum TipoImovel {

	DOMICILIO(1L),
	COMERCIO(2L),
	TERRENO_BALDIO(3L),
	PONTO_ESTRATEGICO(4L),
	ESCOLA(5L),
	CRECHE(6L),
	ABRIGO(7L),
	INSTITUICAO_PERMANENCIA(8L),
	UNIDADE_PRISIONAL(9L),
	UNIDADE_SOCIO_EDUCATIVA(10L),
	DELEGACIA(11L),
	ESTABELECIMENTO_RELIGIOSO(12L),
	OUTROS(99L);

	private long code;
	
	private TipoImovel(long code) {
		this.code = code;
	}
	
	public long getCode() {
		return code;
	}
}
