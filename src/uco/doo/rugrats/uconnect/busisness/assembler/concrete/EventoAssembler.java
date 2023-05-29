package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.EventoDomain;
import uco.doo.rugrats.uconnect.dto.EventoDTO;
import uco.doo.rugrats.uconnect.entities.EventoEntity;

import java.util.List;

public final class EventoAssembler implements Assembler<EventoDomain, EventoDTO, EventoEntity> {
    public static final EventoAssembler INSTANCE = new EventoAssembler();
    public static EventoAssembler getInstance() { return INSTANCE; }
    private EventoAssembler(){
        super();
    }

    @Override
    public EventoDTO toDTOFromDomain(EventoDomain domain) {
        return EventoDTO.create().setIdentificador(domain.getIdentificador()).setAgenda(AgendaAssembler.getInstance().toDTOFromDomain(domain.getAgenda()))
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setLugar(domain.getLugar()).setDescripcion(domain.getDescripcion())
                .setFechaEjecucion(domain.getFechaEjecucion()).setNombre(domain.getNombreEvento()).setOrganizador(EstructuraAdministradorEstructuraAssembler.getInstance().toDTOFromDomain(domain.getOrganizador()))
                .setTipo(TipoEventoAssembler.getInstance().toDTOFromDomain(domain.getTipo()));
    }

    @Override
    public EventoDomain toDomainFromDTO(EventoDTO dto) {
        return new EventoDomain(dto.getIdentificador(),AgendaAssembler.getInstance().toDomainFromDTO(dto.getAgenda()),dto.getNombreEvento(),
                dto.getDescripcion(),dto.getLugar(),EstructuraAdministradorEstructuraAssembler.getInstance().toDomainFromDTO(dto.getOrganizador()),
                TipoEventoAssembler.getInstance().toDomainFromDTO(dto.getTipo()),dto.getFechaEjecucion(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()) );
    }

    @Override
    public EventoEntity toEntityFromDomain(EventoDomain domain) {
        return new EventoEntity(domain.getIdentificador(),AgendaAssembler.getInstance().toEntityFromDomain(domain.getAgenda()),
                domain.getNombreEvento(),domain.getDescripcion(),domain.getLugar(),EstructuraAdministradorEstructuraAssembler.getInstance().toEntityFromDomain(domain.getOrganizador()),
                TipoEventoAssembler.getInstance().toEntityFromDomain(domain.getTipo()),domain.getFechaEjecucion(),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()) );
    }

    @Override
    public EventoDomain toDomainFromEntity(EventoEntity entity) {
        return new EventoDomain(entity.getIdentificador(),AgendaAssembler.getInstance().toDomainFromEntity(entity.getAgenda()),entity.getNombreEvento(),
                entity.getDescripcion(),entity.getLugar(),EstructuraAdministradorEstructuraAssembler.getInstance().toDomainFromEntity(entity.getOrganizador()),
                TipoEventoAssembler.getInstance().toDomainFromEntity(entity.getTipo()), entity.getFechaEjecucion(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<EventoDomain> toDomainFromEntityList(List<EventoEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<EventoDomain> toDomainFromDTOList(List<EventoDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();
    }

    @Override
    public List<EventoDTO> toDTOFromDomainList(List<EventoDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();    }
}
