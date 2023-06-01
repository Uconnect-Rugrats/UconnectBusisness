package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.GrupoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.GrupoBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.GrupoBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.GrupoDomain;
import uco.doo.rugrats.uconnect.busisness.facade.GrupoFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.GrupoDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;
import java.util.UUID;

public final class GrupoFacadeImpl implements GrupoFacade {
	private final DAOFactory daoFactory;
	private final GrupoBusiness business;

	public GrupoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new GrupoBusinessImpl(daoFactory);
	}

	@Override
	public void crear(GrupoDTO dto) {
		try {
			daoFactory.initTransaction();
			final GrupoDomain domain = GrupoAssembler.getInstance().toDomainFromDTO(dto);

			business.crear(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.GrupoFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.GrupoFacadeImplMessages.USER_MESSAGE_REGISTER, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void editar(GrupoDTO dto) {
		try {
			daoFactory.initTransaction();
			final GrupoDomain domain = GrupoAssembler.getInstance().toDomainFromDTO(dto);

			business.editar(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.GrupoFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.GrupoFacadeImplMessages.USER_MESSAGE_MODIFY, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void cambiarEstado(GrupoDTO dto) {
		try {
			daoFactory.initTransaction();
			final GrupoDomain domain = GrupoAssembler.getInstance().toDomainFromDTO(dto);

			business.cambiarEstado(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.GrupoFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.GrupoFacadeImplMessages.USER_MESSAGE_MODIFY, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<GrupoDTO> buscar(GrupoDTO dto) {
		try {
			daoFactory.initTransaction();
			final GrupoDomain domainList = GrupoAssembler.getInstance().toDomainFromDTO(dto);

			List<GrupoDomain> lista = business.buscar(domainList);

			return GrupoAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.GrupoFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.GrupoFacadeImplMessages.USER_MESSAGE_LIST, exception);
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
					UconnectBusinessMessages.Facade.GrupoFacadeImplMessages.TECHNICAL_MESSAGE_DROP,
					UconnectBusinessMessages.Facade.GrupoFacadeImplMessages.USER_MESSAGE_DROP, exception);
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
					UconnectBusinessMessages.Facade.GrupoFacadeImplMessages.TECHNICAL_MESSAGE_STATE,
					UconnectBusinessMessages.Facade.GrupoFacadeImplMessages.USER_MESSAGE_STATE, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
