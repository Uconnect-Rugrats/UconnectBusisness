package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.TipoIdentificacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.TipoIdentificacionBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.TipoIdentificacionBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.TipoIdentificacionDomain;
import uco.doo.rugrats.uconnect.busisness.facade.TipoIdentificacionFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.TipoIdentificacionDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;

public final class TipoIdentificacionFacadeImpl implements TipoIdentificacionFacade {
	private final DAOFactory daoFactory;
	private final TipoIdentificacionBusiness business;

	public TipoIdentificacionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoIdentificacionBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoIdentificacionDTO> consultar(TipoIdentificacionDTO dto) {
		try {
			daoFactory.initTransaction();
			final TipoIdentificacionDomain domainList = TipoIdentificacionAssembler.getInstance().toDomainFromDTO(dto);

			final List<TipoIdentificacionDomain> lista = business.consultar(domainList);

			return TipoIdentificacionAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.TipoIdentificacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.TipoIdentificacionFacadeImplMessages.USER_MESSAGE_LIST, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
