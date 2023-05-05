package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ReporteComentarioAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ReporteComentarioBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ReporteComentarioDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.ReporteComentarioEntity;

import java.util.List;

public final class ReporteComentarioBusinessImpl implements ReporteComentarioBusiness {
    DAOFactory daoFactory;
    public ReporteComentarioBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void reportar(ReporteComentarioDomain domain) {
        final ReporteComentarioEntity entity = ReporteComentarioAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getReporteComentarioDAO().create(entity);
    }

    @Override
    public void cambiarEstado(ReporteComentarioDomain domain) {
        final ReporteComentarioEntity entity = ReporteComentarioAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getReporteComentarioDAO().update(entity);
    }

    @Override
    public List<ReporteComentarioDomain> abrir(ReporteComentarioDomain domain) {
        final ReporteComentarioEntity entity = ReporteComentarioAssembler.getInstance().toEntityFromDomain(domain);
        final List<ReporteComentarioEntity> resultado = daoFactory.getReporteComentarioDAO().read(entity);
        return null;
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
