package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.OrganizacionDomain;

import java.util.List;
import java.util.UUID;

public interface OrganizacionBusiness {
	void crearNueva(OrganizacionDomain domain);

	void cambiarNombre(OrganizacionDomain domain);

	void cambiarEstado(OrganizacionDomain domain);

	List<OrganizacionDomain> consultar(OrganizacionDomain domain);

	void eliminar(UUID domain);
}
