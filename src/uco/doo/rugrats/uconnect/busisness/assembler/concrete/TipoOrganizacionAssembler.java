package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.TipoOrganizacionDomain;
import uco.doo.rugrats.uconnect.dto.TipoOrganizacionDTO;
import uco.doo.rugrats.uconnect.entities.TipoOrganizacionEntity;

import java.util.List;

public final class TipoOrganizacionAssembler implements Assembler<TipoOrganizacionDomain, TipoOrganizacionDTO, TipoOrganizacionEntity> {
    public static final TipoOrganizacionAssembler INSTANCE = new TipoOrganizacionAssembler();
    public static TipoOrganizacionAssembler getInstance() { return INSTANCE; }
    private TipoOrganizacionAssembler(){
        super();
    }
    @Override
    public TipoOrganizacionDTO toDTOFromDomain(TipoOrganizacionDomain domain) {
        return TipoOrganizacionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoOrganizacionDomain toDomainFromDTO(TipoOrganizacionDTO dto) {
        return new TipoOrganizacionDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public TipoOrganizacionEntity toEntityFromDomain(TipoOrganizacionDomain domain) {
        return new TipoOrganizacionEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
    }

    @Override
    public TipoOrganizacionDomain toDomainFromEntity(TipoOrganizacionEntity entity) {
        return new TipoOrganizacionDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
    }

    @Override
    public List<TipoOrganizacionDomain> toDomainFromEntityList(List<TipoOrganizacionEntity> entityList) {
        return entityList.stream().map(this::toDomainFromEntity).toList();
    }

    @Override
    public List<TipoOrganizacionDTO> toDTOFromDomainList(List<TipoOrganizacionDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();    }
}
