package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.HistorialChatGrupoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.HistorialChatGrupoBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.HistorialChatGrupoBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.HistorialChatGrupoDomain;
import uco.doo.rugrats.uconnect.busisness.facade.HistorialChatGrupoFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.HistorialChatGrupoDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class HistorialChatGrupoFacadeImpl implements HistorialChatGrupoFacade {
    private final DAOFactory daoFactory;
    private final HistorialChatGrupoBusiness business;

    public HistorialChatGrupoFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new HistorialChatGrupoBusinessImpl(daoFactory);
    }

    @Override
    public void generar(HistorialChatGrupoDTO dto) {
        try {
            daoFactory.initTransaction();
            final HistorialChatGrupoDomain domain = HistorialChatGrupoAssembler.getInstance().toDomainFromDTO(dto);

            business.generar(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.HistorialChatGrupoFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.HistorialChatGrupoFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<HistorialChatGrupoDTO> listar(HistorialChatGrupoDTO dto) {
        try {
            daoFactory.initTransaction();
            final HistorialChatGrupoDomain domainList = HistorialChatGrupoAssembler.getInstance().toDomainFromDTO(dto);

            List<HistorialChatGrupoDomain> lista = business.listar(domainList);

            return HistorialChatGrupoAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.HistorialLecturaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.HistorialLecturaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

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
            var userMessage = Messages.HistorialChatGrupoFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.HistorialChatGrupoFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

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
            var userMessage = Messages.HistorialChatGrupoFacadeImplMessages.USER_MESSAGE_STATE;
            var technicalMessage = Messages.HistorialChatGrupoFacadeImplMessages.TECHNICAL_MESSAGE_STATE;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
