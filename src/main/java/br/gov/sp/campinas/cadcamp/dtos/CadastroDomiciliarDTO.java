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

	private String tipoImovel;
	private int stAnimaisNoDomicilio;
	private int statusTermoRecusa;
	private int stGato;
	private int stCachorro;
	private int stPassaro;
	private int stOutros;
	private int qtdAnimaisNodomicilio;
	
}
