package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.AgendaDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;

import java.util.List;


public interface AgendaBusiness {
    void crear(AgendaDomain domain);
    void modificarFechaFinalizacion(AgendaDomain domain);
    void cambiarEstado(AgendaDomain domain);
    List<AgendaDomain> consultar(AgendaDomain domain);
    AgendaDomain abrir(AgendaDomain domain);
    void eliminar(AgendaDomain domain);
    EstadoDomain obtenerEstadoReal();
}
