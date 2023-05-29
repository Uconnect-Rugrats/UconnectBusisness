package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ReporteMensajeAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ReporteMensajeBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ReporteMensajeDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.ReporteMensajeEntity;

import java.util.List;

public final class ReporteMensajeBusinessImpl implements ReporteMensajeBusiness {
    DAOFactory daoFactory;
    public ReporteMensajeBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void reportar(ReporteMensajeDomain domain) {
        final ReporteMensajeEntity entity = ReporteMensajeAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getReporteMensajeDAO().create(entity);
    }

    @Override
    public void cambiarEstado(ReporteMensajeDomain domain) {
        final ReporteMensajeEntity entity = ReporteMensajeAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getReporteMensajeDAO().update(entity);
    }

    @Override
    public List<ReporteMensajeDomain> abrir(ReporteMensajeDomain domain) {
    	final ReporteMensajeEntity entity = ReporteMensajeAssembler.getInstance().toEntityFromDomain(domain);

		final List<ReporteMensajeEntity> resultEntityList = daoFactory.getReporteMensajeDAO().read(entity);

		return ReporteMensajeAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
