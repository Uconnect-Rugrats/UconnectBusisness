package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstructuraAssembler;
import uco.doo.rugrats.uconnect.busisness.business.EstructuraBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.EstructuraBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.EstructuraDomain;
import uco.doo.rugrats.uconnect.busisness.facade.EstructuraFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.EstructuraDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class EstructuraFacadeImpl implements EstructuraFacade {
    private final DAOFactory daoFactory;
    private final EstructuraBusiness business;

    public EstructuraFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new EstructuraBusinessImpl(daoFactory);
    }

    @Override
    public void crearNueva(EstructuraDTO dto) {
        try {
            daoFactory.initTransaction();
            final EstructuraDomain domain = EstructuraAssembler.getInstance().toDomainFromDTO(dto);

            business.crearNueva(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EstructuraFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.EstructuraFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void cambiarNombre(EstructuraDTO dto) {
        try {
            daoFactory.initTransaction();
            final EstructuraDomain domain = EstructuraAssembler.getInstance().toDomainFromDTO(dto);

            business.cambiarNombre(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EstructuraFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.EstructuraFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void cambiarEstado(EstructuraDTO dto) {
        try {
            daoFactory.initTransaction();
            final EstructuraDomain domain = EstructuraAssembler.getInstance().toDomainFromDTO(dto);

            business.cambiarEstado(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EstructuraFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.EstructuraFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<EstructuraDTO> consultar(EstructuraDTO dto) {
        try {
            daoFactory.initTransaction();
            final EstructuraDomain domainList = EstructuraAssembler.getInstance().toDomainFromDTO(dto);

            List<EstructuraDomain> lista = business.consultar(domainList);

            return EstructuraAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EstructuraFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.EstructuraFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

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
            var userMessage = Messages.EstructuraFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.EstructuraFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

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
            var userMessage = Messages.EstructuraFacadeImplMessages.USER_MESSAGE_STATE;
            var technicalMessage = Messages.EstructuraFacadeImplMessages.TECHNICAL_MESSAGE_STATE;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
