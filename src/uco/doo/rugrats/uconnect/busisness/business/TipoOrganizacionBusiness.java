package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.TipoOrganizacionDomain;

import java.util.List;

public interface TipoOrganizacionBusiness {
	List<TipoOrganizacionDomain> consultar(TipoOrganizacionDomain domain);
}
