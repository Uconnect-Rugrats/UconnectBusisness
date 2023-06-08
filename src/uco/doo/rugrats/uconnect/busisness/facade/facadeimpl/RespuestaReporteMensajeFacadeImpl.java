package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.RespuestaReporteMensajeAssembler;
import uco.doo.rugrats.uconnect.busisness.business.RespuestaReporteMensajeBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.RespuestaReporteMensajeBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReporteMensajeDomain;
import uco.doo.rugrats.uconnect.busisness.facade.RespuestaReporteMensajeFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.RespuestaReporteMensajeDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;
import java.util.UUID;

public final class RespuestaReporteMensajeFacadeImpl implements RespuestaReporteMensajeFacade {
	private final DAOFactory daoFactory;
	private final RespuestaReporteMensajeBusiness business;

	public RespuestaReporteMensajeFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new RespuestaReporteMensajeBusinessImpl(daoFactory);
	}

	@Override
	public void revisar(RespuestaReporteMensajeDTO dto) {
		try {
			daoFactory.initTransaction();
			final RespuestaReporteMensajeDomain domain = RespuestaReporteMensajeAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.revisar(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.RespuestaReporteMensajeFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.RespuestaReporteMensajeFacadeImplMessages.USER_MESSAGE_REGISTER,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void cerrarRespuesta(RespuestaReporteMensajeDTO dto) {
		try {
			daoFactory.initTransaction();
			final RespuestaReporteMensajeDomain domain = RespuestaReporteMensajeAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.cerrarRespuesta(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.RespuestaReporteMensajeFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.RespuestaReporteMensajeFacadeImplMessages.USER_MESSAGE_MODIFY,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<RespuestaReporteMensajeDTO> abrir(RespuestaReporteMensajeDTO dto) {
		try {
			daoFactory.initTransaction();
			final RespuestaReporteMensajeDomain domainList = RespuestaReporteMensajeAssembler.getInstance()
					.toDomainFromDTO(dto);

			final List<RespuestaReporteMensajeDomain> lista = business.abrir(domainList);

			return RespuestaReporteMensajeAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.RespuestaReporteMensajeFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.RespuestaReporteMensajeFacadeImplMessages.USER_MESSAGE_LIST,
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
					UconnectBusinessMessages.Facade.RespuestaReporteMensajeFacadeImplMessages.TECHNICAL_MESSAGE_DROP,
					UconnectBusinessMessages.Facade.RespuestaReporteMensajeFacadeImplMessages.USER_MESSAGE_DROP,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

}
