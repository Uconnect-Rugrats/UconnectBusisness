package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.TipoIdentificacionDomain;
import uco.doo.rugrats.uconnect.dto.TipoIdentificacionDTO;
import uco.doo.rugrats.uconnect.entities.TipoIdentificacionEntity;

import java.util.List;

public final class TipoIdentificacionAssembler implements Assembler<TipoIdentificacionDomain, TipoIdentificacionDTO, TipoIdentificacionEntity> {
    public static final TipoIdentificacionAssembler INSTANCE = new TipoIdentificacionAssembler();
    public static TipoIdentificacionAssembler getInstance() { return INSTANCE; }
    private TipoIdentificacionAssembler(){
        super();
    }

    @Override
    public TipoIdentificacionDTO toDTOFromDomain(TipoIdentificacionDomain domain) {
        return TipoIdentificacionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setIndicador(domain.getIndicador());
    }

    @Override
    public TipoIdentificacionDomain toDomainFromDTO(TipoIdentificacionDTO dto) {
        return new TipoIdentificacionDomain(dto.getIdentificador(),dto.getNombre(),dto.getIndicador());
    }

    @Override
    public TipoIdentificacionEntity toEntityFromDomain(TipoIdentificacionDomain domain) {
        return new TipoIdentificacionEntity(domain.getIdentificador(),domain.getNombre(),domain.getIndicador());
    }

    @Override
    public TipoIdentificacionDomain toDomainFromEntity(TipoIdentificacionEntity entity) {
        return new TipoIdentificacionDomain(entity.getIdentificador(),entity.getNombre(),entity.getIndicador());
    }

    @Override
    public List<TipoIdentificacionDomain> toDomainFromEntityList(List<TipoIdentificacionEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<TipoIdentificacionDomain> toDomainFromDTOList(List<TipoIdentificacionDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();
    }

    @Override
    public List<TipoIdentificacionDTO> toDTOFromDomainList(List<TipoIdentificacionDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();    }
}
