package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.ReporteMensajeDomain;
import uco.doo.rugrats.uconnect.dto.ReporteMensajeDTO;
import uco.doo.rugrats.uconnect.entities.ReporteMensajeEntity;

import java.util.List;

public final class ReporteMensajeAssembler implements Assembler<ReporteMensajeDomain, ReporteMensajeDTO, ReporteMensajeEntity> {
    public static final ReporteMensajeAssembler INSTANCE = new ReporteMensajeAssembler();
    public static ReporteMensajeAssembler getInstance() { return INSTANCE; }
    private ReporteMensajeAssembler(){
        super();
    }

    @Override
    public ReporteMensajeDTO toDTOFromDomain(ReporteMensajeDomain domain) {
        return ReporteMensajeDTO.create().setIdentificador(domain.getIdentificador()).setMensaje(MensajeAssembler.getInstance().toDTOFromDomain(domain.getMensaje()))
                .setAutor(ParticipanteGrupoAssembler.getInstance().toDTOFromDomain(domain.getAutor())).setCausa(CausaReporteAssembler.getInstance().toDTOFromDomain(domain.getCausa()))
                .setFechaAcusacion(domain.getFechaAcusacion()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public ReporteMensajeDomain toDomainFromDTO(ReporteMensajeDTO dto) {
        return new ReporteMensajeDomain(dto.getIdentificador(),MensajeAssembler.getInstance().toDomainFromDTO(dto.getMensaje()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromDTO(dto.getAutor()), CausaReporteAssembler.getInstance().toDomainFromDTO(dto.getCausa()),
                dto.getFechaAcusacion(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public ReporteMensajeEntity toEntityFromDomain(ReporteMensajeDomain domain) {
        return new ReporteMensajeEntity(domain.getIdentificador(),MensajeAssembler.getInstance().toEntityFromDomain(domain.getMensaje()),
                ParticipanteGrupoAssembler.getInstance().toEntityFromDomain(domain.getAutor()),CausaReporteAssembler.getInstance().toEntityFromDomain(domain.getCausa()),
                domain.getFechaAcusacion(),EstadoAssembler.INSTANCE.toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public ReporteMensajeDomain toDomainFromEntity(ReporteMensajeEntity entity) {
        return new ReporteMensajeDomain(entity.getIdentificador(),MensajeAssembler.getInstance().toDomainFromEntity(entity.getMensaje()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromEntity(entity.getAutor()),CausaReporteAssembler.getInstance().toDomainFromEntity(entity.getCausa()),
                entity.getFechaAcusacion(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<ReporteMensajeDomain> toDomainFromEntityList(List<ReporteMensajeEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<ReporteMensajeDomain> toDomainFromDTOList(List<ReporteMensajeDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();
    }

    @Override
    public List<ReporteMensajeDTO> toDTOFromDomainList(List<ReporteMensajeDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();    }
}
