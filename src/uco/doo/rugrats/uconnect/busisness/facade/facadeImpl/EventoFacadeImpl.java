package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EventoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.EventoBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.EventoBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.EventoDomain;
import uco.doo.rugrats.uconnect.busisness.facade.EventoFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.EventoDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class EventoFacadeImpl implements EventoFacade {
    private final DAOFactory daoFactory;
    private final EventoBusiness business;

    public EventoFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new EventoBusinessImpl(daoFactory);
    }

    @Override
    public void crear(EventoDTO dto) {
        try {
            daoFactory.initTransaction();
            final EventoDomain domain = EventoAssembler.getInstance().toDomainFromDTO(dto);

            business.crear(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EventoFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.EventoFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void editar(EventoDTO dto) {
        try {
            daoFactory.initTransaction();
            final EventoDomain domain = EventoAssembler.getInstance().toDomainFromDTO(dto);

            business.editar(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EventoFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.EventoFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void cambiarEstado(EventoDTO dto) {
        try {
            daoFactory.initTransaction();
            final EventoDomain domain = EventoAssembler.getInstance().toDomainFromDTO(dto);

            business.cambiarEstado(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EventoFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.EventoFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<EventoDTO> abrir(EventoDTO dto) {
        try {
            daoFactory.initTransaction();
            final EventoDomain domainList = EventoAssembler.getInstance().toDomainFromDTO(dto);

            List<EventoDomain> lista = business.abrir(domainList);

            return EventoAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EventoFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.EventoFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void eliminar(UUID dto) {
        try {
            daoFactory.initTransaction();

            business.eliminar(dto);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EventoFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.EventoFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public EstadoDTO obtenerEstadoReal() {
        try {
            daoFactory.initTransaction();
            EstadoDTO dto = EstadoAssembler.getInstance().toDTOFromDomain(business.obtenerEstadoReal());
            daoFactory.commitTransaction();
            return dto;


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EventoFacadeImplMessages.USER_MESSAGE_STATE;
            var technicalMessage = Messages.EventoFacadeImplMessages.TECHNICAL_MESSAGE_STATE;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
