package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ReporteMensajeAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ReporteMensajeBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.ReporteMensajeBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.ReporteMensajeDomain;
import uco.doo.rugrats.uconnect.busisness.facade.ReporteMensajeFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.ReporteMensajeDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;

public final class ReporteMensajeFacadeImpl implements ReporteMensajeFacade {
    private final DAOFactory daoFactory;
    private final ReporteMensajeBusiness business;

    public ReporteMensajeFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new ReporteMensajeBusinessImpl(daoFactory);
    }

    @Override
    public void reportar(ReporteMensajeDTO dto) {
        try {
            daoFactory.initTransaction();
            final ReporteMensajeDomain domain = ReporteMensajeAssembler.getInstance().toDomainFromDTO(dto);

            business.reportar(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ReporteMensajeFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.ReporteMensajeFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void cambiarEstado(ReporteMensajeDTO dto) {
        try {
            daoFactory.initTransaction();
            final ReporteMensajeDomain domain = ReporteMensajeAssembler.getInstance().toDomainFromDTO(dto);

            business.cambiarEstado(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ReporteMensajeFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.ReporteMensajeFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<ReporteMensajeDTO> abrir(ReporteMensajeDTO dto) {
        try {
            daoFactory.initTransaction();
            final ReporteMensajeDomain domainList = ReporteMensajeAssembler.getInstance().toDomainFromDTO(dto);

            List<ReporteMensajeDomain> lista = business.abrir(domainList);

            return ReporteMensajeAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ReporteMensajeFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.ReporteMensajeFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

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
            var userMessage = Messages.ReporteMensajeFacadeImplMessages.USER_MESSAGE_STATE;
            var technicalMessage = Messages.ReporteMensajeFacadeImplMessages.TECHNICAL_MESSAGE_STATE;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
