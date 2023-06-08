package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EventoDTO;

import java.util.List;
import java.util.UUID;

public interface EventoFacade {
	void crear(EventoDTO dto);

	void editar(EventoDTO dto);

	void cambiarEstado(EventoDTO dto);

	List<EventoDTO> abrir(EventoDTO dto);

	void eliminar(UUID dto);

}
