package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.AgendaDomain;
import java.util.List;
import java.util.UUID;

public interface AgendaBusiness {
	void crear(AgendaDomain domain);

	void modificarFechaFinalizacion(AgendaDomain domain);

	void cambiarEstado(AgendaDomain domain);

	List<AgendaDomain> consultar(AgendaDomain domain);

	AgendaDomain abrir(AgendaDomain domain);

	void eliminar(UUID domain);
}
