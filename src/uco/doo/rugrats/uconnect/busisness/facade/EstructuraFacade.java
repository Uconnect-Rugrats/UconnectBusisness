package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.EstructuraDTO;

import java.util.List;
import java.util.UUID;

public interface EstructuraFacade {
	void crearNueva(EstructuraDTO dto);

	void cambiarNombre(EstructuraDTO dto);

	void cambiarEstado(EstructuraDTO dto);

	List<EstructuraDTO> consultar(EstructuraDTO dto);

	void eliminar(UUID dto);

	EstadoDTO obtenerEstadoReal();
}
