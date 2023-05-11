package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.ReaccionDTO;

import java.util.List;
import java.util.UUID;

public interface ReaccionFacade {
    void reaccionar(ReaccionDTO dto);
    List<ReaccionDTO> mostrar(ReaccionDTO dto);
    void eliminar(UUID dto);
    EstadoDTO obtenerEstadoReal();
}
