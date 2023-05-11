package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.TipoReaccionDomain;
import uco.doo.rugrats.uconnect.dto.TipoReaccionDTO;
import uco.doo.rugrats.uconnect.entities.TipoReaccionEntity;

import java.util.List;

public final class TipoReaccionAssembler implements Assembler<TipoReaccionDomain, TipoReaccionDTO, TipoReaccionEntity> {
    public static final TipoReaccionAssembler INSTANCE = new TipoReaccionAssembler();
    public static TipoReaccionAssembler getInstance() { return INSTANCE; }
    private TipoReaccionAssembler(){
        super();
    }
    @Override
    public TipoReaccionDTO toDTOFromDomain(TipoReaccionDomain domain) {
        return TipoReaccionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoReaccionDomain toDomainFromDTO(TipoReaccionDTO dto) {
        return new TipoReaccionDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public TipoReaccionEntity toEntityFromDomain(TipoReaccionDomain domain) {
        return new TipoReaccionEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
    }

    @Override
    public TipoReaccionDomain toDomainFromEntity(TipoReaccionEntity entity) {
        return new TipoReaccionDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
    }

    @Override
    public List<TipoReaccionDomain> toDomainFromEntityList(List<TipoReaccionEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<TipoReaccionDomain> toDomainFromDTOList(List<TipoReaccionDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();
    }

    @Override
    public List<TipoReaccionDTO> toDTOFromDomainList(List<TipoReaccionDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();    }
}
