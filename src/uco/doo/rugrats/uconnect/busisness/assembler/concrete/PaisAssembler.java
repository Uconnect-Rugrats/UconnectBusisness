package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.PaisDomain;
import uco.doo.rugrats.uconnect.dto.PaisDTO;
import uco.doo.rugrats.uconnect.entities.PaisEntity;

public final class PaisAssembler implements Assembler<PaisDomain, PaisDTO, PaisEntity> {
    public static final PaisAssembler INSTANCE = new PaisAssembler();
    public static PaisAssembler getInstance() { return INSTANCE; }
    private PaisAssembler(){
        super();
    }

    @Override
    public PaisDTO toDTOFromDomain(PaisDomain domain) {
        return PaisDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setIndicador(domain.getIndicador());
    }

    @Override
    public PaisDomain toDomainFromDTO(PaisDTO dto) {
        return new PaisDomain(dto.getIdentificador(),dto.getNombre(),dto.getIndicador());
    }

    @Override
    public PaisEntity toEntityFromDomain(PaisDomain domain) {
        return new PaisEntity(domain.getIdentificador(),domain.getNombre(),domain.getIndicador());
    }

    @Override
    public PaisDomain toDomainFromEntity(PaisEntity entity) {
        return new PaisDomain(entity.getIdentificador(),entity.getNombre(),entity.getIndicador());
    }
}
