package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.MensajeAssembler;
import uco.doo.rugrats.uconnect.busisness.business.MensajeBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.MensajeDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.MensajeEntity;

import java.util.List;
import java.util.UUID;

public final class MensajeBusinessImpl implements MensajeBusiness {
    DAOFactory daoFactory;
    public MensajeBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void enviar(MensajeDomain domain) {
        final MensajeEntity entity = MensajeAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getMensajeDAO().create(entity);
    }

    @Override
    public void cambiarEstado(MensajeDomain domain) {
        final MensajeEntity entity = MensajeAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getMensajeDAO().update(entity);
    }

    @Override
    public List<MensajeDomain> cargar(MensajeDomain domain) {
    	final MensajeEntity entity = MensajeAssembler.getInstance().toEntityFromDomain(domain);

		final List<MensajeEntity> resultEntityList = daoFactory.getMensajeDAO().read(entity);

		return MensajeAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getMensajeDAO().delete(domain);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
