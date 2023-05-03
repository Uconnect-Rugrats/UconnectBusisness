package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.TipoEstadoDomain;
import uco.doo.rugrats.uconnect.dto.TipoEstadoDTO;
import uco.doo.rugrats.uconnect.entities.TipoEstadoEntity;

public final class TipoEstadoAssembler implements Assembler<TipoEstadoDomain, TipoEstadoDTO, TipoEstadoEntity> {
    public static final TipoEstadoAssembler INSTANCE = new TipoEstadoAssembler();
    public static TipoEstadoAssembler getInstance() { return INSTANCE; }
    private TipoEstadoAssembler(){
        super();
    }
    @Override
    public TipoEstadoDTO toDTOFromDomain(TipoEstadoDomain domain) {
        return TipoEstadoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoEstadoDomain toDomainFromDTO(TipoEstadoDTO dto) {
        return new TipoEstadoDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public TipoEstadoEntity toEntityFromDomain(TipoEstadoDomain domain) {
        return new TipoEstadoEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
    }

    @Override
    public TipoEstadoDomain toDomainFromEntity(TipoEstadoEntity entity) {
        return new TipoEstadoDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
    }
}
