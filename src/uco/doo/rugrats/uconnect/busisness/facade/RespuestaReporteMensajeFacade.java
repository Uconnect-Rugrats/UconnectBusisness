package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.RespuestaReporteMensajeDTO;

import java.util.List;
import java.util.UUID;

public interface RespuestaReporteMensajeFacade {
	void revisar(RespuestaReporteMensajeDTO dto);

	void cerrarRespuesta(RespuestaReporteMensajeDTO dto);

	List<RespuestaReporteMensajeDTO> abrir(RespuestaReporteMensajeDTO dto);

	void eliminar(UUID dto);

	EstadoDTO obtenerEstadoReal();
}
