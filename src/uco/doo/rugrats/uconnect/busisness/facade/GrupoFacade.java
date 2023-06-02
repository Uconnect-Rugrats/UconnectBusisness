package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.GrupoDTO;

import java.util.List;
import java.util.UUID;

public interface GrupoFacade {
	void crear(GrupoDTO dto);

	void editar(GrupoDTO dto);

	void cambiarEstado(GrupoDTO dto);

	List<GrupoDTO> buscar(GrupoDTO dto);

	void eliminar(UUID dto);

	EstadoDTO obtenerEstadoReal();
}
