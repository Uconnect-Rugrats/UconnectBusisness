package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.ReporteMensajeDTO;

import java.util.List;

public interface ReporteMensajeFacade {
    void reportar(ReporteMensajeDTO dto);
    void cambiarEstado(ReporteMensajeDTO dto);

    List<ReporteMensajeDTO> abrir(ReporteMensajeDTO dto);
    EstadoDTO obtenerEstadoReal();
}
