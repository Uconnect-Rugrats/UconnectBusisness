package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.TipoOrganizacionDTO;

import java.util.List;

public interface TipoOrganizacionFacade {
    List<TipoOrganizacionDTO> consultar(TipoOrganizacionDTO dto);
}
