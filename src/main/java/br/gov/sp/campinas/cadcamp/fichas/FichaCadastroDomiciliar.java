package br.gov.sp.campinas.cadcamp.fichas;

import java.util.ArrayList;
import java.util.List;

import br.gov.saude.esusab.ras.cadastrodomiciliar.CadastroDomiciliarThrift;
import br.gov.saude.esusab.ras.cadastrodomiciliar.CondicaoMoradiaThrift;
import br.gov.sp.campinas.cadcamp.dtos.CadastroDomiciliarDTO;
import br.gov.sp.campinas.cadcamp.enums.TipoImovel;

public class FichaCadastroDomiciliar {

	private CadastroDomiciliarThrift cadDomThft;
	private CondicaoMoradiaThrift condMoradiaThft;
	
	private CadastroDomiciliarDTO dto;

	public FichaCadastroDomiciliar(CadastroDomiciliarDTO dto) {
		this.dto = dto;
		
		cadDomThft = new CadastroDomiciliarThrift();
		cadDomThft.setTipoDeImovel(dto.getTipoImovel());
		cadDomThft.setAnimaisNoDomicilioIsSet(dto.getStAnimaisNoDomicilio() == 1 ? true : false);
		cadDomThft.setStatusTermoRecusa(dto.getStatusTermoRecusa() == 1 ? true : false);
		
		condMoradiaThft = new CondicaoMoradiaThrift();
	}

	public CadastroDomiciliarThrift novoCadastroDomiciliarThrift() {
		setAnimaisNoDomicilio();
		setCondicaoMoradia();
		
		return cadDomThft;
	}

	private void setAnimaisNoDomicilio() {
		long tipoImovel = cadDomThft.getTipoDeImovel();
		int stAnimaisNoDomicilio = dto.getStAnimaisNoDomicilio();
		int statusTermoRecusa = dto.getStatusTermoRecusa();

		// #1 animaisNoDomicilio / #6 quantosAnimaisNoDomicilio
		if (tipoImovel == TipoImovel.DOMICILIO.getCode() && stAnimaisNoDomicilio == 1 && statusTermoRecusa != 1) {
			int stGato = dto.getStGato();
			int stCachorro = dto.getStCachorro();
			int stPassaro = dto.getStPassaro();
			int stOutros = dto.getStOutros();

			List<Long> animaisNoDomicilio = new ArrayList<>();

			if (stGato == 1) {
				animaisNoDomicilio.add(128L);
			}
			if (stCachorro == 1) {
				animaisNoDomicilio.add(129L);
			}
			if (stPassaro == 1) {
				animaisNoDomicilio.add(130L);
			}
			if (stOutros == 1) {
				animaisNoDomicilio.add(132L);
			}

			cadDomThft.setAnimaisNoDomicilio(animaisNoDomicilio);

			int qtdAnimaisNodomicilio = dto.getQtdAnimaisNodomicilio();

			if (qtdAnimaisNodomicilio != 0 && qtdAnimaisNodomicilio >= animaisNoDomicilio.size()) {
				cadDomThft.setQuantosAnimaisNoDomicilio(Integer.toString(qtdAnimaisNodomicilio));
			}
		}
	}

	private void setCondicaoMoradia() {
		long tipoImovel = dto.getTipoImovel();
		int statusTermoRecusa = dto.getStatusTermoRecusa();
		
		// #2 condicaoMoradia
		if (tipoImovel != TipoImovel.COMERCIO.getCode() && tipoImovel != TipoImovel.TERRENO_BALDIO.getCode()
				&& tipoImovel != TipoImovel.PONTO_ESTRATEGICO.getCode() && tipoImovel != TipoImovel.ESCOLA.getCode()
				&& tipoImovel != TipoImovel.CRECHE.getCode()
				&& tipoImovel != TipoImovel.ESTABELECIMENTO_RELIGIOSO.getCode()
				&& tipoImovel != TipoImovel.OUTROS.getCode() && statusTermoRecusa != 1) {

			long situacaoMoradia = dto.getSituacaoMoradia();
			condMoradiaThft.setSituacaoMoradiaPosseTerra(situacaoMoradia);

			cadDomThft.setCondicaoMoradia(condMoradiaThft);
		}
	}
}
