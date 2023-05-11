package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.TipoIdentificacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.TipoIdentificacionBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.TipoIdentificacionBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.TipoIdentificacionDomain;
import uco.doo.rugrats.uconnect.busisness.facade.TipoIdentificacionFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.TipoIdentificacionDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;

public final class TipoIdentificacionFacadeImpl implements TipoIdentificacionFacade {
    private final DAOFactory daoFactory;
    private final TipoIdentificacionBusiness business;

    public TipoIdentificacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoIdentificacionBusinessImpl(daoFactory);
    }


    @Override
    public List<TipoIdentificacionDTO> consultar(TipoIdentificacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoIdentificacionDomain domainList = TipoIdentificacionAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoIdentificacionDomain> lista = business.consultar(domainList);

            return TipoIdentificacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.TipoIdentificacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoIdentificacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
