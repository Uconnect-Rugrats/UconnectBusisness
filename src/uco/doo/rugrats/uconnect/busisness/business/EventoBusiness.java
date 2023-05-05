package uco.doo.rugrats.uconnect.busisness.business;


import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EventoDomain;

import java.util.List;


public interface EventoBusiness {
    void crear(EventoDomain domain);
    void editar(EventoDomain domain);
    void cambiarEstado(EventoDomain domain);
    List<EventoDomain> abrir(EventoDomain domain);
    void eliminar(EventoDomain domain);
    EstadoDomain obtenerEstadoReal();
}