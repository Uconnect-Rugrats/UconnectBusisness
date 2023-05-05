package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.AgendaAssembler;
import uco.doo.rugrats.uconnect.busisness.business.AgendaBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.AgendaDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.AgendaEntity;

import java.util.List;

public final class AgendaBusinessImpl implements AgendaBusiness {
    DAOFactory daoFactory;
    public AgendaBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void crear(AgendaDomain domain) {
        final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getAgenda().create(entity);
    }

    @Override
    public void modificarFechaFinalizacion(AgendaDomain domain) {
        final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getAgenda().update(entity);
    }

    @Override
    public void cambiarEstado(AgendaDomain domain) {
        final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getAgenda().update(entity);
    }

    @Override
    public List<AgendaDomain> consultar(AgendaDomain domain) {
        final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(domain);
        final List<AgendaEntity> resultado = daoFactory.getAgenda().read(entity);
        return null;
    }

    @Override
    public AgendaDomain abrir(AgendaDomain domain) {
        return null;
    }

    @Override
    public void eliminar(AgendaDomain domain) {
        final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getAgenda().delete(entity);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
