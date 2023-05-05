package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.PaisAssembler;
import uco.doo.rugrats.uconnect.busisness.business.PaisBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.PaisDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.PaisEntity;

import java.util.List;

public final class PaisBusinessImpl implements PaisBusiness {
    DAOFactory daoFactory;
    public PaisBusinessImpl (final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<PaisDomain> consultar(PaisDomain domain) {
        final PaisEntity entity = PaisAssembler.getInstance().toEntityFromDomain(domain);
        final List<PaisEntity> resultado = daoFactory.getPaisDAO().read(entity);
        return null;
    }
}
