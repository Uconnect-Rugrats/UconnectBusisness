package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.CausaReporteDTO;

import java.util.List;

public interface CausaReporteFacade {
    List<CausaReporteDTO> consultar(CausaReporteDTO dto);
}
