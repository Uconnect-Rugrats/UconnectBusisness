package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.AdministradorOrganizacionDomain;
import uco.doo.rugrats.uconnect.dto.AdministradorOrganizacionDTO;
import uco.doo.rugrats.uconnect.entities.AdministradorOrganizacionEntity;

public final class AdministradorOrganizacionAssembler implements Assembler<AdministradorOrganizacionDomain, AdministradorOrganizacionDTO, AdministradorOrganizacionEntity> {
    public static final AdministradorOrganizacionAssembler INSTANCE = new AdministradorOrganizacionAssembler();
    public static AdministradorOrganizacionAssembler getInstance() { return INSTANCE; }
    private AdministradorOrganizacionAssembler(){
        super();
    }
    @Override
    public AdministradorOrganizacionDTO toDTOFromDomain(AdministradorOrganizacionDomain domain) {
        return AdministradorOrganizacionDTO.create().setIdentificador(domain.getIdentificador()).setPersona(PersonaAssembler.getInstance().toDTOFromDomain(domain.getPersona()));
    }

    @Override
    public AdministradorOrganizacionDomain toDomainFromDTO(AdministradorOrganizacionDTO dto) {
        return new AdministradorOrganizacionDomain(dto.getIdentificador(),PersonaAssembler.getInstance().toDomainFromDTO(dto.getPersona()));
    }

    @Override
    public AdministradorOrganizacionEntity toEntityFromDomain(AdministradorOrganizacionDomain domain) {
        return new AdministradorOrganizacionEntity(domain.getIdentificador(),PersonaAssembler.getInstance().toEntityFromDomain(domain.getPersona()));
    }

    @Override
    public AdministradorOrganizacionDomain toDomainFromEntity(AdministradorOrganizacionEntity entity) {
        return new AdministradorOrganizacionDomain(entity.getIdentificador(),PersonaAssembler.getInstance().toDomainFromEntity(entity.getPersona()));
    }
}
