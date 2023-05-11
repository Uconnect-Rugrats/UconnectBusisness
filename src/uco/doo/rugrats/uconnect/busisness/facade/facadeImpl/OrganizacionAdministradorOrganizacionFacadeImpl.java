package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.OrganizacionAdministradorOrganizacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.OrganizacionAdministradorOrganizacionBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.OrganizacionAdministradorOrganizacionBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.OrganizacionAdministradorOrganizacionDomain;
import uco.doo.rugrats.uconnect.busisness.facade.OrganizacionAdministradorOrganizacionFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.OrganizacionAdministradorOrganizacionDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class OrganizacionAdministradorOrganizacionFacadeImpl implements OrganizacionAdministradorOrganizacionFacade {
    private final DAOFactory daoFactory;
    private final OrganizacionAdministradorOrganizacionBusiness business;

    public OrganizacionAdministradorOrganizacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new OrganizacionAdministradorOrganizacionBusinessImpl(daoFactory);
    }

    @Override
    public void asignarOrganizacion(OrganizacionAdministradorOrganizacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final OrganizacionAdministradorOrganizacionDomain domain = OrganizacionAdministradorOrganizacionAssembler.getInstance().toDomainFromDTO(dto);

            business.asignarOrganizacion(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.OrganizacionAdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.OrganizacionAdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<OrganizacionAdministradorOrganizacionDTO> consultar(OrganizacionAdministradorOrganizacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final OrganizacionAdministradorOrganizacionDomain domainList = OrganizacionAdministradorOrganizacionAssembler.getInstance().toDomainFromDTO(dto);

            List<OrganizacionAdministradorOrganizacionDomain> lista = business.consultar(domainList);

            return OrganizacionAdministradorOrganizacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.OrganizacionAdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.OrganizacionAdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

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
            var userMessage = Messages.OrganizacionAdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.OrganizacionAdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

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
            var userMessage = Messages.OrganizacionAdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_STATE;
            var technicalMessage = Messages.OrganizacionAdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_STATE;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
