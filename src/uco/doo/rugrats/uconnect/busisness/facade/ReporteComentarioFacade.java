package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.ReporteComentarioDTO;

import java.util.List;

public interface ReporteComentarioFacade {
	void reportar(ReporteComentarioDTO dto);

	void cambiarEstado(ReporteComentarioDTO dto);

	List<ReporteComentarioDTO> abrir(ReporteComentarioDTO dto);

}
