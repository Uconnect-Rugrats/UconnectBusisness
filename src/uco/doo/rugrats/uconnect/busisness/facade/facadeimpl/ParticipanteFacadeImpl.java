package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ParticipanteAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ParticipanteBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.ParticipanteBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.ParticipanteDomain;
import uco.doo.rugrats.uconnect.busisness.facade.ParticipanteFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.ParticipanteDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;
import java.util.UUID;

public final class ParticipanteFacadeImpl implements ParticipanteFacade {
	private final DAOFactory daoFactory;
	private final ParticipanteBusiness business;

	public ParticipanteFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new ParticipanteBusinessImpl(daoFactory);
	}

	@Override
	public void registrar(ParticipanteDTO dto) {
		try {
			daoFactory.initTransaction();
			final ParticipanteDomain domain = ParticipanteAssembler.getInstance().toDomainFromDTO(dto);

			business.registrar(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.ParticipanteFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.ParticipanteFacadeImplMessages.USER_MESSAGE_REGISTER, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void cambiarEstado(ParticipanteDTO dto) {
		try {
			daoFactory.initTransaction();
			final ParticipanteDomain domain = ParticipanteAssembler.getInstance().toDomainFromDTO(dto);

			business.cambiarEstado(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.ParticipanteFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.ParticipanteFacadeImplMessages.USER_MESSAGE_MODIFY, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<ParticipanteDTO> consultar(ParticipanteDTO dto) {
		try {
			daoFactory.initTransaction();
			final ParticipanteDomain domainList = ParticipanteAssembler.getInstance().toDomainFromDTO(dto);

			List<ParticipanteDomain> lista = business.consultar(domainList);

			return ParticipanteAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.ParticipanteFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.ParticipanteFacadeImplMessages.USER_MESSAGE_LIST, exception);
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
					UconnectBusinessMessages.Facade.ParticipanteFacadeImplMessages.TECHNICAL_MESSAGE_DROP,
					UconnectBusinessMessages.Facade.ParticipanteFacadeImplMessages.USER_MESSAGE_DROP, exception);
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
					UconnectBusinessMessages.Facade.ParticipanteFacadeImplMessages.TECHNICAL_MESSAGE_STATE,
					UconnectBusinessMessages.Facade.ParticipanteFacadeImplMessages.USER_MESSAGE_STATE, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
