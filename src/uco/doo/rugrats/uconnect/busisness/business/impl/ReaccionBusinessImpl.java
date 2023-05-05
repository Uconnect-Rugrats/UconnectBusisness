package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ReaccionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ReaccionBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ReaccionDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.ReaccionEntity;

import java.util.List;

public final class ReaccionBusinessImpl implements ReaccionBusiness {
    DAOFactory daoFactory;
    public ReaccionBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void reaccionar(ReaccionDomain domain) {
        final ReaccionEntity entity = ReaccionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getReaccionDAO().create(entity);
    }

    @Override
    public List<ReaccionDomain> mostrar(ReaccionDomain domain) {
        final ReaccionEntity entity = ReaccionAssembler.getInstance().toEntityFromDomain(domain);
        final List<ReaccionEntity> resultado = daoFactory.getReaccionDAO().read(entity);
        return null;
    }

    @Override
    public void eliminar(ReaccionDomain domain) {
        final ReaccionEntity entity = ReaccionAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getReaccionDAO().delete(entity);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
