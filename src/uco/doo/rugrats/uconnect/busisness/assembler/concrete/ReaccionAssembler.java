package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.ReaccionDomain;
import uco.doo.rugrats.uconnect.dto.ReaccionDTO;
import uco.doo.rugrats.uconnect.entities.ReaccionEntity;

import java.util.List;

public final class ReaccionAssembler implements Assembler<ReaccionDomain, ReaccionDTO, ReaccionEntity> {
    public static final ReaccionAssembler INSTANCE = new ReaccionAssembler();
    public static ReaccionAssembler getInstance() { return INSTANCE; }
    private ReaccionAssembler(){
        super();
    }

    @Override
    public ReaccionDTO toDTOFromDomain(ReaccionDomain domain) {
        return ReaccionDTO.create().setIdentificador(domain.getIdentificador()).setFechaReaccion(domain.getFechaReaccion())
                .setAutor(ParticipanteGrupoAssembler.getInstance().toDTOFromDomain(domain.getAutor())).setTipo(TipoReaccionAssembler.getInstance().toDTOFromDomain(domain.getTipo()))
                .setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion())).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setEstaEstadoRealActivo(domain.isEstaEstadoRealActivo());
    }

    @Override
    public ReaccionDomain toDomainFromDTO(ReaccionDTO dto) {
        return new ReaccionDomain(dto.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()),ParticipanteGrupoAssembler.getInstance().toDomainFromDTO(dto.getAutor()),
                dto.getFechaReaccion(),TipoReaccionAssembler.getInstance().toDomainFromDTO(dto.getTipo()),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()),dto.isEstaEstadoRealActivo() );
    }

    @Override
    public ReaccionEntity toEntityFromDomain(ReaccionDomain domain) {
        return new ReaccionEntity(domain.getIdentificador(),PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()), ParticipanteGrupoAssembler.getInstance().toEntityFromDomain(domain.getAutor()),
                domain.getFechaReaccion(),TipoReaccionAssembler.getInstance().toEntityFromDomain(domain.getTipo()),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()),domain.isEstaEstadoRealActivo() );
    }

    @Override
    public ReaccionDomain toDomainFromEntity(ReaccionEntity entity) {
        return new ReaccionDomain(entity.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()),ParticipanteGrupoAssembler.getInstance().toDomainFromEntity(entity.getAutor()),
                entity.getFechaReaccion(),TipoReaccionAssembler.getInstance().toDomainFromEntity(entity.getTipo()), EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()),entity.isEstaEstadoRealActivo());
    }

    @Override
    public List<ReaccionDomain> toDomainFromEntityList(List<ReaccionEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();

    }

    @Override
    public List<ReaccionDTO> toDTOFromDomainList(List<ReaccionDomain> domainList) {
        return domainList.stream().map(this::toDTOFromDomain).toList();
    }
}
