package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ReportePublicacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ReportePublicacionBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.ReportePublicacionBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.ReportePublicacionDomain;
import uco.doo.rugrats.uconnect.busisness.facade.ReportePublicacionFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.ReportePublicacionDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;

public final class ReportePublicacionFacadeImpl implements ReportePublicacionFacade {
    private final DAOFactory daoFactory;
    private final ReportePublicacionBusiness business;

    public ReportePublicacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new ReportePublicacionBusinessImpl(daoFactory);
    }


    @Override
    public void reportar(ReportePublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final ReportePublicacionDomain domain = ReportePublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.reportar(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ReportePublicacionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.ReportePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void cambiarEstado(ReportePublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final ReportePublicacionDomain domain = ReportePublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.cambiarEstado(domain);

            daoFactory.commitTransaction();


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ReportePublicacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.ReportePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<ReportePublicacionDTO> abrir(ReportePublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final ReportePublicacionDomain domainList = ReportePublicacionAssembler.getInstance().toDomainFromDTO(dto);

            List<ReportePublicacionDomain> lista = business.abrir(domainList);

            return ReportePublicacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ReportePublicacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.ReportePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

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
            var userMessage = Messages.ReportePublicacionFacadeImplMessages.USER_MESSAGE_STATE;
            var technicalMessage = Messages.ReportePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_STATE;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
