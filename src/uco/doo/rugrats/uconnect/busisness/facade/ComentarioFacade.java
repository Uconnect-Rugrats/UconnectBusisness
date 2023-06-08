package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.ComentarioDTO;
import java.util.List;
import java.util.UUID;

public interface ComentarioFacade {
	void comentar(ComentarioDTO dto);

	void cambiarEstado(ComentarioDTO dto);

	List<ComentarioDTO> consultar(ComentarioDTO dto);

	void eliminar(UUID dto);
}
