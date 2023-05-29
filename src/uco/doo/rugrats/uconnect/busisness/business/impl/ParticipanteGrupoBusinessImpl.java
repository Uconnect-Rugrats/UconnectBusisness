package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ParticipanteGrupoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ParticipanteGrupoBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ParticipanteGrupoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.ParticipanteGrupoEntity;

import java.util.List;
import java.util.UUID;

public final class ParticipanteGrupoBusinessImpl implements ParticipanteGrupoBusiness {
    DAOFactory daoFactory;
    public ParticipanteGrupoBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void asignarGrupo(ParticipanteGrupoDomain domain) {
        final ParticipanteGrupoEntity entity = ParticipanteGrupoAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getParticipanteGrupoDAO().create(entity);
    }

    @Override
    public List<ParticipanteGrupoDomain> consultar(ParticipanteGrupoDomain domain) {
    	final ParticipanteGrupoEntity entity = ParticipanteGrupoAssembler.getInstance().toEntityFromDomain(domain);

		final List<ParticipanteGrupoEntity> resultEntityList = daoFactory.getParticipanteGrupoDAO().read(entity);

		return ParticipanteGrupoAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getParticipanteGrupoDAO().delete(domain);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
