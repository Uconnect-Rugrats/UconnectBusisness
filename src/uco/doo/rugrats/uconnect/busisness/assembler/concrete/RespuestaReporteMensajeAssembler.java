package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReporteMensajeDomain;
import uco.doo.rugrats.uconnect.dto.RespuestaReporteMensajeDTO;
import uco.doo.rugrats.uconnect.entities.RespuestaReporteMensajeEntity;

import java.util.List;

public final class RespuestaReporteMensajeAssembler implements Assembler<RespuestaReporteMensajeDomain, RespuestaReporteMensajeDTO, RespuestaReporteMensajeEntity> {
    public static final RespuestaReporteMensajeAssembler INSTANCE = new RespuestaReporteMensajeAssembler();
    public static RespuestaReporteMensajeAssembler getInstance() { return INSTANCE; }
    private RespuestaReporteMensajeAssembler(){
        super();
    }

    @Override
    public RespuestaReporteMensajeDTO toDTOFromDomain(RespuestaReporteMensajeDomain domain) {
        return RespuestaReporteMensajeDTO.create().setIdentificador(domain.getIdentificador()).setFechaRespuesta(domain.getFechaRespuesta())
                .setReporte(ReporteMensajeAssembler.getInstance().toDTOFromDomain(domain.getReporte())).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()))
                .setExplicacionVeredicto(domain.getExplicacionVeredicto()).setAdministrador(EstructuraAdministradorEstructuraAssembler.getInstance().toDTOFromDomain(domain.getAdministrador()));
    }

    @Override
    public RespuestaReporteMensajeDomain toDomainFromDTO(RespuestaReporteMensajeDTO dto) {
        return new RespuestaReporteMensajeDomain(dto.getIdentificador(),dto.getFechaRespuesta(), ReporteMensajeAssembler.getInstance().toDomainFromDTO(dto.getReporte()),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()), dto.getExplicacionVeredicto(),EstructuraAdministradorEstructuraAssembler.getInstance().toDomainFromDTO(dto.getAdministrador()));
    }

    @Override
    public RespuestaReporteMensajeEntity toEntityFromDomain(RespuestaReporteMensajeDomain domain) {
        return new RespuestaReporteMensajeEntity(domain.getIdentificador(),domain.getFechaRespuesta(),ReporteMensajeAssembler.getInstance().toEntityFromDomain(domain.getReporte()),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()), domain.getExplicacionVeredicto(),EstructuraAdministradorEstructuraAssembler.getInstance().toEntityFromDomain(domain.getAdministrador()));
    }

    @Override
    public RespuestaReporteMensajeDomain toDomainFromEntity(RespuestaReporteMensajeEntity entity) {
        return new RespuestaReporteMensajeDomain(entity.getIdentificador(),entity.getFechaRespuesta(),ReporteMensajeAssembler.getInstance().toDomainFromEntity(entity.getReporte()),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()), entity.getExplicacionVeredicto(),EstructuraAdministradorEstructuraAssembler.getInstance().toDomainFromEntity(entity.getAdministrador()));
    }

    @Override
    public List<RespuestaReporteMensajeDomain> toDomainFromEntityList(List<RespuestaReporteMensajeEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<RespuestaReporteMensajeDomain> toDomainFromDTOList(List<RespuestaReporteMensajeDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();
    }

    @Override
    public List<RespuestaReporteMensajeDTO> toDTOFromDomainList(List<RespuestaReporteMensajeDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
    }
}
