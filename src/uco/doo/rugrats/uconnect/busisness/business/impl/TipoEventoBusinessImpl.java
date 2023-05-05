package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.TipoEventoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.TipoEventoBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.TipoEventoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.TipoEventoEntity;

import java.util.List;

public final class TipoEventoBusinessImpl implements TipoEventoBusiness {
    DAOFactory daoFactory;
    public TipoEventoBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    @Override
    public List<TipoEventoDomain> consultar(TipoEventoDomain domain) {
        final TipoEventoEntity entity = TipoEventoAssembler.getInstance().toEntityFromDomain(domain);
        final List<TipoEventoEntity> resultado = daoFactory.getTipoEventoDAO().read(entity);
        return null;
    }
}
