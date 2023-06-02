package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.ParticipanteDomain;
import uco.doo.rugrats.uconnect.dto.ParticipanteDTO;
import uco.doo.rugrats.uconnect.entities.ParticipanteEntity;

import java.util.List;

public final class ParticipanteAssembler implements Assembler<ParticipanteDomain, ParticipanteDTO, ParticipanteEntity> {
    public static final ParticipanteAssembler INSTANCE = new ParticipanteAssembler();
    public static ParticipanteAssembler getInstance() { return INSTANCE; }
    private ParticipanteAssembler(){
        super();
    }

    @Override
    public ParticipanteDTO toDTOFromDomain(ParticipanteDomain domain) {
        return ParticipanteDTO.create().setIdentificador(domain.getIdentificador()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()))
                .setPersona(PersonaAssembler.getInstance().toDTOFromDomain(domain.getPersona()));
    }

    @Override
    public ParticipanteDomain toDomainFromDTO(ParticipanteDTO dto) {
        return new ParticipanteDomain(dto.getIdentificador(),PersonaAssembler.getInstance().toDomainFromDTO(dto.getPersona()),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public ParticipanteEntity toEntityFromDomain(ParticipanteDomain domain) {
        return new ParticipanteEntity(domain.getIdentificador(),PersonaAssembler.getInstance().toEntityFromDomain(domain.getPersona()),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public ParticipanteDomain toDomainFromEntity(ParticipanteEntity entity) {
        return new ParticipanteDomain(entity.getIdentificador(),PersonaAssembler.getInstance().toDomainFromEntity(entity.getPersona()),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<ParticipanteDomain> toDomainFromEntityList(List<ParticipanteEntity> entityList) {
        return entityList.stream().map(this::toDomainFromEntity).toList();

    }

    @Override
    public List<ParticipanteDTO> toDTOFromDomainList(List<ParticipanteDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
    }
}
