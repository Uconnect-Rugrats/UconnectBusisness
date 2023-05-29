package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstructuraAdministradorEstructuraAssembler;
import uco.doo.rugrats.uconnect.busisness.business.EstructuraAdministradorEstructuraBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstructuraAdministradorEstructuraDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.EstructuraAdministradorEstructuraEntity;

import java.util.List;
import java.util.UUID;

public final class EstructuraAdministradorEstructuraBusinessImpl implements EstructuraAdministradorEstructuraBusiness {
    DAOFactory daoFactory;
    public EstructuraAdministradorEstructuraBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void asignarEstructura(EstructuraAdministradorEstructuraDomain domain) {
        final EstructuraAdministradorEstructuraEntity entity = EstructuraAdministradorEstructuraAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getEstructuraAdministradorEstructuraDAO().create(entity);
    }

    @Override
    public List<EstructuraAdministradorEstructuraDomain> consultar(EstructuraAdministradorEstructuraDomain domain) {
    	final EstructuraAdministradorEstructuraEntity entity = EstructuraAdministradorEstructuraAssembler.getInstance().toEntityFromDomain(domain);

		final List<EstructuraAdministradorEstructuraEntity> resultEntityList = daoFactory.getEstructuraAdministradorEstructuraDAO().read(entity);

		return EstructuraAdministradorEstructuraAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getEstructuraAdministradorEstructuraDAO().delete(domain);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
