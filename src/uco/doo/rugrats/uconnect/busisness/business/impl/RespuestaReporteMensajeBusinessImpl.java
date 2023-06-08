package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.RespuestaReporteMensajeAssembler;
import uco.doo.rugrats.uconnect.busisness.business.RespuestaReporteMensajeBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReporteMensajeDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.RespuestaReporteMensajeEntity;

import java.util.List;
import java.util.UUID;

public final class RespuestaReporteMensajeBusinessImpl implements RespuestaReporteMensajeBusiness {
    DAOFactory daoFactory;
    public RespuestaReporteMensajeBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void revisar(RespuestaReporteMensajeDomain domain) {
        final RespuestaReporteMensajeEntity entity = RespuestaReporteMensajeAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getRespuestaReporteMensajeDAO().create(entity);
    }

    @Override
    public void cerrarRespuesta(RespuestaReporteMensajeDomain domain) {
        final RespuestaReporteMensajeEntity entity = RespuestaReporteMensajeAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getRespuestaReporteMensajeDAO().update(entity);
    }

    @Override
    public List<RespuestaReporteMensajeDomain> abrir(RespuestaReporteMensajeDomain domain) {
    	final RespuestaReporteMensajeEntity entity = RespuestaReporteMensajeAssembler.getInstance().toEntityFromDomain(domain);

		final List<RespuestaReporteMensajeEntity> resultEntityList = daoFactory.getRespuestaReporteMensajeDAO().read(entity);

		return RespuestaReporteMensajeAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getRespuestaReporteMensajeDAO().delete(domain);
    }
}
