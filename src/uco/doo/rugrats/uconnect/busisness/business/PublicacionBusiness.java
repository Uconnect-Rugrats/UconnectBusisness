package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.PublicacionDomain;

import java.util.List;

public interface PublicacionBusiness {
    void publicar(PublicacionDomain domain);
    void cambiarEstado(PublicacionDomain domain);
    List<PublicacionDomain> listar(PublicacionDomain domain);
    PublicacionDomain abrir(PublicacionDomain domain);
    void eliminar(PublicacionDomain domain);
    EstadoDomain obtenerEstadoReal();
}
