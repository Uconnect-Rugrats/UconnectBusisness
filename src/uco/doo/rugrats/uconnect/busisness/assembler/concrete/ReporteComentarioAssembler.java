package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.ReporteComentarioDomain;
import uco.doo.rugrats.uconnect.dto.ReporteComentarioDTO;
import uco.doo.rugrats.uconnect.entities.ReporteComentarioEntity;

public final class ReporteComentarioAssembler implements Assembler<ReporteComentarioDomain, ReporteComentarioDTO, ReporteComentarioEntity> {
    public static final ReporteComentarioAssembler INSTANCE = new ReporteComentarioAssembler();
    public static ReporteComentarioAssembler getInstance() { return INSTANCE; }
    private ReporteComentarioAssembler(){
        super();
    }

    @Override
    public ReporteComentarioDTO toDTOFromDomain(ReporteComentarioDomain domain) {
        return ReporteComentarioDTO.create().setIdentificador(domain.getIdentificador()).setComentario(ComentarioAssembler.getInstance().toDTOFromDomain(domain.getComentario()))
                .setAutor(ParticipanteGrupoAssembler.getInstance().toDTOFromDomain(domain.getAutor())).setCausa(CausaReporteAssembler.getInstance().toDTOFromDomain(domain.getCausa()))
                .setFechaAcusacion(domain.getFechaAcusacion()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public ReporteComentarioDomain toDomainFromDTO(ReporteComentarioDTO dto) {
        return new ReporteComentarioDomain(dto.getIdentificador(),ComentarioAssembler.getInstance().toDomainFromDTO(dto.getComentario()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromDTO(dto.getAutor()),CausaReporteAssembler.getInstance().toDomainFromDTO(dto.getCausa()),dto.getFechaAcusacion(),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public ReporteComentarioEntity toEntityFromDomain(ReporteComentarioDomain domain) {
        return new ReporteComentarioEntity(domain.getIdentificador(),ComentarioAssembler.getInstance().toEntityFromDomain(domain.getComentario()),
                ParticipanteGrupoAssembler.getInstance().toEntityFromDomain(domain.getAutor()),CausaReporteAssembler.getInstance().toEntityFromDomain(domain.getCausa()),
                domain.getFechaAcusacion(),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public ReporteComentarioDomain toDomainFromEntity(ReporteComentarioEntity entity) {
        return new ReporteComentarioDomain(entity.getIdentificador(),ComentarioAssembler.getInstance().toDomainFromEntity(entity.getComentario()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromEntity(entity.getAutor()),CausaReporteAssembler.getInstance().toDomainFromEntity(entity.getCausa()),
                entity.getFechaAcusacion(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
}
