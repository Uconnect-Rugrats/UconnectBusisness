package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.CausaReporteAssembler;
import uco.doo.rugrats.uconnect.busisness.business.CausaReporteBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.CausaReporteDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.CausaReporteEntity;

import java.util.List;

public final class CausaReporteBusinessImpl implements CausaReporteBusiness {
    DAOFactory daoFactory;
    public CausaReporteBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    @Override
    public List<CausaReporteDomain> consultar(CausaReporteDomain domain) {
    	final CausaReporteEntity entity = CausaReporteAssembler.getInstance().toEntityFromDomain(domain);

		final List<CausaReporteEntity> resultEntityList = daoFactory.getCausaReporteDAO().read(entity);

		return CausaReporteAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }
}
