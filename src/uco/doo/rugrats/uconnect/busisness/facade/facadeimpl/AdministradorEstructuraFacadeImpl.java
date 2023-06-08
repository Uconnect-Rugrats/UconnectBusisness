package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.AdministradorEstructuraAssembler;
import uco.doo.rugrats.uconnect.busisness.business.AdministradorEstructuraBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.AdministradorEstructuraBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.AdministradorEstructuraDomain;
import uco.doo.rugrats.uconnect.busisness.facade.AdministradorEstructuraFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.AdministradorEstructuraDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;
import java.util.UUID;

public final class AdministradorEstructuraFacadeImpl implements AdministradorEstructuraFacade {
	private final DAOFactory daoFactory;
	private final AdministradorEstructuraBusiness business;

	public AdministradorEstructuraFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new AdministradorEstructuraBusinessImpl(daoFactory);
	}

	@Override
	public void concederPermisos(AdministradorEstructuraDTO dto) {
		try {
			daoFactory.initTransaction();
			final AdministradorEstructuraDomain domain = AdministradorEstructuraAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.concederPermisos(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.AdministradorEstructuraFacadeImplMessages.USER_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.AdministradorEstructuraFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void cambiarEstado(AdministradorEstructuraDTO dto) {
		try {
			daoFactory.initTransaction();
			final AdministradorEstructuraDomain domain = AdministradorEstructuraAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.cambiarEstado(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.AdministradorEstructuraFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.AdministradorEstructuraFacadeImplMessages.USER_MESSAGE_MODIFY,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<AdministradorEstructuraDTO> consultar(AdministradorEstructuraDTO dto) {
		try {
			daoFactory.initTransaction();
			final AdministradorEstructuraDomain domainList = AdministradorEstructuraAssembler.getInstance()
					.toDomainFromDTO(dto);

			List<AdministradorEstructuraDomain> lista = business.consultar(domainList);

			return AdministradorEstructuraAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.AdministradorEstructuraFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.AdministradorEstructuraFacadeImplMessages.USER_MESSAGE_LIST,
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
					UconnectBusinessMessages.Facade.AdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP,
					UconnectBusinessMessages.Facade.AdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_DROP,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	
}
