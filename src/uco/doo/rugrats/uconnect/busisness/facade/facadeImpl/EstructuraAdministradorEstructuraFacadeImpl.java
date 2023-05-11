package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstructuraAdministradorEstructuraAssembler;
import uco.doo.rugrats.uconnect.busisness.business.EstructuraAdministradorEstructuraBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.EstructuraAdministradorEstructuraBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.EstructuraAdministradorEstructuraDomain;
import uco.doo.rugrats.uconnect.busisness.facade.EstructuraAdministradorEstructuraFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.EstructuraAdministradorEstructuraDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class EstructuraAdministradorEstructuraFacadeImpl implements EstructuraAdministradorEstructuraFacade {
    private final DAOFactory daoFactory;
    private final EstructuraAdministradorEstructuraBusiness business;

    public EstructuraAdministradorEstructuraFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new EstructuraAdministradorEstructuraBusinessImpl(daoFactory);
    }

    @Override
    public void asignarEstructura(EstructuraAdministradorEstructuraDTO dto) {
        try {
            daoFactory.initTransaction();
            final EstructuraAdministradorEstructuraDomain domain = EstructuraAdministradorEstructuraAssembler.getInstance().toDomainFromDTO(dto);

            business.asignarEstructura(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EstructuraAdministradorEstructuraFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.EstructuraAdministradorEstructuraFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<EstructuraAdministradorEstructuraDTO> consultar(EstructuraAdministradorEstructuraDTO dto) {
        try {
            daoFactory.initTransaction();
            final EstructuraAdministradorEstructuraDomain domainList = EstructuraAdministradorEstructuraAssembler.getInstance().toDomainFromDTO(dto);

            List<EstructuraAdministradorEstructuraDomain> lista = business.consultar(domainList);

            return EstructuraAdministradorEstructuraAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EstructuraAdministradorEstructuraFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.EstructuraAdministradorEstructuraFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

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
            var userMessage = Messages.EstructuraAdministradorEstructuraFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.EstructuraAdministradorEstructuraFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

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
            var userMessage = Messages.EstructuraAdministradorEstructuraFacadeImplMessages.USER_MESSAGE_STATE;
            var technicalMessage = Messages.EstructuraAdministradorEstructuraFacadeImplMessages.TECHNICAL_MESSAGE_STATE;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
