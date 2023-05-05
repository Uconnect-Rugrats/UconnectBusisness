package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.TipoReaccionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.TipoReaccionBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.TipoReaccionDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.TipoReaccionEntity;

import java.util.List;

public final class TipoReaccionBusinessImpl implements TipoReaccionBusiness {
    DAOFactory daoFactory;
    public TipoReaccionBusinessImpl (final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<TipoReaccionDomain> consultar(TipoReaccionDomain domain) {
        final TipoReaccionEntity entity = TipoReaccionAssembler.getInstance().toEntityFromDomain(domain);
        final List<TipoReaccionEntity> resultado = daoFactory.getTipoReaccionDAO().read(entity);
        return null;
    }
}
