package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.PublicacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.PublicacionBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.PublicacionDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.PublicacionEntity;

import java.util.List;
import java.util.UUID;

public final class PublicacionBusinessImpl implements PublicacionBusiness {
    DAOFactory daoFactory;
    public PublicacionBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void publicar(PublicacionDomain domain) {
        final PublicacionEntity entity = PublicacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getPublicacionDAO().create(entity);
    }

    @Override
    public void cambiarEstado(PublicacionDomain domain) {
        final PublicacionEntity entity = PublicacionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getPublicacionDAO().update(entity);
    }

    @Override
    public List<PublicacionDomain> listar(PublicacionDomain domain) {
    	final PublicacionEntity entity = PublicacionAssembler.getInstance().toEntityFromDomain(domain);

		final List<PublicacionEntity> resultEntityList = daoFactory.getPublicacionDAO().read(entity);

		return PublicacionAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public PublicacionDomain abrir(PublicacionDomain domain) {
        return null;
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getPublicacionDAO().delete(domain);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
