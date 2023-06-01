package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.PersonaAssembler;
import uco.doo.rugrats.uconnect.busisness.business.PersonaBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.PersonaBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.PersonaDomain;
import uco.doo.rugrats.uconnect.busisness.facade.PersonaFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.PersonaDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;
import java.util.UUID;

public final class PersonaFacadeImpl implements PersonaFacade {
	private final DAOFactory daoFactory;
	private final PersonaBusiness business;

	public PersonaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new PersonaBusinessImpl(daoFactory);
	}

	@Override
	public void registrar(PersonaDTO dto) {
		try {
			daoFactory.initTransaction();
			final PersonaDomain domain = PersonaAssembler.getInstance().toDomainFromDTO(dto);

			business.registrar(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.PersonaFacadeImplMessages.USER_MESSAGE_REGISTER, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void editar(PersonaDTO dto) {
		try {
			daoFactory.initTransaction();
			final PersonaDomain domain = PersonaAssembler.getInstance().toDomainFromDTO(dto);

			business.editar(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.PersonaFacadeImplMessages.USER_MESSAGE_MODIFY, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void cambiarEstado(PersonaDTO dto) {
		try {
			daoFactory.initTransaction();
			final PersonaDomain domain = PersonaAssembler.getInstance().toDomainFromDTO(dto);

			business.cambiarEstado(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.PersonaFacadeImplMessages.USER_MESSAGE_MODIFY, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<PersonaDTO> consultar(PersonaDTO dto) {
		try {
			daoFactory.initTransaction();
			final PersonaDomain domainList = PersonaAssembler.getInstance().toDomainFromDTO(dto);

			List<PersonaDomain> lista = business.consultar(domainList);

			return PersonaAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.PersonaFacadeImplMessages.USER_MESSAGE_LIST, exception);
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
					UconnectBusinessMessages.Facade.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_DROP,
					UconnectBusinessMessages.Facade.PersonaFacadeImplMessages.USER_MESSAGE_DROP, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
