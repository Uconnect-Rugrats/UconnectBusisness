package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.AgendaDomain;
import uco.doo.rugrats.uconnect.dto.AgendaDTO;
import uco.doo.rugrats.uconnect.entities.AgendaEntity;

import java.util.List;

public final class AgendaAssembler implements Assembler<AgendaDomain, AgendaDTO, AgendaEntity> {
    public static final AgendaAssembler INSTANCE = new AgendaAssembler();
    public static AgendaAssembler getInstance() { return INSTANCE; }
    private AgendaAssembler(){
        super();
    }

    @Override
    public AgendaDTO toDTOFromDomain(AgendaDomain domain) {
        return AgendaDTO.create().setIdentificador(domain.getIdentificador()).setGrupo(GrupoAssembler.getInstance().toDTOFromDomain(domain.getGrupo()))
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setFechaInicio(domain.getFechaInicio()).setFechaFin(domain.getFechaFin());
    }

    @Override
    public AgendaDomain toDomainFromDTO(AgendaDTO dto) {
        return new AgendaDomain(dto.getIdentificador(),GrupoAssembler.getInstance().toDomainFromDTO(dto.getGrupo()),
                dto.getFechaInicio(),dto.getFechaFin(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public AgendaEntity toEntityFromDomain(AgendaDomain domain) {
        return new AgendaEntity(domain.getIdentificador(),GrupoAssembler.getInstance().toEntityFromDomain(domain.getGrupo()),
                domain.getFechaInicio(),domain.getFechaFin(),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public AgendaDomain toDomainFromEntity(AgendaEntity entity) {
        return new AgendaDomain(entity.getIdentificador(),GrupoAssembler.getInstance().toDomainFromEntity(entity.getGrupo()),
                entity.getFechaInicio(),entity.getFechaFin(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<AgendaDomain> toDomainFromEntityList(List<AgendaEntity> entityList) {
        return entityList.stream().map(this::toDomainFromEntity).toList();

    }

    @Override
    public List<AgendaDTO> toDTOFromDomainList(List<AgendaDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
    }
}
