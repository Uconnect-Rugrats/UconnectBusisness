package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ReportePublicacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ReportePublicacionBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ReportePublicacionDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.ReportePublicacionEntity;

import java.util.List;

public final class ReportePublicacionBusinessImpl implements ReportePublicacionBusiness {
    DAOFactory daoFactory;
    public ReportePublicacionBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void reportar(ReportePublicacionDomain domain) {
        final ReportePublicacionEntity entity = ReportePublicacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getReportePublicacionDAO().create(entity);
    }

    @Override
    public void cambiarEstado(ReportePublicacionDomain domain) {
        final ReportePublicacionEntity entity = ReportePublicacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getReportePublicacionDAO().update(entity);
    }

    @Override
    public List<ReportePublicacionDomain> abrir(ReportePublicacionDomain domain) {
    	final ReportePublicacionEntity entity = ReportePublicacionAssembler.getInstance().toEntityFromDomain(domain);

		final List<ReportePublicacionEntity> resultEntityList = daoFactory.getReportePublicacionDAO().read(entity);

		return ReportePublicacionAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
