package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReportePublicacionDomain;

import java.util.List;


public interface RespuestaReportePublicacionBusiness {
    void revisar(RespuestaReportePublicacionDomain domain);
    void cerrarRespuesta(RespuestaReportePublicacionDomain domain);
    List<RespuestaReportePublicacionDomain> abrir(RespuestaReportePublicacionDomain domain);
    void eliminar(RespuestaReportePublicacionDomain domain);
    EstadoDomain obtenerEstadoReal();
}
