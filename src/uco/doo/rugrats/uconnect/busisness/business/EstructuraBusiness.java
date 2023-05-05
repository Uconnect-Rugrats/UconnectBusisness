package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstructuraDomain;

import java.util.List;


public interface EstructuraBusiness {
    void crearNueva(EstructuraDomain domain);
    void cambiarNombre(EstructuraDomain domain);
    void cambiarEstado(EstructuraDomain domain);
    List<EstructuraDomain> consultar(EstructuraDomain domain);
    void eliminar(EstructuraDomain domain);
    EstadoDomain obtenerEstadoReal();
}
