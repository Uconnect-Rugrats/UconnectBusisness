package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.OrganizacionAdministradorOrganizacionDomain;
import uco.doo.rugrats.uconnect.dto.OrganizacionAdministradorOrganizacionDTO;
import uco.doo.rugrats.uconnect.entities.OrganizacionAdministradorOrganizacionEntity;

public final class OrganizacionAdministradorOrganizacionAssembler implements Assembler<OrganizacionAdministradorOrganizacionDomain, OrganizacionAdministradorOrganizacionDTO, OrganizacionAdministradorOrganizacionEntity> {
    public static final OrganizacionAdministradorOrganizacionAssembler INSTANCE = new OrganizacionAdministradorOrganizacionAssembler();
    public static OrganizacionAdministradorOrganizacionAssembler getInstance() { return INSTANCE; }
    private OrganizacionAdministradorOrganizacionAssembler(){
        super();
    }

    @Override
    public OrganizacionAdministradorOrganizacionDTO toDTOFromDomain(OrganizacionAdministradorOrganizacionDomain domain) {
        return OrganizacionAdministradorOrganizacionDTO.create().setIdentificador(domain.getIdentificador()).setOrganizacion(OrganizacionAssembler.getInstance().toDTOFromDomain(domain.getOrganizacion()))
                .setAdministrador(AdministradorOrganizacionAssembler.getInstance().toDTOFromDomain(domain.getAdministrador()))
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public OrganizacionAdministradorOrganizacionDomain toDomainFromDTO(OrganizacionAdministradorOrganizacionDTO dto) {
        return new OrganizacionAdministradorOrganizacionDomain(dto.getIdentificador(),AdministradorOrganizacionAssembler.getInstance().toDomainFromDTO(dto.getAdministrador()), OrganizacionAssembler.getInstance().toDomainFromDTO(dto.getOrganizacion()),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public OrganizacionAdministradorOrganizacionEntity toEntityFromDomain(OrganizacionAdministradorOrganizacionDomain domain) {
        return new OrganizacionAdministradorOrganizacionEntity(domain.getIdentificador(),AdministradorOrganizacionAssembler.getInstance().toEntityFromDomain(domain.getAdministrador()),
                OrganizacionAssembler.getInstance().toEntityFromDomain(domain.getOrganizacion()),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public OrganizacionAdministradorOrganizacionDomain toDomainFromEntity(OrganizacionAdministradorOrganizacionEntity entity) {
        return new OrganizacionAdministradorOrganizacionDomain(entity.getIdentificador(), AdministradorOrganizacionAssembler.getInstance().toDomainFromEntity(entity.getAdministrador()),
                OrganizacionAssembler.getInstance().toDomainFromEntity(entity.getOrganizacion()), EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
}
