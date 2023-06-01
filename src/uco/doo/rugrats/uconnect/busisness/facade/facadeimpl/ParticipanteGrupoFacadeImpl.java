package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ParticipanteGrupoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ParticipanteGrupoBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.ParticipanteGrupoBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.ParticipanteGrupoDomain;
import uco.doo.rugrats.uconnect.busisness.facade.ParticipanteGrupoFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.ParticipanteGrupoDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;
import java.util.UUID;

public final class ParticipanteGrupoFacadeImpl implements ParticipanteGrupoFacade {
	private final DAOFactory daoFactory;
	private final ParticipanteGrupoBusiness business;

	public ParticipanteGrupoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new ParticipanteGrupoBusinessImpl(daoFactory);
	}

	@Override
	public void asignarGrupo(ParticipanteGrupoDTO dto) {
		try {
			daoFactory.initTransaction();
			final ParticipanteGrupoDomain domain = ParticipanteGrupoAssembler.getInstance().toDomainFromDTO(dto);

			business.asignarGrupo(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.ParticipanteGrupoFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.ParticipanteGrupoFacadeImplMessages.USER_MESSAGE_REGISTER,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<ParticipanteGrupoDTO> consultar(ParticipanteGrupoDTO dto) {
		try {
			daoFactory.initTransaction();
			final ParticipanteGrupoDomain domainList = ParticipanteGrupoAssembler.getInstance().toDomainFromDTO(dto);

			List<ParticipanteGrupoDomain> lista = business.consultar(domainList);

			return ParticipanteGrupoAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.ParticipanteGrupoFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.ParticipanteGrupoFacadeImplMessages.USER_MESSAGE_LIST, exception);
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
					UconnectBusinessMessages.Facade.ParticipanteGrupoFacadeImplMessages.TECHNICAL_MESSAGE_DROP,
					UconnectBusinessMessages.Facade.ParticipanteGrupoFacadeImplMessages.USER_MESSAGE_DROP, exception);
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
					UconnectBusinessMessages.Facade.ParticipanteGrupoFacadeImplMessages.TECHNICAL_MESSAGE_STATE,
					UconnectBusinessMessages.Facade.ParticipanteGrupoFacadeImplMessages.USER_MESSAGE_STATE, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
