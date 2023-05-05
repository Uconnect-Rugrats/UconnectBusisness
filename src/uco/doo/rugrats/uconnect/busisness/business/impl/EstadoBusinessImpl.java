package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.EstadoBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.EstadoEntity;

import java.util.List;

public final class EstadoBusinessImpl implements EstadoBusiness {
    DAOFactory daoFactory;
    public EstadoBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<EstadoDomain> consultar(EstadoDomain domain) {
        final EstadoEntity entity = EstadoAssembler.getInstance().toEntityFromDomain(domain);
        final List<EstadoEntity> resultado = daoFactory.getEstadoDAO().read(entity);
        return null;
    }
}
