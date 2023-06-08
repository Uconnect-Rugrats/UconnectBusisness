package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.OrganizacionAdministradorOrganizacionDTO;

import java.util.List;
import java.util.UUID;

public interface OrganizacionAdministradorOrganizacionFacade {
	void asignarOrganizacion(OrganizacionAdministradorOrganizacionDTO dto);

	List<OrganizacionAdministradorOrganizacionDTO> consultar(OrganizacionAdministradorOrganizacionDTO dto);

	void eliminar(UUID dto);

}
