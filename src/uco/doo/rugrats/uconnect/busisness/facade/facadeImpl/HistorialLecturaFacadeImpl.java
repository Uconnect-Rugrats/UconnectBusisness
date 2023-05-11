package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.HistorialLecturaAssembler;
import uco.doo.rugrats.uconnect.busisness.business.HistorialLecturaBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.HistorialLecturaBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.HistorialLecturaDomain;
import uco.doo.rugrats.uconnect.busisness.facade.HistorialLecturaFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.HistorialLecturaDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;

public final class HistorialLecturaFacadeImpl implements HistorialLecturaFacade {
    private final DAOFactory daoFactory;
    private final HistorialLecturaBusiness business;

    public HistorialLecturaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new HistorialLecturaBusinessImpl(daoFactory);
    }

    @Override
    public void generar(HistorialLecturaDTO dto) {
        try {
            daoFactory.initTransaction();
            final HistorialLecturaDomain domain = HistorialLecturaAssembler.getInstance().toDomainFromDTO(dto);

            business.generar(domain);
            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.HistorialLecturaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.HistorialLecturaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void leerMensaje(HistorialLecturaDTO dto) {
        try {
            daoFactory.initTransaction();
            final HistorialLecturaDomain domain = HistorialLecturaAssembler.getInstance().toDomainFromDTO(dto);

            business.leerMensaje(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.HistorialLecturaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.HistorialLecturaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<HistorialLecturaDTO> mostrarInformacionMensaje(HistorialLecturaDTO dto) {
        try {
            daoFactory.initTransaction();
            final HistorialLecturaDomain domainList = HistorialLecturaAssembler.getInstance().toDomainFromDTO(dto);

            List<HistorialLecturaDomain> lista = business.mostrarInformacionMensaje(domainList);

            return HistorialLecturaAssembler.getInstance().toDTOFromDomainList(lista);


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
            var userMessage = Messages.HistorialLecturaFacadeImplMessages.USER_MESSAGE_STATE;
            var technicalMessage = Messages.HistorialLecturaFacadeImplMessages.TECHNICAL_MESSAGE_STATE;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
