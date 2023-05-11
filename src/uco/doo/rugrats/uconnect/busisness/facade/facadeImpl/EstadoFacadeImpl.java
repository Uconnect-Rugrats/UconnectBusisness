package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.EstadoBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.EstadoBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.facade.EstadoFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;

public final class EstadoFacadeImpl implements EstadoFacade {
    private final DAOFactory daoFactory;
    private final EstadoBusiness business;

    public EstadoFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new EstadoBusinessImpl(daoFactory);
    }

    @Override
    public List<EstadoDTO> consultar(EstadoDTO dto) {
        try {
            daoFactory.initTransaction();
            final EstadoDomain domainList = EstadoAssembler.getInstance().toDomainFromDTO(dto);

            List<EstadoDomain> lista = business.consultar(domainList);

            return EstadoAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EstadoFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.EstadoFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
