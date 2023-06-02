package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.RespuestaReporteComentarioAssembler;
import uco.doo.rugrats.uconnect.busisness.business.RespuestaReporteComentarioBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.RespuestaReporteComentarioBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReporteComentarioDomain;
import uco.doo.rugrats.uconnect.busisness.facade.RespuestaReporteComentarioFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.RespuestaReporteComentarioDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;
import java.util.UUID;

public final class RespuestaReporteComentarioFacadeImpl implements RespuestaReporteComentarioFacade {
	private final DAOFactory daoFactory;
	private final RespuestaReporteComentarioBusiness business;

	public RespuestaReporteComentarioFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new RespuestaReporteComentarioBusinessImpl(daoFactory);
	}

	@Override
	public void revisar(RespuestaReporteComentarioDTO dto) {
		try {
			daoFactory.initTransaction();
			final RespuestaReporteComentarioDomain domain = RespuestaReporteComentarioAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.revisar(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.RespuestaReporteComentarioFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.RespuestaReporteComentarioFacadeImplMessages.USER_MESSAGE_REGISTER,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void cerrarRespuesta(RespuestaReporteComentarioDTO dto) {
		try {
			daoFactory.initTransaction();
			final RespuestaReporteComentarioDomain domain = RespuestaReporteComentarioAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.cerrarRespuesta(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.RespuestaReporteComentarioFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.RespuestaReporteComentarioFacadeImplMessages.USER_MESSAGE_MODIFY,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<RespuestaReporteComentarioDTO> abrir(RespuestaReporteComentarioDTO dto) {
		try {
			daoFactory.initTransaction();
			final RespuestaReporteComentarioDomain domainList = RespuestaReporteComentarioAssembler.getInstance()
					.toDomainFromDTO(dto);

			final List<RespuestaReporteComentarioDomain> lista = extracted(domainList);

			return RespuestaReporteComentarioAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.RespuestaReporteComentarioFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.RespuestaReporteComentarioFacadeImplMessages.USER_MESSAGE_LIST,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	private List<RespuestaReporteComentarioDomain> extracted(final RespuestaReporteComentarioDomain domainList) {
		return business.abrir(domainList);
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
					UconnectBusinessMessages.Facade.RespuestaReporteComentarioFacadeImplMessages.TECHNICAL_MESSAGE_DROP,
					UconnectBusinessMessages.Facade.RespuestaReporteComentarioFacadeImplMessages.USER_MESSAGE_DROP,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public EstadoDTO obtenerEstadoReal() {
		try {
			daoFactory.initTransaction();
			final EstadoDTO dto = EstadoAssembler.getInstance().toDTOFromDomain(business.obtenerEstadoReal());
			daoFactory.commitTransaction();
			return dto;

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.RespuestaReporteComentarioFacadeImplMessages.TECHNICAL_MESSAGE_STATE,
					UconnectBusinessMessages.Facade.RespuestaReporteComentarioFacadeImplMessages.USER_MESSAGE_STATE,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
