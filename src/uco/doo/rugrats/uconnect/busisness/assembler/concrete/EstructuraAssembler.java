package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.EstructuraDomain;
import uco.doo.rugrats.uconnect.dto.EstructuraDTO;
import uco.doo.rugrats.uconnect.entities.EstructuraEntity;
import uco.doo.rugrats.uconnect.utils.UtilObject;

import java.util.List;

public final class EstructuraAssembler implements Assembler<EstructuraDomain, EstructuraDTO, EstructuraEntity> {
	public static final EstructuraAssembler INSTANCE = new EstructuraAssembler();

	public static EstructuraAssembler getInstance() {
		return INSTANCE;
	}

	private EstructuraAssembler() {
		super();
	}

	@Override
	public EstructuraDTO toDTOFromDomain(EstructuraDomain domain) {
		return EstructuraDTO.create().setIdentificador(domain.getIdentificador())
				.setEstructuraPadre(!UtilObject.isNull(domain.getEstructuraPadre())
						? EstructuraAssembler.getInstance().toDTOFromDomain(domain.getEstructuraPadre())
						: null)
				.setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()))
				.setNombre(domain.getNombre())
				.setOrganizacion(OrganizacionAssembler.getInstance().toDTOFromDomain(domain.getOrganizacion()))
				.setTienePadre(domain.isTienePadre());
	}

	@Override
	public EstructuraDomain toDomainFromDTO(EstructuraDTO dto) {
		return new EstructuraDomain(dto.getIdentificador(),
				OrganizacionAssembler.getInstance().toDomainFromDTO(dto.getOrganizacion()),
				!UtilObject.isNull(dto.getEstructuraPadre())
						? EstructuraAssembler.getInstance().toDomainFromDTO(dto.getEstructuraPadre())
						: null,
				dto.getNombre(), EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()), dto.isTienePadre());
	}

	@Override
	public EstructuraEntity toEntityFromDomain(EstructuraDomain domain) {
		return new EstructuraEntity(domain.getIdentificador(),
				OrganizacionAssembler.getInstance().toEntityFromDomain(domain.getOrganizacion()),
				!UtilObject.isNull(domain.getEstructuraPadre())
						? EstructuraAssembler.getInstance().toEntityFromDomain(domain.getEstructuraPadre())
						: null,
				domain.getNombre(), EstadoAssembler.INSTANCE.toEntityFromDomain(domain.getEstado()),
				domain.isTienePadre());
	}

	@Override
	public EstructuraDomain toDomainFromEntity(EstructuraEntity entity) {
		return new EstructuraDomain(entity.getIdentificador(),
				OrganizacionAssembler.getInstance().toDomainFromEntity(entity.getOrganizacion()),
				!UtilObject.isNull(entity.getEstructuraPadre())
						? EstructuraAssembler.getInstance().toDomainFromEntity(entity.getEstructuraPadre())
						: null,
				entity.getNombre(), EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()),
				entity.isTienePadre());
	}

	@Override
	public List<EstructuraDomain> toDomainFromEntityList(List<EstructuraEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();

	}

	@Override
	public List<EstructuraDTO> toDTOFromDomainList(List<EstructuraDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}
}
