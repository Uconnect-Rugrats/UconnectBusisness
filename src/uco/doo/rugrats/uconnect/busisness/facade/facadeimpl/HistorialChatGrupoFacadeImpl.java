package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.HistorialChatGrupoAssembler;
import uco.doo.rugrats.uconnect.busisness.business.HistorialChatGrupoBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.HistorialChatGrupoBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.HistorialChatGrupoDomain;
import uco.doo.rugrats.uconnect.busisness.facade.HistorialChatGrupoFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.HistorialChatGrupoDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;
import java.util.UUID;

public final class HistorialChatGrupoFacadeImpl implements HistorialChatGrupoFacade {
	private final DAOFactory daoFactory;
	private final HistorialChatGrupoBusiness business;

	public HistorialChatGrupoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new HistorialChatGrupoBusinessImpl(daoFactory);
	}

	@Override
	public void generar(HistorialChatGrupoDTO dto) {
		try {
			daoFactory.initTransaction();
			final HistorialChatGrupoDomain domain = HistorialChatGrupoAssembler.getInstance().toDomainFromDTO(dto);

			business.generar(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.HistorialChatGrupoFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.HistorialChatGrupoFacadeImplMessages.USER_MESSAGE_REGISTER,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<HistorialChatGrupoDTO> listar(HistorialChatGrupoDTO dto) {
		try {
			daoFactory.initTransaction();
			final HistorialChatGrupoDomain domainList = HistorialChatGrupoAssembler.getInstance().toDomainFromDTO(dto);

			final List<HistorialChatGrupoDomain> lista = business.listar(domainList);

			return HistorialChatGrupoAssembler.getInstance().toDTOFromDomainList(lista);

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.HistorialLecturaFacadeImplMessages.TECHNICAL_MESSAGE_LIST,
					UconnectBusinessMessages.Facade.HistorialLecturaFacadeImplMessages.USER_MESSAGE_LIST, exception);
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
					UconnectBusinessMessages.Facade.HistorialChatGrupoFacadeImplMessages.TECHNICAL_MESSAGE_DROP,
					UconnectBusinessMessages.Facade.HistorialChatGrupoFacadeImplMessages.USER_MESSAGE_DROP, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

}
