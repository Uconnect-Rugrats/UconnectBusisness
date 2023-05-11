package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ParticipanteAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ParticipanteBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ParticipanteDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.ParticipanteEntity;

import java.util.List;
import java.util.UUID;

public final class ParticipanteBusinessImpl implements ParticipanteBusiness {
    DAOFactory daoFactory;
    public ParticipanteBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void registrar(ParticipanteDomain domain) {
        final ParticipanteEntity entity = ParticipanteAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getParticipanteDAO().create(entity);
    }

    @Override
    public void cambiarEstado(ParticipanteDomain domain) {
        final ParticipanteEntity entity = ParticipanteAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getParticipanteDAO().update(entity);
    }

    @Override
    public List<ParticipanteDomain> consultar(ParticipanteDomain domain) {
        final ParticipanteEntity entity = ParticipanteAssembler.getInstance().toEntityFromDomain(domain);
        final List<ParticipanteEntity> resultado = daoFactory.getParticipanteDAO().read(entity);
        return null;
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getParticipanteDAO().delete(domain);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
