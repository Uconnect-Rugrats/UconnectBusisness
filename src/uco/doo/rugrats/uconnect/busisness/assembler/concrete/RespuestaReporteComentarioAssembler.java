package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReporteComentarioDomain;
import uco.doo.rugrats.uconnect.dto.RespuestaReporteComentarioDTO;
import uco.doo.rugrats.uconnect.entities.RespuestaReporteComentarioEntity;

import java.util.List;

public final class RespuestaReporteComentarioAssembler implements Assembler<RespuestaReporteComentarioDomain, RespuestaReporteComentarioDTO, RespuestaReporteComentarioEntity> {
    public static final RespuestaReporteComentarioAssembler INSTANCE = new RespuestaReporteComentarioAssembler();
    public static RespuestaReporteComentarioAssembler getInstance() { return INSTANCE; }
    private RespuestaReporteComentarioAssembler(){
        super();
    }

    @Override
    public RespuestaReporteComentarioDTO toDTOFromDomain(RespuestaReporteComentarioDomain domain) {
        return RespuestaReporteComentarioDTO.create().setIdentificador(domain.getIdentificador()).setReporte(ReporteComentarioAssembler.getInstance().toDTOFromDomain(domain.getReporte()))
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setExplicacionVeredicto(domain.getExplicacionVeredicto())
                .setFechaRespuesta(domain.getFechaRespuesta()).setAdministrador(EstructuraAdministradorEstructuraAssembler.getInstance().toDTOFromDomain(domain.getAdministrador()));
    }

    @Override
    public RespuestaReporteComentarioDomain toDomainFromDTO(RespuestaReporteComentarioDTO dto) {
        return new RespuestaReporteComentarioDomain(dto.getIdentificador(),dto.getFechaRespuesta(),ReporteComentarioAssembler.getInstance().toDomainFromDTO(dto.getReporte()),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()),dto.getExplicacionVeredicto(),EstructuraAdministradorEstructuraAssembler.getInstance().toDomainFromDTO(dto.getAdministrador()) );
    }

    @Override
    public RespuestaReporteComentarioEntity toEntityFromDomain(RespuestaReporteComentarioDomain domain) {
        return new RespuestaReporteComentarioEntity(domain.getIdentificador(),domain.getFechaRespuesta(),ReporteComentarioAssembler.getInstance().toEntityFromDomain(domain.getReporte()),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()), domain.getExplicacionVeredicto(), EstructuraAdministradorEstructuraAssembler.getInstance().toEntityFromDomain(domain.getAdministrador()));
    }

    @Override
    public RespuestaReporteComentarioDomain toDomainFromEntity(RespuestaReporteComentarioEntity entity) {
        return new RespuestaReporteComentarioDomain(entity.getIdentificador(),entity.getFechaRespuesta(),ReporteComentarioAssembler.getInstance().toDomainFromEntity(entity.getReporte()),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()),entity.getExplicacionVeredicto(),EstructuraAdministradorEstructuraAssembler.getInstance().toDomainFromEntity(entity.getAdministrador()) );
    }

    @Override
    public List<RespuestaReporteComentarioDomain> toDomainFromEntityList(List<RespuestaReporteComentarioEntity> entityList) {
        return entityList.stream().map(this::toDomainFromEntity).toList();

    }

    @Override
    public List<RespuestaReporteComentarioDTO> toDTOFromDomainList(List<RespuestaReporteComentarioDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();    }
}
