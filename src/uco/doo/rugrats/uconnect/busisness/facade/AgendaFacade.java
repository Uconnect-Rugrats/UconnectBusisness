package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.busisness.domain.AgendaDomain;
import uco.doo.rugrats.uconnect.dto.AgendaDTO;
import java.util.List;
import java.util.UUID;

public interface AgendaFacade {
	void crear(AgendaDTO dto);

	void modificarFechaFinalizacion(AgendaDTO dto);

	void cambiarEstado(AgendaDTO dto);

	List<AgendaDTO> consultar(AgendaDTO dto);

	AgendaDomain abrir(AgendaDTO dto);

	void eliminar(UUID dto);

}
