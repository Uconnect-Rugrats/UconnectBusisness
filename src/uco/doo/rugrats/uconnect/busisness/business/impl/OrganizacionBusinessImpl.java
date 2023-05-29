package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.OrganizacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.OrganizacionBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.OrganizacionDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.OrganizacionEntity;

import java.util.List;
import java.util.UUID;

public final class OrganizacionBusinessImpl implements OrganizacionBusiness {
    DAOFactory daoFactory;
    public OrganizacionBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void crearNueva(OrganizacionDomain domain) {
        final OrganizacionEntity entity = OrganizacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getOrganizacionDAO().create(entity);
    }

    @Override
    public void cambiarNombre(OrganizacionDomain domain) {
        final OrganizacionEntity entity = OrganizacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getOrganizacionDAO().update(entity);
    }

    @Override
    public void cambiarEstado(OrganizacionDomain domain) {
        final OrganizacionEntity entity = OrganizacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getOrganizacionDAO().update(entity);
    }

    @Override
    public List<OrganizacionDomain> consultar(OrganizacionDomain domain) {
    	final OrganizacionEntity entity = OrganizacionAssembler.getInstance().toEntityFromDomain(domain);

		final List<OrganizacionEntity> resultEntityList = daoFactory.getOrganizacionDAO().read(entity);

		return OrganizacionAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getOrganizacionDAO().delete(domain);
    }
}
