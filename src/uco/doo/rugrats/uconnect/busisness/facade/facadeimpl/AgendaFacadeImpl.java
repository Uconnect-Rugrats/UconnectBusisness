package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.AgendaAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.AgendaBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.AgendaBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.AgendaDomain;
import uco.doo.rugrats.uconnect.busisness.facade.AgendaFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.AgendaDTO;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;
import java.util.UUID;

public final class AgendaFacadeImpl implements AgendaFacade {
	private final DAOFactory daoFactory;
	private final AgendaBusiness business;

	public AgendaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new AgendaBusinessImpl(daoFactory);
	}

	@Override
	public void crear(AgendaDTO dto) {
		try {
			daoFactory.initTransaction();
			final AgendaDomain domain = AgendaAssembler.getInstance().toDomainFromDTO(dto);

			business.crear(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.AgendaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.AgendaFacadeImplMessages.USER_MESSAGE_REGISTER, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void modificarFechaFinalizacion(AgendaDTO dto) {
		try {
			daoFactory.initTransaction();
			final AgendaDomain domain = AgendaAssembler.getInstance().toDomainFromDTO(dto);

			business.modificarFechaFinalizacion(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.AgendaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.AgendaFacadeImplMessages.USER_MESSAGE_MODIFY, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void cambiarEstado(AgendaDTO dto) {
		try {
			daoFactory.initTransaction();
			final AgendaDomain domain = AgendaAssembler.getInstance().toDomainFromDTO(dto);

			business.cambiarEstado(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.AgendaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.AgendaFacadeImplMessages.USER_MESSAGE_MODIFY, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<AgendaDTO> consultar(AgendaDTO dto) {
		try {
			daoFactory.initTransaction();
			final AgendaDomain domainList = AgendaAssembler.getInstance().toDomainFromDTO(dto);

			List<AgendaDomain> lista = business.consultar(domainList);

			return AgendaAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.AgendaFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.AgendaFacadeImplMessages.USER_MESSAGE_LIST, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public AgendaDomain abrir(AgendaDTO dto) {
		try {
			daoFactory.initTransaction();

			return AgendaAssembler.getInstance().toDomainFromDTO(dto);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.AdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.AdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_LIST,
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
					UconnectBusinessMessages.Facade.AgendaFacadeImplMessages.TECHNICAL_MESSAGE_DROP,
					UconnectBusinessMessages.Facade.AgendaFacadeImplMessages.USER_MESSAGE_DROP, exception);
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
					UconnectBusinessMessages.Facade.AgendaFacadeImplMessages.TECHNICAL_MESSAGE_STATE,
					UconnectBusinessMessages.Facade.AgendaFacadeImplMessages.USER_MESSAGE_STATE, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
