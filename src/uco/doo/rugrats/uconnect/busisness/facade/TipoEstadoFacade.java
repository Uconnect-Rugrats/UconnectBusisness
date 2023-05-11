package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.TipoEstadoDTO;

import java.util.List;

public interface TipoEstadoFacade {
    List<TipoEstadoDTO> consultar(TipoEstadoDTO dto);
}
