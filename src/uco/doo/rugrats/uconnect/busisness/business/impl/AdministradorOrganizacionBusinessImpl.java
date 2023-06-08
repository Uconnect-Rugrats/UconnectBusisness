package uco.doo.rugrats.uconnect.busisness.business.impl;


import uco.doo.rugrats.uconnect.busisness.assembler.concrete.AdministradorOrganizacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.AdministradorOrganizacionBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.AdministradorOrganizacionDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.AdministradorOrganizacionEntity;


import java.util.List;
import java.util.UUID;

public final class AdministradorOrganizacionBusinessImpl implements AdministradorOrganizacionBusiness {
    DAOFactory daoFactory;
    public AdministradorOrganizacionBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    @Override
    public void concederPermisos(AdministradorOrganizacionDomain domain) {
        final AdministradorOrganizacionEntity entity = AdministradorOrganizacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getAdministradorOrganizacionDAO().create(entity);
    }

    @Override
    public void cambiarEstado(AdministradorOrganizacionDomain domain) {
        final AdministradorOrganizacionEntity entity = AdministradorOrganizacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getAdministradorOrganizacionDAO().update(entity);
    }

    @Override
    public List<AdministradorOrganizacionDomain> consultar(AdministradorOrganizacionDomain domain) {
    	final AdministradorOrganizacionEntity entity = AdministradorOrganizacionAssembler.getInstance().toEntityFromDomain(domain);

		final List<AdministradorOrganizacionEntity> resultEntityList = daoFactory.getAdministradorOrganizacionDAO().read(entity);

		return AdministradorOrganizacionAssembler.getInstance().toDomainFromEntityList(resultEntityList);
   
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getAdministradorOrganizacionDAO().delete(domain);
    }

}
