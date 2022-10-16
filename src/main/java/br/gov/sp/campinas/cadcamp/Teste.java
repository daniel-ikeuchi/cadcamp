package br.gov.sp.campinas.cadcamp;

import br.gov.saude.esusab.ras.cadastrodomiciliar.CadastroDomiciliarThrift;
import br.gov.sp.campinas.cadcamp.dtos.CadastroDomiciliarDTO;
import br.gov.sp.campinas.cadcamp.fichas.FichaCadastroDomiciliar;

public class Teste {

	public static void main(String[] args) {
		
		CadastroDomiciliarDTO cadDomDto = new CadastroDomiciliarDTO();
		cadDomDto.setTipoImovel(1);
		cadDomDto.setStAnimaisNoDomicilio(1);
		cadDomDto.setStatusTermoRecusa(0);
		cadDomDto.setStGato(0);
		cadDomDto.setStCachorro(0);
		cadDomDto.setStPassaro(0);
		cadDomDto.setStOutros(1);
		cadDomDto.setQtdAnimaisNodomicilio(1);
		
		cadDomDto.setSituacaoMoradia(Long.parseLong("77"));
		cadDomDto.setAbastecimentoAgua(Long.parseLong("117"));
		cadDomDto.setDestinoLixo(Long.parseLong("93"));
		cadDomDto.setEscoamentoBanheiro(Long.parseLong("122"));
		cadDomDto.setLocalizacao(Long.parseLong("83"));
		cadDomDto.setMaterialPredominante(Long.parseLong("109"));
		cadDomDto.setNuComodos(Integer.toString(0));
		
		FichaCadastroDomiciliar ficha = new FichaCadastroDomiciliar(cadDomDto);
		CadastroDomiciliarThrift cadastroDomiciliarThrift = ficha.novoCadastroDomiciliarThrift();
		
		System.out.println("Teste Ok");
	}

}
