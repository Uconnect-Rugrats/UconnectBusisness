package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.AdministradorEstructuraDomain;
import java.util.List;
import java.util.UUID;

public interface AdministradorEstructuraBusiness {
	void concederPermisos(AdministradorEstructuraDomain domain);

	void cambiarEstado(AdministradorEstructuraDomain domain);

	List<AdministradorEstructuraDomain> consultar(AdministradorEstructuraDomain domain);

	void eliminar(UUID domain);

}
