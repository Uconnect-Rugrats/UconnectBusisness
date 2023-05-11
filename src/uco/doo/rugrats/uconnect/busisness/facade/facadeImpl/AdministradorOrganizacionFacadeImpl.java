package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.AdministradorOrganizacionAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.AdministradorOrganizacionBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.AdministradorOrganizacionBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.AdministradorOrganizacionDomain;
import uco.doo.rugrats.uconnect.busisness.facade.AdministradorOrganizacionFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.AdministradorOrganizacionDTO;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class AdministradorOrganizacionFacadeImpl implements AdministradorOrganizacionFacade {
    private final DAOFactory daoFactory;
    private final AdministradorOrganizacionBusiness business;

    public AdministradorOrganizacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new AdministradorOrganizacionBusinessImpl(daoFactory);
    }


    @Override
    public void concederPermisos(AdministradorOrganizacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final AdministradorOrganizacionDomain domain = AdministradorOrganizacionAssembler.getInstance().toDomainFromDTO(dto);

            business.concederPermisos(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.AdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.AdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void cambiarEstado(AdministradorOrganizacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final AdministradorOrganizacionDomain domain = AdministradorOrganizacionAssembler.getInstance().toDomainFromDTO(dto);

            business.cambiarEstado(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.AdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.AdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<AdministradorOrganizacionDTO> consultar(AdministradorOrganizacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final AdministradorOrganizacionDomain domainList = AdministradorOrganizacionAssembler.getInstance().toDomainFromDTO(dto);

            List<AdministradorOrganizacionDomain> lista = business.consultar(domainList);

            return AdministradorOrganizacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.AdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.AdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

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
            var userMessage = Messages.AdministradorEstructuraFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.AdministradorEstructuraFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

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
            var userMessage = Messages.AdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_STATE;
            var technicalMessage = Messages.AdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_STATE;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
