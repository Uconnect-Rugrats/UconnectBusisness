package uco.doo.rugrats.uconnect.busisness.facade.facadeImpl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.CausaReporteAssembler;
import uco.doo.rugrats.uconnect.busisness.business.CausaReporteBusiness;
import uco.doo.rugrats.uconnect.busisness.business.impl.CausaReporteBusinessImpl;
import uco.doo.rugrats.uconnect.busisness.domain.CausaReporteDomain;
import uco.doo.rugrats.uconnect.busisness.facade.CausaReporteFacade;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectBusisnessException;
import uco.doo.rugrats.uconnect.crosscutting.exception.UconnectException;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.data.dao.factory.Factory;
import uco.doo.rugrats.uconnect.dto.CausaReporteDTO;
import uco.doo.rugrats.uconnect.utils.Messages;

import java.util.List;

public final class CausaReporteFacadeImpl implements CausaReporteFacade {
    private final DAOFactory daoFactory;
    private final CausaReporteBusiness business;

    public CausaReporteFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new CausaReporteBusinessImpl(daoFactory);
    }

    @Override
    public List<CausaReporteDTO> consultar(CausaReporteDTO dto) {
        try {
            daoFactory.initTransaction();
            final CausaReporteDomain domainList = CausaReporteAssembler.getInstance().toDomainFromDTO(dto);

            List<CausaReporteDomain> lista = business.consultar(domainList);

            return CausaReporteAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final UconnectException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.CausaReporteFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.CausaReporteFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw UconnectBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
