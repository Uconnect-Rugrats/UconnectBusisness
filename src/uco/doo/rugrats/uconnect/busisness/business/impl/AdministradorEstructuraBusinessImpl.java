package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.AdministradorEstructuraAssembler;
import uco.doo.rugrats.uconnect.busisness.business.AdministradorEstructuraBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.AdministradorEstructuraDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.AdministradorEstructuraEntity;

import java.util.List;
import java.util.UUID;

public final class AdministradorEstructuraBusinessImpl implements AdministradorEstructuraBusiness {

    DAOFactory daoFactory;
    public AdministradorEstructuraBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    @Override
    public void concederPermisos(AdministradorEstructuraDomain domain) {
        final AdministradorEstructuraEntity entity = AdministradorEstructuraAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getAdministradorEstructuraDAO().create(entity);
    }

    @Override
    public void cambiarEstado(AdministradorEstructuraDomain domain) {
        final AdministradorEstructuraEntity entity = AdministradorEstructuraAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getAdministradorEstructuraDAO().update(entity);
    }

    @Override
    public List<AdministradorEstructuraDomain> consultar(AdministradorEstructuraDomain domain) {
        final AdministradorEstructuraEntity entity = AdministradorEstructuraAssembler.getInstance().toEntityFromDomain(domain);
        final List<AdministradorEstructuraEntity> resultado = daoFactory.getAdministradorEstructuraDAO().read(entity);
        return null;
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getAdministradorEstructuraDAO().delete(domain);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
