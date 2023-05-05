package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.CausaReporteDomain;

import java.util.List;

public interface CausaReporteBusiness {
    List<CausaReporteDomain> consultar(CausaReporteDomain domain);
}
