package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.ReportePublicacionDomain;
import uco.doo.rugrats.uconnect.dto.ReportePublicacionDTO;
import uco.doo.rugrats.uconnect.entities.ReportePublicacionEntity;

import java.util.List;

public final class ReportePublicacionAssembler implements Assembler<ReportePublicacionDomain, ReportePublicacionDTO, ReportePublicacionEntity> {
    public static final ReportePublicacionAssembler INSTANCE = new ReportePublicacionAssembler();
    public static ReportePublicacionAssembler getInstance() { return INSTANCE; }
    private ReportePublicacionAssembler(){
        super();
    }

    @Override
    public ReportePublicacionDTO toDTOFromDomain(ReportePublicacionDomain domain) {
        return ReportePublicacionDTO.create().setIdentificador(domain.getIdentificador()).setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion()))
                .setAutor(ParticipanteGrupoAssembler.getInstance().toDTOFromDomain(domain.getAutor())).setCausa(CausaReporteAssembler.getInstance().toDTOFromDomain(domain.getCausa()))
                .setFechaAcusacion(domain.getFechaAcusacion()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public ReportePublicacionDomain toDomainFromDTO(ReportePublicacionDTO dto) {
        return new ReportePublicacionDomain(dto.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromDTO(dto.getAutor()), CausaReporteAssembler.getInstance().toDomainFromDTO(dto.getCausa()),
                dto.getFechaAcusacion(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public ReportePublicacionEntity toEntityFromDomain(ReportePublicacionDomain domain) {
        return new ReportePublicacionEntity(domain.getIdentificador(),PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()),
                ParticipanteGrupoAssembler.getInstance().toEntityFromDomain(domain.getAutor()),CausaReporteAssembler.getInstance().toEntityFromDomain(domain.getCausa()), domain.getFechaAcusacion(),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public ReportePublicacionDomain toDomainFromEntity(ReportePublicacionEntity entity) {
        return new ReportePublicacionDomain(entity.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromEntity(entity.getAutor()),CausaReporteAssembler.getInstance().toDomainFromEntity(entity.getCausa()),
                entity.getFechaAcusacion(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<ReportePublicacionDomain> toDomainFromEntityList(List<ReportePublicacionEntity> entityList) {
        return entityList.stream().map(this::toDomainFromEntity).toList();

    }

    @Override
    public List<ReportePublicacionDTO> toDTOFromDomainList(List<ReportePublicacionDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
    }
}
