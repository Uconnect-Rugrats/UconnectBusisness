package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;

import java.util.List;

public interface EstadoFacade {
	List<EstadoDTO> consultar(EstadoDTO dto);
}
