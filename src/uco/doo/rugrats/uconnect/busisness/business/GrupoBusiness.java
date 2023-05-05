package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.GrupoDomain;

import java.util.List;


public interface GrupoBusiness {
    void crear(GrupoDomain domain);
    void editar(GrupoDomain domain);
    void cambiarEstado(GrupoDomain domain);
    List<GrupoDomain> buscar(GrupoDomain domain);
    void eliminar(GrupoDomain domain);
    EstadoDomain obtenerEstadoReal();
}
