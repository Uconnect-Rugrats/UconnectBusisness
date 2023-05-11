package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.OrganizacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.OrganizacionBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.OrganizacionBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.OrganizacionDomain;
import uco.doo.rugrats.uconnect.busisness.facade.OrganizacionFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.OrganizacionDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class OrganizacionFacadeImpl implements OrganizacionFacade {
    private final DAOFactory daoFactory;
    private final OrganizacionBusiness business;

    public OrganizacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new OrganizacionBusinessImpl(daoFactory);
    }

    @Override
    public void crearNueva(OrganizacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final OrganizacionDomain domain = OrganizacionAssembler.getInstance().toDomainFromDTO(dto);

            business.crearNueva(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.OrganizacionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.OrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void cambiarNombre(OrganizacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final OrganizacionDomain domain = OrganizacionAssembler.getInstance().toDomainFromDTO(dto);

            business.cambiarNombre(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.OrganizacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.OrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void cambiarEstado(OrganizacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final OrganizacionDomain domain = OrganizacionAssembler.getInstance().toDomainFromDTO(dto);

            business.cambiarEstado(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.OrganizacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.OrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<OrganizacionDTO> consultar(OrganizacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final OrganizacionDomain domainList = OrganizacionAssembler.getInstance().toDomainFromDTO(dto);

            List<OrganizacionDomain> lista = business.consultar(domainList);

            return OrganizacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.OrganizacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.OrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

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
            var userMessage = Messages.OrganizacionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.OrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
