package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.TipoOrganizacionDomain;
import uco.doo.rugrats.uconnect.dto.TipoOrganizacionDTO;
import uco.doo.rugrats.uconnect.entities.TipoOrganizacionEntity;

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
}
