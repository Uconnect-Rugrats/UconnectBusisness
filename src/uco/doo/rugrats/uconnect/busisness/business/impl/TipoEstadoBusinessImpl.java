package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.TipoEstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.TipoEstadoBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.TipoEstadoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.TipoEstadoEntity;

import java.util.List;

public final class TipoEstadoBusinessImpl implements TipoEstadoBusiness {
    DAOFactory daoFactory;
    public TipoEstadoBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<TipoEstadoDomain> consultar(TipoEstadoDomain domain) {
    	final TipoEstadoEntity entity = TipoEstadoAssembler.getInstance().toEntityFromDomain(domain);

		final List<TipoEstadoEntity> resultEntityList = daoFactory.getTipoEstadoDAO().read(entity);

		return TipoEstadoAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }
}
