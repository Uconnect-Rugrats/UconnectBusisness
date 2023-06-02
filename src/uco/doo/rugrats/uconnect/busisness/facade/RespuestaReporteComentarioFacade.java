package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.RespuestaReporteComentarioDTO;

import java.util.List;
import java.util.UUID;

public interface RespuestaReporteComentarioFacade {
	void revisar(RespuestaReporteComentarioDTO dto);

	void cerrarRespuesta(RespuestaReporteComentarioDTO dto);

	List<RespuestaReporteComentarioDTO> abrir(RespuestaReporteComentarioDTO dto);

	void eliminar(UUID dto);

	EstadoDTO obtenerEstadoReal();
}
