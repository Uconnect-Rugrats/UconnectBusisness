package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ComentarioAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ComentarioBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.ComentarioBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.ComentarioDomain;
import uco.doo.rugrats.uconnect.busisness.facade.ComentarioFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.ComentarioDTO;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;
import java.util.UUID;

public final class ComentarioFacadeImpl implements ComentarioFacade {
	private final DAOFactory daoFactory;
	private final ComentarioBusiness business;

	public ComentarioFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new ComentarioBusinessImpl(daoFactory);
	}

	@Override
	public void comentar(ComentarioDTO dto) {
		try {
			daoFactory.initTransaction();
			final ComentarioDomain domain = ComentarioAssembler.getInstance().toDomainFromDTO(dto);

			business.comentar(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = UconnectBusinessMessages.Facade.ComentarioFacadeImplMessages.USER_MESSAGE_REGISTER;
			var technicalMessage = UconnectBusinessMessages.Facade.ComentarioFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

			throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void cambiarEstado(ComentarioDTO dto) {
		try {
			daoFactory.initTransaction();
			final ComentarioDomain domain = ComentarioAssembler.getInstance().toDomainFromDTO(dto);

			business.cambiarEstado(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = UconnectBusinessMessages.Facade.ComentarioFacadeImplMessages.USER_MESSAGE_MODIFY;
			var technicalMessage = UconnectBusinessMessages.Facade.ComentarioFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

			throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<ComentarioDTO> consultar(ComentarioDTO dto) {
		try {
			daoFactory.initTransaction();
			final ComentarioDomain domainList = ComentarioAssembler.getInstance().toDomainFromDTO(dto);

			List<ComentarioDomain> lista = business.consultar(domainList);

			return ComentarioAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.ComentarioFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.ComentarioFacadeImplMessages.USER_MESSAGE_LIST, exception);
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
					UconnectBusinessMessages.Facade.ComentarioFacadeImplMessages.TECHNICAL_MESSAGE_DROP,
					UconnectBusinessMessages.Facade.ComentarioFacadeImplMessages.USER_MESSAGE_DROP, exception);
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
					UconnectBusinessMessages.Facade.ComentarioFacadeImplMessages.TECHNICAL_MESSAGE_STATE,
					UconnectBusinessMessages.Facade.ComentarioFacadeImplMessages.USER_MESSAGE_STATE, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
	public static void main(String[] args) {
		var daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);

		ComentarioBusiness business = new ComentarioBusinessImpl(daoFactory);

		ComentarioDomain dto = ComentarioDomain.getDefaultObject();
		var result = business.consultar(dto);
	}
}
