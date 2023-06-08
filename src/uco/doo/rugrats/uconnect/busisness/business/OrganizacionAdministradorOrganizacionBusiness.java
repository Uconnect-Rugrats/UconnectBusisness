package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.OrganizacionAdministradorOrganizacionDomain;

import java.util.List;
import java.util.UUID;

public interface OrganizacionAdministradorOrganizacionBusiness {
	void asignarOrganizacion(OrganizacionAdministradorOrganizacionDomain domain);

	List<OrganizacionAdministradorOrganizacionDomain> consultar(OrganizacionAdministradorOrganizacionDomain domain);

	void eliminar(UUID domain);

}
