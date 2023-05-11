package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.EstadoDTO;
import uco.doo.rugrats.uconnect.dto.RespuestaReportePublicacionDTO;

import java.util.List;
import java.util.UUID;

public interface RespuestaReportePublicacionFacade {
    void revisar(RespuestaReportePublicacionDTO dto);
    void cerrarRespuesta(RespuestaReportePublicacionDTO dto);
    List<RespuestaReportePublicacionDTO> abrir(RespuestaReportePublicacionDTO dto);
    void eliminar(UUID dto);
    EstadoDTO obtenerEstadoReal();
}
