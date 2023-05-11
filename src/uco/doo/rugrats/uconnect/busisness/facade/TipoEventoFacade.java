package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.TipoEventoDTO;

import java.util.List;

public interface TipoEventoFacade {
    List<TipoEventoDTO> consultar(TipoEventoDTO dto);
}
