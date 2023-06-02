package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.PublicacionDTO;

import java.util.List;
import java.util.UUID;

public interface PublicacionFacade {
	void publicar(PublicacionDTO dto);

	void cambiarEstado(PublicacionDTO dto);

	List<PublicacionDTO> listar(PublicacionDTO dto);

	PublicacionDTO abrir(PublicacionDTO dto);

	void eliminar(UUID dto);

	EstadoDTO obtenerEstadoReal();
}
