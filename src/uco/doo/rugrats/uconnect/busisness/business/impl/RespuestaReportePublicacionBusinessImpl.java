package uco.doo.rugrats.uconnect.busisness.business.impl;


import uco.doo.rugrats.uconnect.busisness.assembler.concrete.RespuestaReportePublicacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.RespuestaReportePublicacionBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReportePublicacionDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.RespuestaReportePublicacionEntity;

import java.util.List;

public final class RespuestaReportePublicacionBusinessImpl implements RespuestaReportePublicacionBusiness {
    DAOFactory daoFactory;
    public RespuestaReportePublicacionBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void revisar(RespuestaReportePublicacionDomain domain) {
        final RespuestaReportePublicacionEntity entity = RespuestaReportePublicacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getRespuestaReportePublicacionDAO().create(entity);
    }

    @Override
    public void cerrarRespuesta(RespuestaReportePublicacionDomain domain) {
        final RespuestaReportePublicacionEntity entity = RespuestaReportePublicacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getRespuestaReportePublicacionDAO().update(entity);
    }

    @Override
    public List<RespuestaReportePublicacionDomain> abrir(RespuestaReportePublicacionDomain domain) {
        final RespuestaReportePublicacionEntity entity = RespuestaReportePublicacionAssembler.getInstance().toEntityFromDomain(domain);
        final List<RespuestaReportePublicacionEntity> resultado = daoFactory.getRespuestaReportePublicacionDAO().read(entity);
        return null;
    }

    @Override
    public void eliminar(RespuestaReportePublicacionDomain domain) {
        final RespuestaReportePublicacionEntity entity = RespuestaReportePublicacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getRespuestaReportePublicacionDAO().delete(entity);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}