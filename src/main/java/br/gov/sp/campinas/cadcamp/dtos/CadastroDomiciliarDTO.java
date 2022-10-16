package br.gov.sp.campinas.cadcamp.dtos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CadastroDomiciliarDTO {

	private long tipoImovel;
	private int stAnimaisNoDomicilio;
	private int statusTermoRecusa;
	private int stGato;
	private int stCachorro;
	private int stPassaro;
	private int stOutros;
	private int qtdAnimaisNodomicilio;
	private long situacaoMoradia;
	private long abastecimentoAgua;
	private long destinoLixo;
	private long escoamentoBanheiro;
	private long localizacao;
	private long materialPredominante;
	private String nuComodos;
	
}
