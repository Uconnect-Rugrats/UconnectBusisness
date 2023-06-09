package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.PublicacionDomain;
import uco.doo.rugrats.uconnect.dto.PublicacionDTO;
import uco.doo.rugrats.uconnect.entities.PublicacionEntity;

import java.util.List;

public final class PublicacionAssembler implements Assembler<PublicacionDomain, PublicacionDTO, PublicacionEntity> {
	public static final PublicacionAssembler INSTANCE = new PublicacionAssembler();

	public static PublicacionAssembler getInstance() {
		return INSTANCE;
	}

	private PublicacionAssembler() {
		super();
	}

	@Override
	public PublicacionDTO toDTOFromDomain(PublicacionDomain domain) {
		return PublicacionDTO.create().setIdentificador(domain.getIdentificador()).setContenido(domain.getContenido())
				.setTitulo(domain.getTitulo())
				.setAutor(ParticipanteGrupoAssembler.getInstance().toDTOFromDomain(domain.getAutor()))
				.setFechaPublicacion(domain.getFechaPublicacion())
				.setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setEstaEstadoRealActivo(domain.isEstaEstadoRealActivo());
	}

	@Override
	public PublicacionDomain toDomainFromDTO(PublicacionDTO dto) {
		return new PublicacionDomain(dto.getIdentificador(),
				ParticipanteGrupoAssembler.getInstance().toDomainFromDTO(dto.getAutor()), dto.getFechaPublicacion(),
				dto.getTitulo(), dto.getContenido(), EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()),dto.isEstaEstadoRealActivo());
	}

	@Override
	public PublicacionEntity toEntityFromDomain(PublicacionDomain domain) {
		return new PublicacionEntity(domain.getIdentificador(),
				ParticipanteGrupoAssembler.getInstance().toEntityFromDomain(domain.getAutor()),
				domain.getFechaPublicacion(), domain.getTitulo(), domain.getContenido(),
				EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()),domain.isEstaEstadoRealActivo());
	}

	@Override
	public PublicacionDomain toDomainFromEntity(PublicacionEntity entity) {
		return new PublicacionDomain(entity.getIdentificador(),
				ParticipanteGrupoAssembler.getInstance().toDomainFromEntity(entity.getAutor()),
				entity.getFechaPublicacion(), entity.getTitulo(), entity.getContenido(),
				EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()),entity.isEstaEstadoRealActivo());
	}

	@Override
	public List<PublicacionDomain> toDomainFromEntityList(List<PublicacionEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();

	}

	@Override
	public List<PublicacionDTO> toDTOFromDomainList(List<PublicacionDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}
}
