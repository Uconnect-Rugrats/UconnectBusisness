package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.HistorialChatGrupoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.HistorialChatGrupoBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.HistorialChatGrupoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.HistorialChatGrupoEntity;

import java.util.List;

public final class HistorialChatGrupoBusinessImpl implements HistorialChatGrupoBusiness {
    DAOFactory daoFactory;
    public HistorialChatGrupoBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void generar(HistorialChatGrupoDomain domain) {
        final HistorialChatGrupoEntity entity = HistorialChatGrupoAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getHistorialChatGrupoDAO().create(entity);
    }

    @Override
    public List<HistorialChatGrupoDomain> Listar(HistorialChatGrupoDomain domain) {
        final HistorialChatGrupoEntity entity = HistorialChatGrupoAssembler.getInstance().toEntityFromDomain(domain);
        final List<HistorialChatGrupoEntity> resultado = daoFactory.getHistorialChatGrupoDAO().read(entity);
        return null;
    }

    @Override
    public void eliminar(HistorialChatGrupoDomain domain) {
        final HistorialChatGrupoEntity entity = HistorialChatGrupoAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getHistorialChatGrupoDAO().delete(entity);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}