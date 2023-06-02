package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.EstructuraAdministradorEstructuraDTO;

import java.util.List;
import java.util.UUID;

public interface EstructuraAdministradorEstructuraFacade {
	void asignarEstructura(EstructuraAdministradorEstructuraDTO dto);

	List<EstructuraAdministradorEstructuraDTO> consultar(EstructuraAdministradorEstructuraDTO dto);

	void eliminar(UUID dto);

	EstadoDTO obtenerEstadoReal();
}
