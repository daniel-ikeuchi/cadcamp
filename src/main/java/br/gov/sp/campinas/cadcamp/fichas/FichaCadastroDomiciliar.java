package br.gov.sp.campinas.cadcamp.fichas;

import java.util.ArrayList;
import java.util.List;

import br.gov.saude.esusab.ras.cadastrodomiciliar.CadastroDomiciliarThrift;
import br.gov.sp.campinas.cadcamp.dtos.CadastroDomiciliarDTO;
import br.gov.sp.campinas.cadcamp.enums.TipoImovel;

public class FichaCadastroDomiciliar {

	private CadastroDomiciliarThrift cadDomThft;

	public FichaCadastroDomiciliar() {
		cadDomThft = new CadastroDomiciliarThrift();
	}

	public CadastroDomiciliarThrift cadastroDomiciliarThrift(CadastroDomiciliarDTO dto) {
		setAnimaisNoDomicilio(dto);
		return cadDomThft;
	}

	private void setAnimaisNoDomicilio(CadastroDomiciliarDTO dto) {
		String tipoImovel = dto.getTipoImovel();
		int stAnimaisNoDomicilio = dto.getStAnimaisNoDomicilio();
		int statusTermoRecusa = dto.getStatusTermoRecusa();

		// #1 animaisNoDomicilio / #6 quantosAnimaisNoDomicilio
		if (tipoImovel == TipoImovel.DOMICILIO.toString() && stAnimaisNoDomicilio == 1 && statusTermoRecusa != 1) {
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

}
