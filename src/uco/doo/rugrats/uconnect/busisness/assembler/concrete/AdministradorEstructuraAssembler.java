package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.AdministradorEstructuraDomain;
import uco.doo.rugrats.uconnect.dto.AdministradorEstructuraDTO;
import uco.doo.rugrats.uconnect.entities.AdministradorEstructuraEntity;

public final class AdministradorEstructuraAssembler implements Assembler<AdministradorEstructuraDomain, AdministradorEstructuraDTO, AdministradorEstructuraEntity> {
    public static final AdministradorEstructuraAssembler INSTANCE = new AdministradorEstructuraAssembler();
    public static AdministradorEstructuraAssembler getInstance() { return INSTANCE; }
    private AdministradorEstructuraAssembler(){
        super();
    }

    @Override
    public AdministradorEstructuraDTO toDTOFromDomain(AdministradorEstructuraDomain domain) {
        return AdministradorEstructuraDTO.create().setIdentificador(domain.getIdentificador()).setPersona(PersonaAssembler.getInstance().toDTOFromDomain(domain.getPersona()));
    }

    @Override
    public AdministradorEstructuraDomain toDomainFromDTO(AdministradorEstructuraDTO dto) {
        return new AdministradorEstructuraDomain(dto.getIdentificador(),PersonaAssembler.getInstance().toDomainFromDTO(dto.getPersona()));
    }

    @Override
    public AdministradorEstructuraEntity toEntityFromDomain(AdministradorEstructuraDomain domain) {
        return new AdministradorEstructuraEntity(domain.getIdentificador(),PersonaAssembler.getInstance().toEntityFromDomain(domain.getPersona()));
    }

    @Override
    public AdministradorEstructuraDomain toDomainFromEntity(AdministradorEstructuraEntity entity) {
        return new AdministradorEstructuraDomain(entity.getIdentificador(),PersonaAssembler.getInstance().toDomainFromEntity(entity.getPersona()));
    }
}
