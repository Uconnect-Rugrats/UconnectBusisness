package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.TipoOrganizacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.TipoOrganizacionBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.TipoOrganizacionDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.TipoOrganizacionEntity;

import java.util.List;

public final class TipoOrganizacionBusinessImpl implements TipoOrganizacionBusiness {
    DAOFactory daoFactory;
    public TipoOrganizacionBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<TipoOrganizacionDomain> consultar(TipoOrganizacionDomain domain) {
    	final TipoOrganizacionEntity entity = TipoOrganizacionAssembler.getInstance().toEntityFromDomain(domain);

		final List<TipoOrganizacionEntity> resultEntityList = daoFactory.getTipoOrganizacionDAO().read(entity);

		return TipoOrganizacionAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }
}
