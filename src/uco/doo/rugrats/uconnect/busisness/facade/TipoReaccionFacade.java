package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.TipoReaccionDTO;

import java.util.List;

public interface TipoReaccionFacade {
    List<TipoReaccionDTO> consultar(TipoReaccionDTO dto);
}
