package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ReaccionDomain;

import java.util.List;

public interface ReaccionBusiness {
    void reaccionar(ReaccionDomain domain);
    List<ReaccionDomain> mostrar(ReaccionDomain domain);
    void eliminar(ReaccionDomain domain);
    EstadoDomain obtenerEstadoReal();
}
