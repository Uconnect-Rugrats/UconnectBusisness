package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.AdministradorOrganizacionDomain;
import java.util.List;
import java.util.UUID;

public interface AdministradorOrganizacionBusiness {
	void concederPermisos(AdministradorOrganizacionDomain domain);

	void cambiarEstado(AdministradorOrganizacionDomain domain);

	List<AdministradorOrganizacionDomain> consultar(AdministradorOrganizacionDomain domain);

	void eliminar(UUID domain);

}
