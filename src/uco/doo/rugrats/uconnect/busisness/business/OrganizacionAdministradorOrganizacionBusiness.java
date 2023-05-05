package uco.doo.rugrats.uconnect.busisness.business;

import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.OrganizacionAdministradorOrganizacionDomain;


import java.util.List;


public interface OrganizacionAdministradorOrganizacionBusiness {
    void asignarOrganizacion(OrganizacionAdministradorOrganizacionDomain domain);
    List<OrganizacionAdministradorOrganizacionDomain> consultar(OrganizacionAdministradorOrganizacionDomain domain);
    void eliminar(OrganizacionAdministradorOrganizacionDomain domain);
    EstadoDomain obtenerEstadoReal();
}
