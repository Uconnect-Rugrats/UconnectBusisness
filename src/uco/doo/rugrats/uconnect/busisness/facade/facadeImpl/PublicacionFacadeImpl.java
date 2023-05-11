package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.PublicacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.PublicacionBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.PublicacionBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.PublicacionDomain;
import uco.doo.rugrats.uconnect.busisness.facade.PublicacionFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.PublicacionDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PublicacionFacadeImpl implements PublicacionFacade {
    private final DAOFactory daoFactory;
    private final PublicacionBusiness business;

    public PublicacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PublicacionBusinessImpl(daoFactory);
    }

    @Override
    public void publicar(PublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PublicacionDomain domain = PublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.publicar(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PublicacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void cambiarEstado(PublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PublicacionDomain domain = PublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.cambiarEstado(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PublicacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<PublicacionDTO> listar(PublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PublicacionDomain domainList = PublicacionAssembler.getInstance().toDomainFromDTO(dto);

            List<PublicacionDomain> lista = business.listar(domainList);

            return PublicacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PublicacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public PublicacionDTO abrir(PublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            PublicacionDomain publicacionDomain = PublicacionAssembler.getInstance().toDomainFromDTO(dto);
            daoFactory.commitTransaction();
            return PublicacionAssembler.getInstance().toDTOFromDomain(business.abrir(publicacionDomain));


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_STATE;
            var technicalMessage = Messages.PublicacionFacadeImplMessages.TECHNICAL_MESSAGE_STATE;

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
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PublicacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

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
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_STATE;
            var technicalMessage = Messages.PublicacionFacadeImplMessages.TECHNICAL_MESSAGE_STATE;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}