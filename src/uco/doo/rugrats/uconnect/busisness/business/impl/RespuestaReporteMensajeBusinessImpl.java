package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.RespuestaReporteMensajeAssembler;
import uco.doo.rugrats.uconnect.busisness.business.RespuestaReporteMensajeBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReporteMensajeDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.RespuestaReporteMensajeEntity;

import java.util.List;

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
        final List<RespuestaReporteMensajeEntity> resultado = daoFactory.getRespuestaReporteMensajeDAO().read(entity);
        return null;
    }

    @Override
    public void eliminar(RespuestaReporteMensajeDomain domain) {
        final RespuestaReporteMensajeEntity entity = RespuestaReporteMensajeAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getRespuestaReporteMensajeDAO().delete(entity);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
