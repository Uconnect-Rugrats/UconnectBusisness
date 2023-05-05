package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.ComentarioDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;

import java.util.List;

public interface ComentarioBusiness {
    void comentar(ComentarioDomain domain);
    void cambiarEstado(ComentarioDomain domain);
    List<ComentarioDomain> consultar(ComentarioDomain domain);
    void eliminar(ComentarioDomain domain);
    EstadoDomain obtenerEstadoReal();
}
