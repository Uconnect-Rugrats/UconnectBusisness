package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.entities.EstadoEntity;

public final class EstadoAssembler implements Assembler<EstadoDomain, EstadoDTO, EstadoEntity> {
    public static final EstadoAssembler INSTANCE = new EstadoAssembler();
    public static EstadoAssembler getInstance() { return INSTANCE; }
    private EstadoAssembler(){
        super();
    }
    @Override
    public EstadoDTO toDTOFromDomain(EstadoDomain domain) {
        return EstadoDTO.create().setIdentificador(domain.getIdentificador()).setTipoEstado(TipoEstadoAssembler.getInstance().toDTOFromDomain(domain.getTipoEstado()))
                .setDescripcion(domain.getDescripcion()).setNombre(domain.getNombre());
    }

    @Override
    public EstadoDomain toDomainFromDTO(EstadoDTO dto) {
        return new EstadoDomain(dto.getIdentificador(),dto.getNombre(),TipoEstadoAssembler.getInstance().toDomainFromDTO(dto.getTipoEstado()), dto.getDescripcion());
    }

    @Override
    public EstadoEntity toEntityFromDomain(EstadoDomain domain) {
        return new EstadoEntity(domain.getIdentificador(),domain.getNombre(),TipoEstadoAssembler.getInstance().toEntityFromDomain(domain.getTipoEstado()),domain.getDescripcion());
    }

    @Override
    public EstadoDomain toDomainFromEntity(EstadoEntity entity) {
        return new EstadoDomain(entity.getIdentificador(),entity.getNombre(),TipoEstadoAssembler.getInstance().toDomainFromEntity(entity.getTipoEstado()), entity.getDescripcion());
    }
}

