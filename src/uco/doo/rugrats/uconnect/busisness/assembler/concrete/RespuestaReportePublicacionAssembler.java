package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReportePublicacionDomain;
import uco.doo.rugrats.uconnect.dto.RespuestaReportePublicacionDTO;
import uco.doo.rugrats.uconnect.entities.RespuestaReportePublicacionEntity;

import java.util.List;

public final class RespuestaReportePublicacionAssembler implements Assembler<RespuestaReportePublicacionDomain, RespuestaReportePublicacionDTO, RespuestaReportePublicacionEntity> {
    public static final RespuestaReportePublicacionAssembler INSTANCE = new RespuestaReportePublicacionAssembler();
    public static RespuestaReportePublicacionAssembler getInstance() { return INSTANCE; }
    private RespuestaReportePublicacionAssembler(){
        super();
    }

    @Override
    public RespuestaReportePublicacionDTO toDTOFromDomain(RespuestaReportePublicacionDomain domain) {
        return RespuestaReportePublicacionDTO.create().setIdentificador(domain.getIdentificador()).setReporte(ReportePublicacionAssembler.getInstance().toDTOFromDomain(domain.getReporte()))
                .setAdministrador(EstructuraAdministradorEstructuraAssembler.getInstance().toDTOFromDomain(domain.getAdministrador()))
                .setFechaRespuesta(domain.getFechaRespuesta()).setExplicacionVeredicto(domain.getExplicacionVeredicto()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public RespuestaReportePublicacionDomain toDomainFromDTO(RespuestaReportePublicacionDTO dto) {
        return new RespuestaReportePublicacionDomain(dto.getIdentificador(),dto.getFechaRespuesta(),ReportePublicacionAssembler.getInstance().toDomainFromDTO(dto.getReporte()),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()),dto.getExplicacionVeredicto(),EstructuraAdministradorEstructuraAssembler.getInstance().toDomainFromDTO(dto.getAdministrador()));
    }

    @Override
    public RespuestaReportePublicacionEntity toEntityFromDomain(RespuestaReportePublicacionDomain domain) {
        return new RespuestaReportePublicacionEntity(domain.getIdentificador(),domain.getFechaRespuesta(),ReportePublicacionAssembler.getInstance().toEntityFromDomain(domain.getReporte()),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()),domain.getExplicacionVeredicto(), EstructuraAdministradorEstructuraAssembler.getInstance().toEntityFromDomain(domain.getAdministrador()) );
    }

    @Override
    public RespuestaReportePublicacionDomain toDomainFromEntity(RespuestaReportePublicacionEntity entity) {
        return new RespuestaReportePublicacionDomain(entity.getIdentificador(),entity.getFechaRespuesta(),ReportePublicacionAssembler.getInstance().toDomainFromEntity(entity.getReporte()),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()),entity.getExplicacionVeredicto(),EstructuraAdministradorEstructuraAssembler.getInstance().toDomainFromEntity(entity.getAdministrador()) );
    }

    @Override
    public List<RespuestaReportePublicacionDomain> toDomainFromEntityList(List<RespuestaReportePublicacionEntity> entityList) {
        return entityList.stream().map(this::toDomainFromEntity).toList();

    }

    @Override
    public List<RespuestaReportePublicacionDTO> toDTOFromDomainList(List<RespuestaReportePublicacionDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();    }
}
