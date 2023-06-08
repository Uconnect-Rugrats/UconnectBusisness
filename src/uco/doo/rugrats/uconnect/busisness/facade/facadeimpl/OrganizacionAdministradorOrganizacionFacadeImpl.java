package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.OrganizacionAdministradorOrganizacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.OrganizacionAdministradorOrganizacionBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.OrganizacionAdministradorOrganizacionBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.OrganizacionAdministradorOrganizacionDomain;
import uco.doo.rugrats.uconnect.busisness.facade.OrganizacionAdministradorOrganizacionFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.OrganizacionAdministradorOrganizacionDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;
import java.util.UUID;

public final class OrganizacionAdministradorOrganizacionFacadeImpl
		implements OrganizacionAdministradorOrganizacionFacade {
	private final DAOFactory daoFactory;
	private final OrganizacionAdministradorOrganizacionBusiness business;

	public OrganizacionAdministradorOrganizacionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new OrganizacionAdministradorOrganizacionBusinessImpl(daoFactory);
	}

	@Override
	public void asignarOrganizacion(OrganizacionAdministradorOrganizacionDTO dto) {
		try {
			daoFactory.initTransaction();
			final OrganizacionAdministradorOrganizacionDomain domain = OrganizacionAdministradorOrganizacionAssembler
					.getInstance().toDomainFromDTO(dto);

			business.asignarOrganizacion(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.OrganizacionAdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.OrganizacionAdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_REGISTER,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<OrganizacionAdministradorOrganizacionDTO> consultar(OrganizacionAdministradorOrganizacionDTO dto) {
		try {
			daoFactory.initTransaction();
			final OrganizacionAdministradorOrganizacionDomain domainList = OrganizacionAdministradorOrganizacionAssembler
					.getInstance().toDomainFromDTO(dto);

			final List<OrganizacionAdministradorOrganizacionDomain> lista = business.consultar(domainList);

			return OrganizacionAdministradorOrganizacionAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.OrganizacionAdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.OrganizacionAdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_LIST,
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
					UconnectBusinessMessages.Facade.OrganizacionAdministradorOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP,
					UconnectBusinessMessages.Facade.OrganizacionAdministradorOrganizacionFacadeImplMessages.USER_MESSAGE_DROP,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

}
