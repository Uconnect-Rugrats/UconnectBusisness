package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.MensajeDomain;

import java.util.List;
import java.util.UUID;


public interface MensajeBusiness {
    void enviar(MensajeDomain domain);
    void cambiarEstado(MensajeDomain domain);
    List<MensajeDomain> cargar(MensajeDomain domain);
    void eliminar(UUID domain);
    EstadoDomain obtenerEstadoReal();
}
