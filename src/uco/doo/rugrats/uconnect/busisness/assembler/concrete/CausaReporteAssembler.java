package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.CausaReporteDomain;
import uco.doo.rugrats.uconnect.dto.CausaReporteDTO;
import uco.doo.rugrats.uconnect.entities.CausaReporteEntity;

public final class CausaReporteAssembler implements Assembler<CausaReporteDomain, CausaReporteDTO, CausaReporteEntity> {

    public static final CausaReporteAssembler INSTANCE = new CausaReporteAssembler();
    public static CausaReporteAssembler getInstance() { return INSTANCE; }
    private CausaReporteAssembler(){
        super();
    }
    @Override
    public CausaReporteDTO toDTOFromDomain(CausaReporteDomain domain) {
        return CausaReporteDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
    }

    @Override
    public CausaReporteDomain toDomainFromDTO(CausaReporteDTO dto) {
        return new CausaReporteDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public CausaReporteEntity toEntityFromDomain(CausaReporteDomain domain) {
        return new CausaReporteEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
    }

    @Override
    public CausaReporteDomain toDomainFromEntity(CausaReporteEntity entity) {
        return new CausaReporteDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
    }
}
