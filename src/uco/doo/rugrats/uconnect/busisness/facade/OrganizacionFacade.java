package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.OrganizacionDTO;

import java.util.List;
import java.util.UUID;

public interface OrganizacionFacade {
	void crearNueva(OrganizacionDTO dto);

	void cambiarNombre(OrganizacionDTO dto);

	void cambiarEstado(OrganizacionDTO dto);

	List<OrganizacionDTO> consultar(OrganizacionDTO dto);

	void eliminar(UUID dto);
}
