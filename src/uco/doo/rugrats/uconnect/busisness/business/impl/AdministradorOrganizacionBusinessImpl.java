package uco.doo.rugrats.uconnect.busisness.business.impl;


import uco.doo.rugrats.uconnect.busisness.assembler.concrete.AdministradorOrganizacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.AdministradorOrganizacionBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.AdministradorOrganizacionDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.AdministradorOrganizacionEntity;


import java.util.List;

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
        final List<AdministradorOrganizacionEntity> resultado = daoFactory.getAdministradorOrganizacionDAO().read(entity);
        return null;
    }

    @Override
    public void eliminar(AdministradorOrganizacionDomain domain) {
        final AdministradorOrganizacionEntity entity = AdministradorOrganizacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getAdministradorOrganizacionDAO().delete(entity);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
