package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.ParticipanteGrupoDomain;
import uco.doo.rugrats.uconnect.dto.ParticipanteGrupoDTO;
import uco.doo.rugrats.uconnect.entities.ParticipanteGrupoEntity;

import java.util.List;

public final class ParticipanteGrupoAssembler implements Assembler<ParticipanteGrupoDomain, ParticipanteGrupoDTO, ParticipanteGrupoEntity> {
    public static final ParticipanteGrupoAssembler INSTANCE = new ParticipanteGrupoAssembler();
    public static ParticipanteGrupoAssembler getInstance() { return INSTANCE; }
    private ParticipanteGrupoAssembler(){
        super();
    }

    @Override
    public ParticipanteGrupoDTO toDTOFromDomain(ParticipanteGrupoDomain domain) {
        return ParticipanteGrupoDTO.create().setIdentificador(domain.getIdentificador()).setParticipante(ParticipanteAssembler.getInstance().toDTOFromDomain(domain.getParticipante()))
                .setGrupo(GrupoAssembler.getInstance().toDTOFromDomain(domain.getGrupo())).setPuedePublicar(domain.getPuedePublicar())
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public ParticipanteGrupoDomain toDomainFromDTO(ParticipanteGrupoDTO dto) {
        return new ParticipanteGrupoDomain(dto.getIdentificador(),ParticipanteAssembler.getInstance().toDomainFromDTO(dto.getParticipante()),dto.getPuedePublicar(),
                GrupoAssembler.getInstance().toDomainFromDTO(dto.getGrupo()), EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public ParticipanteGrupoEntity toEntityFromDomain(ParticipanteGrupoDomain domain) {
        return new ParticipanteGrupoEntity(domain.getIdentificador(),ParticipanteAssembler.getInstance().toEntityFromDomain(domain.getParticipante()), domain.getPuedePublicar(),
                GrupoAssembler.getInstance().toEntityFromDomain(domain.getGrupo()), EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public ParticipanteGrupoDomain toDomainFromEntity(ParticipanteGrupoEntity entity) {
        return new ParticipanteGrupoDomain(entity.getIdentificador(),ParticipanteAssembler.getInstance().toDomainFromEntity(entity.getParticipante()), entity.getPuedePublicar(),
                GrupoAssembler.getInstance().toDomainFromEntity(entity.getGrupo()), EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<ParticipanteGrupoDomain> toDomainFromEntityList(List<ParticipanteGrupoEntity> entityList) {
        return entityList.stream().map(this::toDomainFromEntity).toList();

    }
    @Override
    public List<ParticipanteGrupoDTO> toDTOFromDomainList(List<ParticipanteGrupoDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();    }
}
