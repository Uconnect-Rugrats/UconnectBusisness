package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ComentarioAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ComentarioBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.ComentarioDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.ComentarioEntity;

import java.util.List;

public final class ComentarioBusinessImpl implements ComentarioBusiness {
    DAOFactory daoFactory;

    public ComentarioBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    @Override
    public void comentar(ComentarioDomain domain) {
        final ComentarioEntity entity = ComentarioAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getComentarioDAO().create(entity);
    }

    @Override
    public void cambiarEstado(ComentarioDomain domain) {
        final ComentarioEntity entity = ComentarioAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getComentarioDAO().update(entity);
    }

    @Override
    public List<ComentarioDomain> consultar(ComentarioDomain domain) {
        final ComentarioEntity entity = ComentarioAssembler.getInstance().toEntityFromDomain(domain);
        final List<ComentarioEntity> resultado = daoFactory.getComentarioDAO().read(entity);
        return null;
    }

    @Override
    public void eliminar(ComentarioDomain domain) {
        final ComentarioEntity entity = ComentarioAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getComentarioDAO().delete(entity);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}