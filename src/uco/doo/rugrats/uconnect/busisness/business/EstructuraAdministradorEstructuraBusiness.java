package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstructuraAdministradorEstructuraDomain;

import java.util.List;
import java.util.UUID;

public interface EstructuraAdministradorEstructuraBusiness {
	void asignarEstructura(EstructuraAdministradorEstructuraDomain domain);

	List<EstructuraAdministradorEstructuraDomain> consultar(EstructuraAdministradorEstructuraDomain domain);

	void eliminar(UUID domain);

}
