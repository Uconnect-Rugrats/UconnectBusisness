package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.EstructuraAdministradorEstructuraDomain;
import uco.doo.rugrats.uconnect.dto.EstructuraAdministradorEstructuraDTO;
import uco.doo.rugrats.uconnect.entities.EstructuraAdministradorEstructuraEntity;

public final class EstructuraAdministradorEstructuraAssembler implements Assembler<EstructuraAdministradorEstructuraDomain, EstructuraAdministradorEstructuraDTO, EstructuraAdministradorEstructuraEntity> {
    public static final EstructuraAdministradorEstructuraAssembler INSTANCE = new EstructuraAdministradorEstructuraAssembler();
    public static EstructuraAdministradorEstructuraAssembler getInstance() { return INSTANCE; }
    private EstructuraAdministradorEstructuraAssembler(){
        super();
    }

    @Override
    public EstructuraAdministradorEstructuraDTO toDTOFromDomain(EstructuraAdministradorEstructuraDomain domain) {
        return EstructuraAdministradorEstructuraDTO.create().setIdentificador(domain.getIdentificador()).setAdministrador(AdministradorEstructuraAssembler.getInstance().toDTOFromDomain(domain.getAdministrador()))
                .setEstructura(EstructuraAssembler.getInstance().toDTOFromDomain(domain.getEstructura())).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public EstructuraAdministradorEstructuraDomain toDomainFromDTO(EstructuraAdministradorEstructuraDTO dto) {
        return new EstructuraAdministradorEstructuraDomain(dto.getIdentificador(),AdministradorEstructuraAssembler.getInstance().toDomainFromDTO(dto.getAdministrador()),
                EstructuraAssembler.getInstance().toDomainFromDTO(dto.getEstructura()),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public EstructuraAdministradorEstructuraEntity toEntityFromDomain(EstructuraAdministradorEstructuraDomain domain) {
        return new EstructuraAdministradorEstructuraEntity(domain.getIdentificador(),AdministradorEstructuraAssembler.getInstance().toEntityFromDomain(domain.getAdministrador()),
                EstructuraAssembler.getInstance().toEntityFromDomain(domain.getEstructura()), EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public EstructuraAdministradorEstructuraDomain toDomainFromEntity(EstructuraAdministradorEstructuraEntity entity) {
        return new EstructuraAdministradorEstructuraDomain(entity.getIdentificador(),AdministradorEstructuraAssembler.getInstance().toDomainFromEntity(entity.getAdministrador()),
                EstructuraAssembler.getInstance().toDomainFromEntity(entity.getEstructura()), EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
}
