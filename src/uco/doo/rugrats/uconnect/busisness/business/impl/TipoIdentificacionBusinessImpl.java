package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.TipoIdentificacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.TipoIdentificacionBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.TipoIdentificacionDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.TipoIdentificacionEntity;

import java.util.List;

public final class TipoIdentificacionBusinessImpl implements TipoIdentificacionBusiness {
    DAOFactory daoFactory;
    public TipoIdentificacionBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<TipoIdentificacionDomain> consultar(TipoIdentificacionDomain domain) {
    	final TipoIdentificacionEntity entity = TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain);

		final List<TipoIdentificacionEntity> resultEntityList = daoFactory.getTipoIdentificacionDAO().read(entity);

		return TipoIdentificacionAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }
}
