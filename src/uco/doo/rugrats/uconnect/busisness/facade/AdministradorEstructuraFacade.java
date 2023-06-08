package uco.doo.rugrats.uconnect.busisness.facade;

import uco.doo.rugrats.uconnect.dto.AdministradorEstructuraDTO;
import java.util.List;
import java.util.UUID;

public interface AdministradorEstructuraFacade {
	void concederPermisos(AdministradorEstructuraDTO dto);

	void cambiarEstado(AdministradorEstructuraDTO dto);

	List<AdministradorEstructuraDTO> consultar(AdministradorEstructuraDTO dto);

	void eliminar(UUID dto);

}
