package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.OrganizacionAdministradorOrganizacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.OrganizacionAdministradorOrganizacionBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.OrganizacionAdministradorOrganizacionDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.OrganizacionAdministradorOrganizacionEntity;

import java.util.List;
import java.util.UUID;

public final class OrganizacionAdministradorOrganizacionBusinessImpl implements OrganizacionAdministradorOrganizacionBusiness{
    DAOFactory daoFactory;
    public OrganizacionAdministradorOrganizacionBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    @Override
    public void asignarOrganizacion(OrganizacionAdministradorOrganizacionDomain domain) {
        final OrganizacionAdministradorOrganizacionEntity entity = OrganizacionAdministradorOrganizacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getOrganizacionAdministradorOrganizacionDAO().create(entity);
    }

    @Override
    public List<OrganizacionAdministradorOrganizacionDomain> consultar(OrganizacionAdministradorOrganizacionDomain domain) {
        final OrganizacionAdministradorOrganizacionEntity entity = OrganizacionAdministradorOrganizacionAssembler.getInstance().toEntityFromDomain(domain);
        final List<OrganizacionAdministradorOrganizacionEntity> resultado = daoFactory.getOrganizacionAdministradorOrganizacionDAO().read(entity);
        return null;
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getOrganizacionAdministradorOrganizacionDAO().delete(domain);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
