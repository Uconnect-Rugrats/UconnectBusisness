package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstructuraAssembler;
import uco.doo.rugrats.uconnect.busisness.business.EstructuraBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstructuraDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.EstructuraEntity;

import java.util.List;
import java.util.UUID;

public final class EstructuraBusinessImpl implements EstructuraBusiness {
    DAOFactory daoFactory;
    public EstructuraBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void crearNueva(EstructuraDomain domain) {
        final EstructuraEntity entity = EstructuraAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getEstructuraDAO().create(entity);
    }

    @Override
    public void cambiarNombre(EstructuraDomain domain) {
        final EstructuraEntity entity = EstructuraAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getEstructuraDAO().update(entity);
    }

    @Override
    public void cambiarEstado(EstructuraDomain domain) {
        final EstructuraEntity entity = EstructuraAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getEstructuraDAO().update(entity);
    }

    @Override
    public List<EstructuraDomain> consultar(EstructuraDomain domain) {
    	final EstructuraEntity entity = EstructuraAssembler.getInstance().toEntityFromDomain(domain);

		final List<EstructuraEntity> resultEntityList = daoFactory.getEstructuraDAO().read(entity);

		return EstructuraAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getEstructuraDAO().delete(domain);
    }

 
}
