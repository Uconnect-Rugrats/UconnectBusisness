package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ReporteComentarioAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ReporteComentarioBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.ReporteComentarioBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.ReporteComentarioDomain;
import uco.doo.rugrats.uconnect.busisness.facade.ReporteComentarioFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.ReporteComentarioDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;

public final class ReporteComentarioFacadeImpl implements ReporteComentarioFacade {
	private final DAOFactory daoFactory;
	private final ReporteComentarioBusiness business;

	public ReporteComentarioFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new ReporteComentarioBusinessImpl(daoFactory);
	}

	@Override
	public void reportar(ReporteComentarioDTO dto) {
		try {
			daoFactory.initTransaction();
			final ReporteComentarioDomain domain = ReporteComentarioAssembler.getInstance().toDomainFromDTO(dto);

			business.reportar(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.ReporteComentarioFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.ReporteComentarioFacadeImplMessages.USER_MESSAGE_REGISTER,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void cambiarEstado(ReporteComentarioDTO dto) {
		try {
			daoFactory.initTransaction();
			final ReporteComentarioDomain domain = ReporteComentarioAssembler.getInstance().toDomainFromDTO(dto);

			business.cambiarEstado(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.ReporteComentarioFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.ReporteComentarioFacadeImplMessages.USER_MESSAGE_MODIFY, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<ReporteComentarioDTO> abrir(ReporteComentarioDTO dto) {
		try {
			daoFactory.initTransaction();
			final ReporteComentarioDomain domainList = ReporteComentarioAssembler.getInstance().toDomainFromDTO(dto);

			final List<ReporteComentarioDomain> lista = business.abrir(domainList);

			return ReporteComentarioAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.ReporteComentarioFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.ReporteComentarioFacadeImplMessages.USER_MESSAGE_LIST, exception);
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
					UconnectBusinessMessages.Facade.ReporteComentarioFacadeImplMessages.TECHNICAL_MESSAGE_STATE,
					UconnectBusinessMessages.Facade.ReporteComentarioFacadeImplMessages.USER_MESSAGE_STATE, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
