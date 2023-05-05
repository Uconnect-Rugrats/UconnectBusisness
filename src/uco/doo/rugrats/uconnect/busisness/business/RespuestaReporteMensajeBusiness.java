package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.RespuestaReporteMensajeDomain;


import java.util.List;


public interface RespuestaReporteMensajeBusiness {
    void revisar(RespuestaReporteMensajeDomain domain);
    void cerrarRespuesta(RespuestaReporteMensajeDomain domain);
    List<RespuestaReporteMensajeDomain> abrir(RespuestaReporteMensajeDomain domain);
    void eliminar(RespuestaReporteMensajeDomain domain);
    EstadoDomain obtenerEstadoReal();
}
