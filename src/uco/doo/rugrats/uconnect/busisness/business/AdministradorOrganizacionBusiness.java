package uco.doo.rugrats.uconnect.busisness.business;


import uco.doo.rugrats.uconnect.busisness.domain.AdministradorOrganizacionDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;

import java.util.List;

public interface AdministradorOrganizacionBusiness {
    void concederPermisos(AdministradorOrganizacionDomain domain);
    void cambiarEstado(AdministradorOrganizacionDomain domain);
    List<AdministradorOrganizacionDomain> consultar(AdministradorOrganizacionDomain domain);
    void eliminar(AdministradorOrganizacionDomain domain);
    EstadoDomain obtenerEstadoReal();
}
