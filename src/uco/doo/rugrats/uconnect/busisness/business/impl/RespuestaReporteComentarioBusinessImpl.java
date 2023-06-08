package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.RespuestaReporteComentarioAssembler;
import uco.doo.rugrats.uconnect.busisness.business.RespuestaReporteComentarioBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReporteComentarioDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.RespuestaReporteComentarioEntity;

import java.util.List;
import java.util.UUID;

public final class RespuestaReporteComentarioBusinessImpl implements RespuestaReporteComentarioBusiness {
    DAOFactory daoFactory;
    public RespuestaReporteComentarioBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void revisar(RespuestaReporteComentarioDomain domain) {
        final RespuestaReporteComentarioEntity entity = RespuestaReporteComentarioAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getRespuestaReporteComentarioDAO().create(entity);
    }

    @Override
    public void cerrarRespuesta(RespuestaReporteComentarioDomain domain) {
        final RespuestaReporteComentarioEntity entity = RespuestaReporteComentarioAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getRespuestaReporteComentarioDAO().update(entity);
    }

    @Override
    public List<RespuestaReporteComentarioDomain> abrir(RespuestaReporteComentarioDomain domain) {
    	final RespuestaReporteComentarioEntity entity = RespuestaReporteComentarioAssembler.getInstance().toEntityFromDomain(domain);

		final List<RespuestaReporteComentarioEntity> resultEntityList = daoFactory.getRespuestaReporteComentarioDAO().read(entity);

		return RespuestaReporteComentarioAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getRespuestaReporteComentarioDAO().delete(domain);
    }

}
