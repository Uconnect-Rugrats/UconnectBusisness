package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.TipoOrganizacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.TipoOrganizacionBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.TipoOrganizacionBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.TipoOrganizacionDomain;
import uco.doo.rugrats.uconnect.busisness.facade.TipoOrganizacionFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.TipoOrganizacionDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;

public final class TipoOrganizacionFacadeImpl implements TipoOrganizacionFacade {
	private final DAOFactory daoFactory;
	private final TipoOrganizacionBusiness business;

	public TipoOrganizacionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoOrganizacionBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoOrganizacionDTO> consultar(TipoOrganizacionDTO dto) {
		try {
			daoFactory.initTransaction();
			final TipoOrganizacionDomain domainList = TipoOrganizacionAssembler.getInstance().toDomainFromDTO(dto);

			final List<TipoOrganizacionDomain> lista = business.consultar(domainList);

			return TipoOrganizacionAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.TipoOrganizacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.TipoOrganizacionFacadeImplMessages.USER_MESSAGE_LIST, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
