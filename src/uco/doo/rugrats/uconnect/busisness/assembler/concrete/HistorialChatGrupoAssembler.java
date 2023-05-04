package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.HistorialChatGrupoDomain;
import uco.doo.rugrats.uconnect.dto.HistorialChatGrupoDTO;
import uco.doo.rugrats.uconnect.entities.HistorialChatGrupoEntity;

public final class HistorialChatGrupoAssembler implements Assembler<HistorialChatGrupoDomain, HistorialChatGrupoDTO, HistorialChatGrupoEntity> {
    public static final HistorialChatGrupoAssembler INSTANCE = new HistorialChatGrupoAssembler();
    public static HistorialChatGrupoAssembler getInstance() { return INSTANCE; }
    private HistorialChatGrupoAssembler(){
        super();
    }

    @Override
    public HistorialChatGrupoDTO toDTOFromDomain(HistorialChatGrupoDomain domain) {
        return HistorialChatGrupoDTO.create().setIdentificador(domain.getIdentificador()).setChat(ChatAssembler.getInstance().toDTOFromDomain(domain.getChat()))
                .setFechaIngreso(domain.getFechaIngreso()).setParticipante(ParticipanteGrupoAssembler.getInstance().toDTOFromDomain(domain.getParticipante()));
    }

    @Override
    public HistorialChatGrupoDomain toDomainFromDTO(HistorialChatGrupoDTO dto) {
        return new HistorialChatGrupoDomain(dto.getIdentificador(),ChatAssembler.getInstance().toDomainFromDTO(dto.getChat()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromDTO(dto.getParticipante()), dto.getFechaIngreso());
    }

    @Override
    public HistorialChatGrupoEntity toEntityFromDomain(HistorialChatGrupoDomain domain) {
        return new HistorialChatGrupoEntity(domain.getIdentificador(),ChatAssembler.getInstance().toEntityFromDomain(domain.getChat()),
                ParticipanteGrupoAssembler.getInstance().toEntityFromDomain(domain.getParticipante()),domain.getFechaIngreso() );
    }

    @Override
    public HistorialChatGrupoDomain toDomainFromEntity(HistorialChatGrupoEntity entity) {
        return new HistorialChatGrupoDomain(entity.getIdentificador(),ChatAssembler.getInstance().toDomainFromEntity(entity.getChat()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromEntity(entity.getParticipante()),entity.getFechaIngreso() );
    }
}
