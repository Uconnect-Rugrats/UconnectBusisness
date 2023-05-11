package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.TipoEventoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.TipoEventoBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.TipoEventoBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.TipoEventoDomain;
import uco.doo.rugrats.uconnect.busisness.facade.TipoEventoFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.TipoEventoDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;

public final class TipoEventoFacadeImpl implements TipoEventoFacade {
    private final DAOFactory daoFactory;
    private final TipoEventoBusiness business;

    public TipoEventoFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoEventoBusinessImpl(daoFactory);
    }

    @Override
    public List<TipoEventoDTO> consultar(TipoEventoDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoEventoDomain domainList = TipoEventoAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoEventoDomain> lista = business.consultar(domainList);

            return TipoEventoAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.TipoEventoFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoEventoFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
