package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ReaccionDomain;

import java.util.List;
import java.util.UUID;

public interface ReaccionBusiness {
    void reaccionar(ReaccionDomain domain);
    List<ReaccionDomain> mostrar(ReaccionDomain domain);
    void cambiarReaccion(ReaccionDomain domain);
    void eliminar(UUID domain);
    EstadoDomain obtenerEstadoReal();
}
