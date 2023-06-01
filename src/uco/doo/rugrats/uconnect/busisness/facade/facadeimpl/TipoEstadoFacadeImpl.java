package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.TipoEstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.TipoEstadoBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.TipoEstadoBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.TipoEstadoDomain;
import uco.doo.rugrats.uconnect.busisness.facade.TipoEstadoFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.TipoEstadoDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;

public final class TipoEstadoFacadeImpl implements TipoEstadoFacade {
	private final DAOFactory daoFactory;
	private final TipoEstadoBusiness business;

	public TipoEstadoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoEstadoBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoEstadoDTO> consultar(TipoEstadoDTO dto) {
		try {
			daoFactory.initTransaction();
			final TipoEstadoDomain domainList = TipoEstadoAssembler.getInstance().toDomainFromDTO(dto);

			List<TipoEstadoDomain> lista = business.consultar(domainList);

			return TipoEstadoAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.TipoEstadoFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.TipoEstadoFacadeImplMessages.USER_MESSAGE_LIST, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
