package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.TipoReaccionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.TipoReaccionBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.TipoReaccionBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.TipoReaccionDomain;
import uco.doo.rugrats.uconnect.busisness.facade.TipoReaccionFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.TipoReaccionDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;

public final class TipoReaccionFacadeImpl implements TipoReaccionFacade {
    private final DAOFactory daoFactory;
    private final TipoReaccionBusiness business;

    public TipoReaccionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoReaccionBusinessImpl(daoFactory);
    }

    @Override
    public List<TipoReaccionDTO> consultar(TipoReaccionDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoReaccionDomain domainList = TipoReaccionAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoReaccionDomain> lista = business.consultar(domainList);

            return TipoReaccionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.TipoReaccionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoReaccionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
