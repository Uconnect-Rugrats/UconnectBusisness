package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.RespuestaReportePublicacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.RespuestaReportePublicacionBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.RespuestaReportePublicacionBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReportePublicacionDomain;
import uco.doo.rugrats.uconnect.busisness.facade.RespuestaReportePublicacionFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.RespuestaReportePublicacionDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;
import java.util.UUID;

public final class RespuestaReportePublicacionFacadeImpl implements RespuestaReportePublicacionFacade {
	private final DAOFactory daoFactory;
	private final RespuestaReportePublicacionBusiness business;

	public RespuestaReportePublicacionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new RespuestaReportePublicacionBusinessImpl(daoFactory);
	}

	@Override
	public void revisar(RespuestaReportePublicacionDTO dto) {
		try {
			daoFactory.initTransaction();
			final RespuestaReportePublicacionDomain domain = RespuestaReportePublicacionAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.revisar(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.RespuestaReportePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.RespuestaReportePublicacionFacadeImplMessages.USER_MESSAGE_REGISTER,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void cerrarRespuesta(RespuestaReportePublicacionDTO dto) {
		try {
			daoFactory.initTransaction();
			final RespuestaReportePublicacionDomain domain = RespuestaReportePublicacionAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.cerrarRespuesta(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.RespuestaReportePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.RespuestaReportePublicacionFacadeImplMessages.USER_MESSAGE_MODIFY,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<RespuestaReportePublicacionDTO> abrir(RespuestaReportePublicacionDTO dto) {
		try {
			daoFactory.initTransaction();
			final RespuestaReportePublicacionDomain domainList = RespuestaReportePublicacionAssembler.getInstance()
					.toDomainFromDTO(dto);

			List<RespuestaReportePublicacionDomain> lista = business.abrir(domainList);

			return RespuestaReportePublicacionAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.RespuestaReportePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.RespuestaReportePublicacionFacadeImplMessages.USER_MESSAGE_LIST,
					exception);
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
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.RespuestaReportePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP,
					UconnectBusinessMessages.Facade.RespuestaReportePublicacionFacadeImplMessages.USER_MESSAGE_DROP,
					exception);
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
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.RespuestaReportePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_STATE,
					UconnectBusinessMessages.Facade.RespuestaReportePublicacionFacadeImplMessages.USER_MESSAGE_STATE,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
