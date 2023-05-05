package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReporteComentarioDomain;

import java.util.List;


public interface RespuestaReporteComentarioBusiness {
    void revisar(RespuestaReporteComentarioDomain domain);
    void cerrarRespuesta(RespuestaReporteComentarioDomain domain);
    List<RespuestaReporteComentarioDomain> abrir(RespuestaReporteComentarioDomain domain);
    void eliminar(RespuestaReporteComentarioDomain domain);
    EstadoDomain obtenerEstadoReal();
}
