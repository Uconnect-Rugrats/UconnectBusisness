package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.AgendaAssembler;
import uco.doo.rugrats.uconnect.busisness.business.AgendaBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.AgendaDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.AgendaEntity;

import java.util.List;
import java.util.UUID;

public final class AgendaBusinessImpl implements AgendaBusiness {
    DAOFactory daoFactory;
    public AgendaBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void crear(AgendaDomain domain) {
        final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getAgendaDAO().create(entity);
    }

    @Override
    public void modificarFechaFinalizacion(AgendaDomain domain) {
        final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getAgendaDAO().update(entity);
    }

    @Override
    public void cambiarEstado(AgendaDomain domain) {
        final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getAgendaDAO().update(entity);
    }

    @Override
    public List<AgendaDomain> consultar(AgendaDomain domain) {
    	final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(domain);

		final List<AgendaEntity> resultEntityList = daoFactory.getAgendaDAO().read(entity);

		return AgendaAssembler.getInstance().toDomainFromEntityList(resultEntityList);
   
    }

    @Override
    public AgendaDomain abrir(AgendaDomain domain) {
        return null;
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getAgendaDAO().delete(domain);
    }

   
}
