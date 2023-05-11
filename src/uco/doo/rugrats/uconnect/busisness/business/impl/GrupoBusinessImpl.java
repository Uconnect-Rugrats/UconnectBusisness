package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.GrupoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.GrupoBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.GrupoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.GrupoEntity;

import java.util.List;
import java.util.UUID;

public final class GrupoBusinessImpl implements GrupoBusiness {
    DAOFactory daoFactory;
    public GrupoBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void crear(GrupoDomain domain) {
        final GrupoEntity entity = GrupoAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getGrupoDAO().create(entity);
    }

    @Override
    public void editar(GrupoDomain domain) {
        final GrupoEntity entity = GrupoAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getGrupoDAO().update(entity);
    }

    @Override
    public void cambiarEstado(GrupoDomain domain) {
        final GrupoEntity entity = GrupoAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getGrupoDAO().update(entity);
    }

    @Override
    public List<GrupoDomain> buscar(GrupoDomain domain) {
        final GrupoEntity entity = GrupoAssembler.getInstance().toEntityFromDomain(domain);
        final List<GrupoEntity> resultado = daoFactory.getGrupoDAO().read(entity);
        return null;
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getGrupoDAO().delete(domain);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
