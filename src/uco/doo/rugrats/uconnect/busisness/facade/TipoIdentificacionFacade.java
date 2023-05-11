package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.TipoIdentificacionDTO;

import java.util.List;

public interface TipoIdentificacionFacade {
    List<TipoIdentificacionDTO> consultar(TipoIdentificacionDTO dto);
}
