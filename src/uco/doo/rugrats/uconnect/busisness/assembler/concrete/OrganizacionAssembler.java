package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.OrganizacionDomain;
import uco.doo.rugrats.uconnect.dto.OrganizacionDTO;
import uco.doo.rugrats.uconnect.entities.OrganizacionEntity;

import java.util.List;

public final class OrganizacionAssembler implements Assembler<OrganizacionDomain, OrganizacionDTO, OrganizacionEntity> {
    public static final OrganizacionAssembler INSTANCE = new OrganizacionAssembler();
    public static OrganizacionAssembler getInstance() { return INSTANCE; }
    private OrganizacionAssembler(){
        super();
    }
    @Override
    public OrganizacionDTO toDTOFromDomain(OrganizacionDomain domain) {
        return OrganizacionDTO.create().setIdentificador(domain.getIdentificador()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()))
                .setDescripcion(domain.getDescripcion()).setNombre(domain.getNombre()).setTipo(TipoOrganizacionAssembler.getInstance().toDTOFromDomain(domain.getTipo()));
    }

    @Override
    public OrganizacionDomain toDomainFromDTO(OrganizacionDTO dto) {
        return new OrganizacionDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion(),TipoOrganizacionAssembler.getInstance().toDomainFromDTO(dto.getTipo()),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public OrganizacionEntity toEntityFromDomain(OrganizacionDomain domain) {
        return new OrganizacionEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion(),TipoOrganizacionAssembler.getInstance().toEntityFromDomain(domain.getTipo()),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public OrganizacionDomain toDomainFromEntity(OrganizacionEntity entity) {
        return new OrganizacionDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion(),TipoOrganizacionAssembler.getInstance().toDomainFromEntity(entity.getTipo()),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<OrganizacionDomain> toDomainFromEntityList(List<OrganizacionEntity> entityList) {
        return entityList.stream().map(this::toDomainFromEntity).toList();

    }

    @Override
    public List<OrganizacionDTO> toDTOFromDomainList(List<OrganizacionDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();    }
}
