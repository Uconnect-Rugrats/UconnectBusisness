package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.MensajeDomain;

import java.util.List;


public interface MensajeBusiness {
    void enviar(MensajeDomain domain);
    void cambiarEstado(MensajeDomain domain);
    List<MensajeDomain> cargar(MensajeDomain domain);
    void eliminar(MensajeDomain domain);
    EstadoDomain obtenerEstadoReal();
}
