package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.AdministradorOrganizacionDTO;
import uco.doo.rugrats.uconnect.dto.EstadoDTO;

import java.util.List;
import java.util.UUID;

public interface AdministradorOrganizacionFacade {
    void concederPermisos(AdministradorOrganizacionDTO dto);
    void cambiarEstado(AdministradorOrganizacionDTO dto);
    List<AdministradorOrganizacionDTO> consultar(AdministradorOrganizacionDTO dto);
    void eliminar(UUID dto);
    EstadoDTO obtenerEstadoReal();
}
