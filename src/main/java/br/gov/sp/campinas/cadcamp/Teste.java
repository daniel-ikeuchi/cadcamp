package br.gov.sp.campinas.cadcamp;

import br.gov.saude.esusab.ras.cadastrodomiciliar.CadastroDomiciliarThrift;
import br.gov.sp.campinas.cadcamp.dtos.CadastroDomiciliarDTO;
import br.gov.sp.campinas.cadcamp.fichas.FichaCadastroDomiciliar;

public class Teste {

	public static void main(String[] args) {
		CadastroDomiciliarDTO cadDomDto = new CadastroDomiciliarDTO();
		cadDomDto.setTipoImovel("DOMICILIO");
		cadDomDto.setStAnimaisNoDomicilio(1);
		cadDomDto.setStatusTermoRecusa(0);
		cadDomDto.setStGato(0);
		cadDomDto.setStCachorro(0);
		cadDomDto.setStPassaro(0);
		cadDomDto.setStOutros(1);
		cadDomDto.setQtdAnimaisNodomicilio(1);
		
		CadastroDomiciliarThrift cadastroDomiciliarThrift = new FichaCadastroDomiciliar().cadastroDomiciliarThrift(cadDomDto);
		
		System.out.println("Teste Ok");
	}

}
