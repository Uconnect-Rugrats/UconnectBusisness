package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.TipoEventoDomain;
import uco.doo.rugrats.uconnect.dto.TipoEventoDTO;
import uco.doo.rugrats.uconnect.entities.TipoEventoEntity;

public final class TipoEventoAssembler implements Assembler<TipoEventoDomain, TipoEventoDTO, TipoEventoEntity> {
    public static final TipoEventoAssembler INSTANCE = new TipoEventoAssembler();
    public static TipoEventoAssembler getInstance() { return INSTANCE; }
    private TipoEventoAssembler(){
        super();
    }
    @Override
    public TipoEventoDTO toDTOFromDomain(TipoEventoDomain domain) {
        return TipoEventoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoEventoDomain toDomainFromDTO(TipoEventoDTO dto) {
        return new TipoEventoDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public TipoEventoEntity toEntityFromDomain(TipoEventoDomain domain) {
        return new TipoEventoEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
    }

    @Override
    public TipoEventoDomain toDomainFromEntity(TipoEventoEntity entity) {
        return new TipoEventoDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
    }
}
