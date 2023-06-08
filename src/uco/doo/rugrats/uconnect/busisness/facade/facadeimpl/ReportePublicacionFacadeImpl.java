package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ReportePublicacionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ReportePublicacionBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.ReportePublicacionBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.ReportePublicacionDomain;
import uco.doo.rugrats.uconnect.busisness.facade.ReportePublicacionFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.ReportePublicacionDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;

public final class ReportePublicacionFacadeImpl implements ReportePublicacionFacade {
	private final DAOFactory daoFactory;
	private final ReportePublicacionBusiness business;

	public ReportePublicacionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new ReportePublicacionBusinessImpl(daoFactory);
	}

	@Override
	public void reportar(ReportePublicacionDTO dto) {
		try {
			daoFactory.initTransaction();
			final ReportePublicacionDomain domain = ReportePublicacionAssembler.getInstance().toDomainFromDTO(dto);

			business.reportar(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.ReportePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.ReportePublicacionFacadeImplMessages.USER_MESSAGE_REGISTER,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void cambiarEstado(ReportePublicacionDTO dto) {
		try {
			daoFactory.initTransaction();
			final ReportePublicacionDomain domain = ReportePublicacionAssembler.getInstance().toDomainFromDTO(dto);

			business.cambiarEstado(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.ReportePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.ReportePublicacionFacadeImplMessages.USER_MESSAGE_MODIFY,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<ReportePublicacionDTO> abrir(ReportePublicacionDTO dto) {
		try {
			daoFactory.initTransaction();
			final ReportePublicacionDomain domainList = ReportePublicacionAssembler.getInstance().toDomainFromDTO(dto);

			final List<ReportePublicacionDomain> lista = business.abrir(domainList);

			return ReportePublicacionAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.ReportePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.ReportePublicacionFacadeImplMessages.USER_MESSAGE_LIST, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}
}
