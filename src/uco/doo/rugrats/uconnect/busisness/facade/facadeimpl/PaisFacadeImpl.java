package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.PaisAssembler;
import uco.doo.rugrats.uconnect.busisness.business.PaisBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.PaisBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.PaisDomain;
import uco.doo.rugrats.uconnect.busisness.facade.PaisFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.PaisDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;

public final class PaisFacadeImpl implements PaisFacade {
	private final DAOFactory daoFactory;
	private final PaisBusiness business;

	public PaisFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new PaisBusinessImpl(daoFactory);
	}

	@Override
	public List<PaisDTO> consultar(PaisDTO dto) {
		try {
			daoFactory.initTransaction();
			final PaisDomain domainList = PaisAssembler.getInstance().toDomainFromDTO(dto);

			List<PaisDomain> lista = business.consultar(domainList);

			return PaisAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.PaisFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.PaisFacadeImplMessages.USER_MESSAGE_LIST, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
