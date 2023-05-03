package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.MensajeDomain;
import uco.doo.rugrats.uconnect.dto.MensajeDTO;
import uco.doo.rugrats.uconnect.entities.MensajeEntity;

public final class MensajeAssembler implements Assembler<MensajeDomain, MensajeDTO, MensajeEntity> {
    public static final MensajeAssembler INSTANCE = new MensajeAssembler();
    public static MensajeAssembler getInstance() { return INSTANCE; }
    private MensajeAssembler(){
        super();
    }

    @Override
    public MensajeDTO toDTOFromDomain(MensajeDomain domain) {
        return MensajeDTO.create().setIdentificador(domain.getIdentificador()).setAutor(ParticipanteGrupoAssembler.getInstance().toDTOFromDomain(domain.getAutor()))
                .setChat(ChatAssembler.getInstance().toDTOFromDomain(domain.getChat())).setContenido(domain.getContenido())
                .setFechaEnviado(domain.getFechaEnviado()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public MensajeDomain toDomainFromDTO(MensajeDTO dto) {
        return new MensajeDomain(dto.getIdentificador(),ChatAssembler.getInstance().toDomainFromDTO(dto.getChat()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromDTO(dto.getAutor()), dto.getFechaEnviado(),dto.getContenido(),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public MensajeEntity toEntityFromDomain(MensajeDomain domain) {
        return new MensajeEntity(domain.getIdentificador(),ChatAssembler.getInstance().toEntityFromDomain(domain.getChat()),
                ParticipanteGrupoAssembler.getInstance().toEntityFromDomain(domain.getAutor()), domain.getFechaEnviado(),domain.getContenido(),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public MensajeDomain toDomainFromEntity(MensajeEntity entity) {
        return new MensajeDomain(entity.getIdentificador(),ChatAssembler.getInstance().toDomainFromEntity(entity.getChat()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromEntity(entity.getAutor()), entity.getFechaEnviado(),
                entity.getContenido(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
}
