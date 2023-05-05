package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EventoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.EventoBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EventoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.EventoEntity;

import java.util.List;

public final class EventoBusinessImpl implements EventoBusiness {
    DAOFactory daoFactory;
    public EventoBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void crear(EventoDomain domain) {
        final EventoEntity entity = EventoAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getEventoDAO().create(entity);
    }

    @Override
    public void editar(EventoDomain domain) {
        final EventoEntity entity = EventoAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getEventoDAO().update(entity);
    }

    @Override
    public void cambiarEstado(EventoDomain domain) {
        final EventoEntity entity = EventoAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getEventoDAO().update(entity);
    }

    @Override
    public List<EventoDomain> abrir(EventoDomain domain) {
        final EventoEntity entity = EventoAssembler.getInstance().toEntityFromDomain(domain);
        final List<EventoEntity> resultado = daoFactory.getEventoDAO().read(entity);
        return null;
    }

    @Override
    public void eliminar(EventoDomain domain) {
        final EventoEntity entity = EventoAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getEventoDAO().delete(entity);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
