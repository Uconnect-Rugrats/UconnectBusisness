package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.HistorialLecturaAssembler;
import uco.doo.rugrats.uconnect.busisness.business.HistorialLecturaBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.HistorialLecturaDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.HistorialLecturaEntity;

import java.util.List;

public final class HistorialLecturaBusinessImpl implements HistorialLecturaBusiness {
    DAOFactory daoFactory;
    public HistorialLecturaBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void generar(HistorialLecturaDomain domain) {
        final HistorialLecturaEntity entity = HistorialLecturaAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getHistorialLecturaDAO().create(entity);
    }

    @Override
    public void leerMensaje(HistorialLecturaDomain domain) {

    }

    @Override
    public List<HistorialLecturaDomain> mostrarInformacionMensaje(HistorialLecturaDomain domain) {
    	final HistorialLecturaEntity entity = HistorialLecturaAssembler.getInstance().toEntityFromDomain(domain);

		final List<HistorialLecturaEntity> resultEntityList = daoFactory.getHistorialLecturaDAO().read(entity);

		return HistorialLecturaAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

}
