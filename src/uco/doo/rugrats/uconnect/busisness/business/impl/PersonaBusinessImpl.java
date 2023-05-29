package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.PersonaAssembler;
import uco.doo.rugrats.uconnect.busisness.business.PersonaBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.PersonaDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.PersonaEntity;

import java.util.List;
import java.util.UUID;

public final class PersonaBusinessImpl implements PersonaBusiness {
    DAOFactory daoFactory;
    public PersonaBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void registrar(PersonaDomain domain) {
        final PersonaEntity entity = PersonaAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getPersonaDAO().create(entity);
    }

    @Override
    public void editar(PersonaDomain domain) {
        final PersonaEntity entity = PersonaAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getPersonaDAO().update(entity);
    }

    @Override
    public void cambiarEstado(PersonaDomain domain) {
        final PersonaEntity entity = PersonaAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getPersonaDAO().update(entity);
    }

    @Override
    public List<PersonaDomain> consultar(PersonaDomain domain) {
    	final PersonaEntity entity = PersonaAssembler.getInstance().toEntityFromDomain(domain);

		final List<PersonaEntity> resultEntityList = daoFactory.getPersonaDAO().read(entity);

		return PersonaAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getPersonaDAO().delete(domain);
    }
}
