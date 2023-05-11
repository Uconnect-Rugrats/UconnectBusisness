package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.ReportePublicacionDTO;

import java.util.List;

public interface ReportePublicacionFacade {
    void reportar(ReportePublicacionDTO dto);
    void cambiarEstado(ReportePublicacionDTO dto);
    List<ReportePublicacionDTO> abrir(ReportePublicacionDTO dto);
    EstadoDTO obtenerEstadoReal();
}
