package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.MensajeAssembler;
import uco.doo.rugrats.uconnect.busisness.business.MensajeBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.MensajeBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.MensajeDomain;
import uco.doo.rugrats.uconnect.busisness.facade.MensajeFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.MensajeDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class MensajeFacadeImpl implements MensajeFacade {
    private final DAOFactory daoFactory;
    private final MensajeBusiness business;

    public MensajeFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new MensajeBusinessImpl(daoFactory);
    }

    @Override
    public void enviar(MensajeDTO dto) {
        try {
            daoFactory.initTransaction();
            final MensajeDomain domain = MensajeAssembler.getInstance().toDomainFromDTO(dto);

            business.enviar(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.MensajeFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.MensajeFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void cambiarEstado(MensajeDTO dto) {
        try {
            daoFactory.initTransaction();
            final MensajeDomain domain = MensajeAssembler.getInstance().toDomainFromDTO(dto);

            business.cambiarEstado(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.MensajeFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.MensajeFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<MensajeDTO> cargar(MensajeDTO dto) {
        try {
            daoFactory.initTransaction();
            final MensajeDomain domainList = MensajeAssembler.getInstance().toDomainFromDTO(dto);

            List<MensajeDomain> lista = business.cargar(domainList);

            return MensajeAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.MensajeFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.MensajeFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

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
            var userMessage = Messages.MensajeFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.MensajeFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

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
            var userMessage = Messages.MensajeFacadeImplMessages.USER_MESSAGE_STATE;
            var technicalMessage = Messages.MensajeFacadeImplMessages.TECHNICAL_MESSAGE_STATE;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
