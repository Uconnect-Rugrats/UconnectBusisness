package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.EstructuraDomain;
import uco.doo.rugrats.uconnect.dto.EstructuraDTO;
import uco.doo.rugrats.uconnect.entities.EstructuraEntity;

public final class EstructuraAssembler implements Assembler<EstructuraDomain, EstructuraDTO, EstructuraEntity> {
    public static final EstructuraAssembler INSTANCE = new EstructuraAssembler();
    public static EstructuraAssembler getInstance() { return INSTANCE; }
    private EstructuraAssembler(){
        super();
    }

    @Override
    public EstructuraDTO toDTOFromDomain(EstructuraDomain domain) {
        return EstructuraDTO.create().setIdentificador(domain.getIdentificador()).setEstructuraPadre(EstructuraAssembler.getInstance().toDTOFromDomain(domain.getEstructuraPadre()))
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setNombre(domain.getNombre()).setOrganizacion(OrganizacionAssembler.getInstance().toDTOFromDomain(domain.getOrganizacion()));
    }

    @Override
    public EstructuraDomain toDomainFromDTO(EstructuraDTO dto) {
        return new EstructuraDomain(dto.getIdentificador(),OrganizacionAssembler.getInstance().toDomainFromDTO(dto.getOrganizacion()),
                EstructuraAssembler.getInstance().toDomainFromDTO(dto.getEstructuraPadre()),dto.getNombre(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()) );
    }

    @Override
    public EstructuraEntity toEntityFromDomain(EstructuraDomain domain) {
        return new EstructuraEntity(domain.getIdentificador(),OrganizacionAssembler.getInstance().toEntityFromDomain(domain.getOrganizacion()),EstructuraAssembler.getInstance().toEntityFromDomain(domain.getEstructuraPadre()),
                domain.getNombre(),EstadoAssembler.INSTANCE.toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public EstructuraDomain toDomainFromEntity(EstructuraEntity entity) {
        return new EstructuraDomain(entity.getIdentificador(),OrganizacionAssembler.getInstance().toDomainFromEntity(entity.getOrganizacion()),
                EstructuraAssembler.getInstance().toDomainFromEntity(entity.getEstructuraPadre()), entity.getNombre(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
}
