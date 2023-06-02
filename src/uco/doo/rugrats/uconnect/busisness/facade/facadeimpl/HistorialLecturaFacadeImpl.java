package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.EstadoAssembler;
import uco.doo.rugrats.uconnect.busisness.assembler.concrete.HistorialLecturaAssembler;
import uco.doo.rugrats.uconnect.busisness.business.HistorialLecturaBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.HistorialLecturaBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.HistorialLecturaDomain;
import uco.doo.rugrats.uconnect.busisness.facade.HistorialLecturaFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.HistorialLecturaDTO;
import uco.doo.rugrats.uconnect.utils.messages.UconnectBusinessMessages;

import java.util.List;

public final class HistorialLecturaFacadeImpl implements HistorialLecturaFacade {
	private final DAOFactory daoFactory;
	private final HistorialLecturaBusiness business;

	public HistorialLecturaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new HistorialLecturaBusinessImpl(daoFactory);
	}

	@Override
	public void generar(HistorialLecturaDTO dto) {
		try {
			daoFactory.initTransaction();
			final HistorialLecturaDomain domain = HistorialLecturaAssembler.getInstance().toDomainFromDTO(dto);

			business.generar(domain);
			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.HistorialLecturaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER,
					UconnectBusinessMessages.Facade.HistorialLecturaFacadeImplMessages.USER_MESSAGE_REGISTER,
					exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void leerMensaje(HistorialLecturaDTO dto) {
		try {
			daoFactory.initTransaction();
			final HistorialLecturaDomain domain = HistorialLecturaAssembler.getInstance().toDomainFromDTO(dto);

			business.leerMensaje(domain);

			daoFactory.commitTransaction();

		} catch (final UconnectException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			throw UconnectBusisnessException.create(
					UconnectBusinessMessages.Facade.HistorialLecturaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY,
					UconnectBusinessMessages.Facade.HistorialLecturaFacadeImplMessages.USER_MESSAGE_MODIFY, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<HistorialLecturaDTO> mostrarInformacionMensaje(HistorialLecturaDTO dto) {
		try {
			daoFactory.initTransaction();
			final HistorialLecturaDomain domainList = HistorialLecturaAssembler.getInstance().toDomainFromDTO(dto);

			final List<HistorialLecturaDomain> lista = business.mostrarInformacionMensaje(domainList);

			return HistorialLecturaAssembler.getInstance().toDTOFromDomainList(lista);

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
    public EstadoDTO obtenerEstadoReal() {
        try {
            daoFactory.initTransaction();
            final EstadoDTO dto = EstadoAssembler.getInstance().toDTOFromDomain(business.obtenerEstadoReal());
            daoFactory.commitTransaction();
            return dto;


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
           throw UconnectBusisnessException.create(UconnectBusinessMessages.Facade.HistorialLecturaFacadeImplMessages.TECHNICAL_MESSAGE_STATE, UconnectBusinessMessages.Facade.HistorialLecturaFacadeImplMessages.USER_MESSAGE_STATE, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
