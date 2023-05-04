package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.GrupoDomain;
import uco.doo.rugrats.uconnect.dto.GrupoDTO;
import uco.doo.rugrats.uconnect.entities.GrupoEntity;

public final class GrupoAssembler implements Assembler<GrupoDomain, GrupoDTO, GrupoEntity> {
    public static final GrupoAssembler INSTANCE = new GrupoAssembler();
    public static GrupoAssembler getInstance() { return INSTANCE; }
    private GrupoAssembler(){
        super();
    }
    @Override
    public GrupoDTO toDTOFromDomain(GrupoDomain domain) {
        return GrupoDTO.create().setIdentificador(domain.getIdentificador()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()))
                .setEstructura(EstructuraAssembler.getInstance().toDTOFromDomain(domain.getEstructura())).setNombre(domain.getNombre());
    }

    @Override
    public GrupoDomain toDomainFromDTO(GrupoDTO dto) {
        return new GrupoDomain(dto.getIdentificador(),EstructuraAssembler.getInstance().toDomainFromDTO(dto.getEstructura()),
                dto.getNombre(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public GrupoEntity toEntityFromDomain(GrupoDomain domain) {
        return new GrupoEntity(domain.getIdentificador(),EstructuraAssembler.getInstance().toEntityFromDomain(domain.getEstructura()),
                domain.getNombre(),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public GrupoDomain toDomainFromEntity(GrupoEntity entity) {
        return new GrupoDomain(entity.getIdentificador(),EstructuraAssembler.getInstance().toDomainFromEntity(entity.getEstructura()),
                entity.getNombre(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
}
