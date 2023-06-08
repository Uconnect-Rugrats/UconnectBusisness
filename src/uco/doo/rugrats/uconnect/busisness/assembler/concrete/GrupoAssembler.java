package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.GrupoDomain;
import uco.doo.rugrats.uconnect.dto.GrupoDTO;
import uco.doo.rugrats.uconnect.entities.GrupoEntity;

import java.util.List;

public final class GrupoAssembler implements Assembler<GrupoDomain, GrupoDTO, GrupoEntity> {
    public static final GrupoAssembler INSTANCE = new GrupoAssembler();
    public static GrupoAssembler getInstance() { return INSTANCE; }
    private GrupoAssembler(){
        super();
    }
    @Override
    public GrupoDTO toDTOFromDomain(GrupoDomain domain) {
        return GrupoDTO.create().setIdentificador(domain.getIdentificador()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()))
                .setEstructura(EstructuraAssembler.getInstance().toDTOFromDomain(domain.getEstructura())).setNombre(domain.getNombre()).setEstaEstadoRealActivo(domain.isEstaEstadoRealActivo());
    }

    @Override
    public GrupoDomain toDomainFromDTO(GrupoDTO dto) {
        return new GrupoDomain(dto.getIdentificador(),EstructuraAssembler.getInstance().toDomainFromDTO(dto.getEstructura()),
                dto.getNombre(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()),dto.isEstaEstadoRealActivo());
    }

    @Override
    public GrupoEntity toEntityFromDomain(GrupoDomain domain) {
        return new GrupoEntity(domain.getIdentificador(),EstructuraAssembler.getInstance().toEntityFromDomain(domain.getEstructura()),
                domain.getNombre(),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()),domain.isEstaEstadoRealActivo());
    }

    @Override
    public GrupoDomain toDomainFromEntity(GrupoEntity entity) {
        return new GrupoDomain(entity.getIdentificador(),EstructuraAssembler.getInstance().toDomainFromEntity(entity.getEstructura()),
                entity.getNombre(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()),entity.isEstaEstadoRealActivo());
    }

    @Override
    public List<GrupoDomain> toDomainFromEntityList(List<GrupoEntity> entityList) {
        return entityList.stream().map(this::toDomainFromEntity).toList();

    }

    @Override
    public List<GrupoDTO> toDTOFromDomainList(List<GrupoDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();    }
}
